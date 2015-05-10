package mjc.frontend.syntaxtree;

public abstract class MiniJavaParserToken {
    private int line;
    private int column;
    
    public void setPosition(int l, int c) {
        line = l;
        column = c;
    }
      
    public abstract String strRepr(int level);
    
    public String paramStrRepr(int level) { return strRepr(level); }
    
    public String tab(int level) {
        return String.format("%"+level+"s","");
    }
    
    public int getLine() {
        return line;
    }
    
    public int getColumn() {
        return column;
    }
       
    public String getPosition() {
        return String.format("(line %d, col %d)", getLine(), getColumn());
    }
}