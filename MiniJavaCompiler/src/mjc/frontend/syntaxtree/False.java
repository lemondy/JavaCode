package mjc.frontend.syntaxtree;

import java.util.Hashtable;

import mjc.frontend.symboltree.MethodNode;

public class False extends Exp{

    public False() {}
    
    public False(int l, int c) {
    setPosition(l,c);
    }

    public String toString() {
        return "false";
    }
    
    public String strRepr(int level) {
        return "<false>\n";
    }
    
    public Type getType(Hashtable st, String cc, String cm) throws TypeException {
        return new BooleanType();
    }

    
    public String generateFetchJVM(MethodNode method) {
        return "iconst_0\n";
    }
    
    public String generateStoreJVM(MethodNode method) {
        return "";
    }
    
    public int maxDepth(int methodDepth, Hashtable<String,MethodNode> symboltrees) {
        return 1;
    }
}