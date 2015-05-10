package mjc.frontend.syntaxtree;

import java.util.Hashtable;

import mjc.frontend.symboltree.MethodNode;

public class ArrayAssign extends Statement{

    private IdentifierExp ie;
    private Exp e1;
    private Exp e2;

    public ArrayAssign(){}
    
    public ArrayAssign(IdentifierExp id, Exp exp1, Exp exp2){
	ie=id;
	e1=exp1;
	e2=exp2;
    }
    
    public String toString() {
        return "(" + ie + ")[" + e1 + "] = " + e2;
    }
    
    public String strRepr(int level) {
        return String.format(
            "%s<array_assign name=%s>\n%s<index>\n%s%s</index>\n%s<exp>\n%s%s</exp>\n%s</array_assign>\n",
            tab(level), ie,
            tab(level+1), e1.strRepr(level+2), tab(level+1),
            tab(level+1), e2.strRepr(level+2), tab(level+1),
            tab(level));
    }
    
    public boolean typeCheck(Hashtable symbolTrees, String currentClass, String currentMethod) throws TypeException{
        IntegerType it = new IntegerType();
        if (!ie.getType(symbolTrees, currentClass, currentMethod).equals(new IntArrayType())) {
            throw new TypeException("Variable of integer array type required. " + ie.getPosition());
        }
        if (!e1.getType(symbolTrees, currentClass, currentMethod).equals(it)) {
            throw new TypeException("Index must be of integer type. " + e1.getPosition());
        }
        if (!e2.getType(symbolTrees, currentClass, currentMethod).equals(it)) {
            throw new TypeException("Variable of integer type required. " + e2.getPosition());
        }
        return true;
    }

    
    public String generateJVM(MethodNode method) {
        String jvmCode = String.format("%s%s%siastore\n", ie.generateFetchJVM(method),
            e1.generateFetchJVM(method), e2.generateFetchJVM(method));
        return jvmCode;
    }
    
    public int maxDepth(int methodDepth, Hashtable<String,MethodNode> symboltrees) {
        return Math.max(ie.maxDepth(methodDepth, symboltrees),
                        Math.max(e1.maxDepth(methodDepth, symboltrees) + 1,
                                 e2.maxDepth(methodDepth, symboltrees) + 2));
    }
}