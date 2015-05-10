package mjc.frontend;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Hashtable;

import mjc.frontend.symboltree.MethodNode;
import mjc.frontend.symboltree.Node;
import mjc.frontend.syntaxtree.ClassDecl;
import mjc.frontend.syntaxtree.ClassDeclList;
import mjc.frontend.syntaxtree.MethodDecl;
import mjc.frontend.syntaxtree.MethodDeclList;
import mjc.frontend.syntaxtree.Program;
import mjc.frontend.syntaxtree.StatementList;
import mjc.frontend.syntaxtree.TypeException;
import mjc.frontend.syntaxtree.VarDecl;
import mjc.frontend.syntaxtree.VarDeclList;

public class Frontend {
    boolean errorFlag = false;
    ArrayList<String> names = new ArrayList<String>();
    
    public Frontend(String args) {
        MiniJavaParser mjp = new MiniJavaParser();
        try {
	        InputStream fileContent = readFile(args);      
            System.out.println("Building abstract syntax tree...");
            Program prog = mjp.parse(fileContent);
            ClassDeclList cdl = prog.getClassDeclList();
            for (int i=0; i<cdl.size(); i++) {
                names.add(cdl.elementAt(i).name());
            }
	    	saveToFile(prog.strRepr(0), names.get(0), ".syntax");
            System.out.println("Finished building.\nBuilding symbol tree...");
            
            //符号树
            Hashtable<String, MethodNode> symboltable = new Hashtable<String, MethodNode>();
            inheritanceCheck(cdl, symboltable);
            String toSymbolOut;
            toSymbolOut = String.format("Main class: %s\n\n", cdl.elementAt(0).name());
            for (int j=0; j < cdl.size(); j++){
                MethodNode cd = symboltable.get(cdl.elementAt(j).name());
                toSymbolOut += cd;
                MethodDeclList mdl = cdl.elementAt(j).getMethodDeclList();
                for (int k=0; k < mdl.size(); k++){
                    MethodNode md=symboltable.get(String.format("%s.%s",
                        cdl.elementAt(j).name(), mdl.elementAt(k).name()));
                    toSymbolOut += md;
                }
                toSymbolOut += "\n\n";
            }

	    saveToFile(toSymbolOut, names.get(0), ".symbol");

            System.out.println("Finished building.\nType checking...");
            typeCheck(prog, symboltable);
            
            System.out.println("Finished type checking.\nTranslating to JVM...");
            ArrayList<String> jvmCode = generateJVM(prog, symboltable);
            saveToFile(jvmCode, names, ".j");
            System.out.println("Finished translating.");
        } catch (IOException e) {
	        errorFlag=true;
	        System.out.println(e);
        } catch (ParseException e) {
	        errorFlag=true;
            System.out.println(e);
        } catch (DeclarationException e) {
	        errorFlag=true;
            System.out.println(e);
        } catch (TypeException e) {
	        errorFlag=true;
            System.out.println(e);
        }
    }

    
    // Generates symboltrees for the classes and puts them in the hashtable,
    // while checking that there is no bad inheritance.
    public void inheritanceCheck(ClassDeclList cdl, Hashtable<String, MethodNode> symboltrees)
        throws DeclarationException {
        Hashtable<String, ClassDecl> superClasses = new Hashtable<String, ClassDecl>(cdl.size()*2);
        ArrayList<ClassDecl> subClasses = new ArrayList<ClassDecl>();
        ClassDecl current;
        for (int i= 0; i < cdl.size(); i++) {
            current=cdl.elementAt(i);
	    	checkOverride(current);
            if ( !current.extendsSomething() ) {
                classSymbolTree(current, symboltrees, new ArrayList<Node>(), new ArrayList<String>());
                superClasses.put(current.name(), current);
            } else {
                subClasses.add(current);
            }
        }
        int counter = 1;
        int maxCount = subClasses.size();
        while (subClasses.size() > 0 && counter <= maxCount) {
            for ( int i=0; i<subClasses.size(); i++) {
                ClassDecl subClass = subClasses.get(i);
                String extension = subClass.getExtends();
                if ( superClasses.containsKey(extension) ) {
	                ClassDecl superClass = superClasses.get(extension);
                    subClasses.remove(i);
                    superClasses.put(subClass.name(), subClass);
                    checkOverride(subClass, superClass);
                    classSymbolTree(subClass, symboltrees, superClass.getClassNodes(),
                        superClass.getSuperClassNames());
                }

            }
            counter++;
        }
        if (subClasses.size() > 0) {
            ClassDecl broken = subClasses.get(0);
            String classes = "";
            for (int i=0; i<subClasses.size(); i++) {
                classes += String.format("%s extends %s %s\n",
                    broken.name(), broken.getExtends(), broken.getPosition());
            }
            throw new DeclarationException(String.format(
                "Extension error. The following classes contain circular inheritance"+
                " or extend unknown classes:\n%s", classes));
        }
    }

    
    // Checks that if any method in the subclass has the same name as on in the superclass,
    // they need to have the same signature.

