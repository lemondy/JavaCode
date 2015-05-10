package mjc.frontend.syntaxtree;

import java.util.Hashtable;

import mjc.frontend.symboltree.MethodNode;

public class ArrayLookup extends Exp{

    private Exp e1;
    private Exp e2;

    public ArrayLookup(){}
    
    public ArrayLookup(Exp exp1, Exp exp2){
	e1=exp1;
	e2=exp2;
    }

    public String toString() {
        return "(" + e1 + ")[" + e2 + "]";
    }
    
    public String strRepr(int level) {
        return String.format(
            "%s<array_lookup>\n%s<index>\n%s%s</index>\n%s<exp>\n%s%s</exp>\n%s</array_lookup>\n",
            tab(level), tab(level+1), e1.strRepr(level+2), tab(level+1),
                        tab(level+1), e2.strRepr(level+2), tab(level+1), tab(level));
    }
    
    public Type getType(Hashtable symbolTrees, String currentClass, String currentMethod) throws TypeException {
        IntegerType it = new IntegerType();
        if (!e1.getType(symbolTrees, currentClass, currentMethod).equals(new IntArrayType())) {
            throw new TypeException("Array lookup requires type int[]. "  + e1.getPosition());
        }
        if (!e2.getType(symbolTrees, currentClass, currentMethod).equals(it)) {
            throw new TypeException("Index must be integer. "  + e2.getPosition());
        }
        return it;    
    }
      
    
    public String generateFetchJVM(MethodNode method) {
        String jvmCode = String.format("%s%siaload\n", e1.generateFetchJVM(method), e2.generateFetchJVM(method));
        return jvmCode;
    }
    
    public String generateStoreJVM(MethodNode method) {
        return "";
    }
    
    public int maxDepth(int methodDepth, Hashtable<String,MethodNode> symboltrees) {
        return Math.max(e1.maxDepth(methodDepth, symboltrees), e2.maxDepth(methodDepth, symboltrees) + 1);
    }
}