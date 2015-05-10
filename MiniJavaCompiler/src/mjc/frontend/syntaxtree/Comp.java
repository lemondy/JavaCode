package mjc.frontend.syntaxtree;

import java.util.Hashtable;

import mjc.frontend.symboltree.MethodNode;


public class Comp extends Binop {
    String desc;

    public Comp(Exp exp1, Exp exp2, String o) {
    	super(exp1, exp2, o);
    	desc = opToDesc.get(o);
    }
    
    public Type getType(Hashtable symbolTrees, String currentClass, String currentMethod)
        throws TypeException {
        IntegerType it = new IntegerType();
        if (!e1.getType(symbolTrees, currentClass, currentMethod).equals(it)) {
            throw new TypeException(String.format("%s requires boolean type. %s", op, e1.getPosition()));
        }
        if (!e2.getType(symbolTrees, currentClass, currentMethod).equals(it)) {
            throw new TypeException(String.format("%s requires boolean type. %s", op, e2.getPosition()));
        }
        return new BooleanType();
    }
    
    
    public String generateFetchJVM(MethodNode method) {
        Label t = new Label();
        Label end = new Label();
        return String.format(
            "%s%sif_icmp%s %s\niconst_0\ngoto %s\n%s:\niconst_1\n%s:\n",
            e1.generateFetchJVM(method), e2.generateFetchJVM(method), desc, t, end, t, end);
    }
}