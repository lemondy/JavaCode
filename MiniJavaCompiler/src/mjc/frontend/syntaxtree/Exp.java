package mjc.frontend.syntaxtree;

import java.util.Hashtable;

import mjc.frontend.symboltree.MethodNode;

public abstract class Exp extends MiniJavaParserToken {
    
    public Exp() {}
    
    
    public abstract Type getType(Hashtable symbolTrees, String currentClass, String currentMethod) throws TypeException;

    public abstract String generateFetchJVM(MethodNode method);

    public abstract String generateStoreJVM(MethodNode method);
    
    public abstract int maxDepth(int methodDepth, Hashtable<String,MethodNode> symboltrees);
    
    public String paramStrRepr(int level) {
        return String.format("%s<parameter>\n%s%s</parameter>\n",
            tab(level), this.strRepr(level+1), tab(level));
    }
}
