package mjc.frontend.syntaxtree;


public class ClassDeclList extends SyntaxTreeList {
    
    public ClassDeclList() {
        super("class_list");
    }

    public void addElement(ClassDecl s){
	    list.addElement(s);
    }

    public ClassDecl elementAt(int i){
	    return (ClassDecl)list.elementAt(i);
    }
    
}