    public void checkOverride(ClassDecl klas) throws DeclarationException{
	MethodDeclList methods = klas.getMethodDeclList();      //同一个类中的所有的方法声明都在一个MethodDeclList中
	MethodDecl met;
	for (int j=0; j < methods.size(); j++){
	    met=methods.elementAt(j);       //将第i个方法与i+1到methods.size()个元素进行比较，看是否相同
	    for (int k=j+1; k < methods.size(); k++) 
		if ((methods.elementAt(k).name()).equals(met.name())) 
		throw new DeclarationException(String.format(
		     "Method  %s %s declared twice in %s", met.type(), met.name(), klas.name()));

	}
    }


    public void checkOverride(ClassDecl subClass, ClassDecl superClass)
        throws DeclarationException {
        MethodDeclList newMethods = subClass.getMethodDeclList();
        MethodDeclList oldMethods = superClass.getMethodDeclList();


        for (int i=0; i<newMethods.size(); i++) {
            MethodDecl newMethod = newMethods.elementAt(i);
            MethodDecl oldMethod = oldMethods.getMethodDecl(newMethod.name());
            if (oldMethod != null) {
                if (!newMethod.equals(oldMethod)) {
                    throw new DeclarationException(String.format(
                        "Method %s %s (%s) in %s cannot override method %s %s (%s) in %s. %s",
                        newMethod.type(), newMethod.name(),
                        newMethod.getFormalList().getTypesString(), subClass.name(),
                        oldMethod.type(), oldMethod.name(),
                        oldMethod.getFormalList().getTypesString(), superClass.name(),
                        newMethod.getPosition()));
                }
            }
        }
    }
    
    public ArrayList<String> getNames() {
        return names;
    }
    
    public ArrayList<String> generateJVM(Program prog, Hashtable<String, MethodNode> symboltrees) {
        ArrayList<String> jvmCode = new ArrayList<String>();
        ClassDeclList cdl = prog.getClassDeclList();
        for (int i= 0; i < cdl.size(); i++) {
            jvmCode.add(cdl.elementAt(i).generateJVM(symboltrees));
        }
        return jvmCode;
    }
    
    /*public static void main(String[] args) {
        Frontend fe = new Frontend(args);
    }*/
    
    public static void classSymbolTree(ClassDecl cd, Hashtable<String, MethodNode> symbolTrees,
    	ArrayList<Node> superClasses, ArrayList<String> superClassNames)
        throws DeclarationException {
        if (symbolTrees.containsKey(cd.name())) throw new DeclarationException(String.format(
        	"Class %s already declared. %s", cd.name(), cd.getPosition()));          
        MethodNode root = new MethodNode(cd);
        symbolTrees.put(cd.name(), root);
        VarDeclList vdl = cd.getVarDeclList();
        for (int i = 0; i < vdl.size(); i++) {
            VarDecl vd = vdl.elementAt(i);
            Boolean b = root.addLocalNode(makeNode(vd));
            if (!b) {
                throw new DeclarationException(
                    String.format("Class variable %s already declared. %s",
                        vd.name(), vd.getPosition()));
            }
        }
        ArrayList<Node> classes = new ArrayList<Node>();
        classes.add(root.getRight());
        classes.addAll(superClasses);
	    cd.addClassNodes(classes);
        ArrayList<String> classNames = new ArrayList<String>();
        classNames.add(cd.name());
        classNames.addAll(superClassNames);
        cd.addSuperClassNames(classNames);
//         System.out.println("superclasses: " + classes);
        MethodDeclList mdl = cd.getMethodDeclList();
        for (int j = 0; j < mdl.size(); j++) {
            MethodDecl md = mdl.elementAt(j);
            methodSymbolTree(md, cd, symbolTrees, md.isStatic());
        }
    }
    
