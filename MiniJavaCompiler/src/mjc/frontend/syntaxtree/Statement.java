package mjc.frontend.syntaxtree;

import java.util.Hashtable;

import mjc.frontend.symboltree.MethodNode;

public abstract class Statement extends MiniJavaParserToken {
    
    public Statement(){}
    
    public abstract boolean typeCheck(Hashtable symbolTrees, String currentClass, String currentMethod) throws TypeException;

    public abstract String generateJVM(MethodNode method);
    
    public abstract int maxDepth(int methodDepth, Hashtable<String, MethodNode> symboltrees);
}