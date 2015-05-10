package mjc.frontend.syntaxtree;

import java.util.Hashtable;

import mjc.frontend.symboltree.MethodNode;

public class True extends Exp{

    public True() {}

    public True(int l, int c) {
    setPosition(l,c);
    }

    public String toString() {
        return "true";
    }
    
    public String strRepr(int level) {
        return "<true>\n";
    }
    
    public Type getType(Hashtable st, String cc, String cm) throws TypeException {
        return new BooleanType();
    }
    
    public String generateFetchJVM(MethodNode method) {
        return "iconst_1\n";
    }
    
    public String generateStoreJVM(MethodNode method) {
        return "";
    }
    
    public int maxDepth(int methodDepth, Hashtable<String, MethodNode> symboltrees) {
        return 1;
    }
}