    public static void methodSymbolTree(MethodDecl md, ClassDecl cd,
        Hashtable<String, MethodNode> symbolTrees, boolean isStatic)
            throws DeclarationException {
        String className = cd.name();
        MethodNode root = md.getMethodNode(cd);
        symbolTrees.put(String.format("%s.%s", className, md.name()), root);
//         if (classTree != null) root.addClassNodes(classTree);
//         System.out.println("Frontend.methodSymbolTree: " + cd.getClassNodes());
        root.setClassNodes(cd.getClassNodes());
        VarDeclList fl = md.getFormalList();
        VarDeclList vdl = md.getVarDeclList();
        VarDecl vd;
        int extraParameter = (isStatic)?0:1;
        for (int i = 0; i < fl.size(); i++) {
            vd = fl.elementAt(i);
            if (!root.addParameterNode(makeNode(vd, i + extraParameter)))
                throw new DeclarationException(
                    String.format("Parameter %s already declared. %s",
                        vd.name(), vd.getPosition()));
        }
        for (int i = 0; i < vdl.size(); i++) {
            vd = vdl.elementAt(i);
            if (!root.addLocalNode(makeNode(vd, i + fl.size() + extraParameter))){
                throw new DeclarationException(
                    String.format("Local variable %s already declared. %s",
                        vd.name(), vd.getPosition()));
	    }
        } 
    }
    
    public static Node makeNode(VarDecl vd) {
        return new Node(vd.name(), vd.type());
    }
    
    // Number the variable as a method local
    public static Node makeNode(VarDecl vd, int i) {
        Node n = new Node(vd.name(), vd.type());
        n.setVarNumb(i);
        return n;
    }
    
    // Type check a program given a set of symbol tables
    public static void typeCheck(Program prog, Hashtable<String, MethodNode> symbolTrees)
        throws TypeException  {
        ClassDeclList cdl = prog.getClassDeclList();
        for (int c=0; c<cdl.size(); c++) {
            MethodDeclList mdl = cdl.elementAt(c).getMethodDeclList();
            for (int i = 0; i < mdl.size(); i++) {
                typeCheck(symbolTrees, cdl.elementAt(c), mdl.elementAt(i));
            }
        }
    }
    
    // Type check a method given a set of symbol tables
    public static void typeCheck(Hashtable<String, MethodNode> symbolTrees, ClassDecl cd, MethodDecl md)
        throws TypeException {
        StatementList sl = md.getStatementList();
        for (int i = 0; i < sl.size(); i++) {
            sl.elementAt(i).typeCheck(symbolTrees, cd.name(), md.name());
        }
        md.typeCheck(symbolTrees, cd.name(), md.name());
    }
    
    public void saveToFile(ArrayList<String> jvmCode, ArrayList<String> names, String fileext) {
        for (int i=0; i<jvmCode.size(); i++)
            saveToFile(jvmCode.get(i), names.get(i), fileext);
    }
    
    public void saveToFile(String content, String name, String fileext) {
        try {
            File outputDoc = new File (name + fileext);
            FileWriter fw = new FileWriter(outputDoc);
            BufferedWriter out = new BufferedWriter(fw);
            out.write(content);
            out.close();
        }
        catch (IOException e) { errorFlag=true; System.out.println(e); }
    }
    
	public static InputStream readFile(String fileName) throws IOException {
		File f = new File(fileName);
		return new FileInputStream(f);
	}

    public boolean getError(){ return errorFlag;}
}