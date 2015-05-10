//
// Generated by JTB 1.3.2
//

package visitor;
import syntaxtree.*;
import java.util.*;

/**
 * All GJ visitors with no argument must implement this interface.
 */

public interface GJNoArguVisitor<R> {

   //
   // GJ Auto class visitors with no argument
   //

   public R visit(NodeList n);
   public R visit(NodeListOptional n);
   public R visit(NodeOptional n);
   public R visit(NodeSequence n);
   public R visit(NodeToken n);

   //
   // User-generated visitor methods below
   //

   /**
    * f0 -> n0=MainClass()
    * f1 -> ( n2=TypeDeclaration() )*
    * f2 -> n4=<EOF>
    */
   public R visit(Goal n);

   /**
    * f0 -> n1="class"
    * f1 -> n2=Identifier()
    * f2 -> n4="{"
    * f3 -> n6="public"
    * f4 -> n8="static"
    * f5 -> n10="void"
    * f6 -> n12="main"
    * f7 -> n14="("
    * f8 -> n16="String"
    * f9 -> n18="["
    * f10 -> n20="]"
    * f11 -> n21=Identifier()
    * f12 -> n23=")"
    * f13 -> n25="{"
    * f14 -> n26=PrintStatement()
    * f15 -> n28="}"
    * f16 -> n30="}"
    */
   public R visit(MainClass n);

   /**
    * f0 -> ( n1=ClassDeclaration() | n2=ClassExtendsDeclaration() )
    */
   public R visit(TypeDeclaration n);

   /**
    * f0 -> n1="class"
    * f1 -> n2=Identifier()
    * f2 -> n4="{"
    * f3 -> ( n6=VarDeclaration() )*
    * f4 -> ( n8=MethodDeclaration() )*
    * f5 -> n10="}"
    */
   public R visit(ClassDeclaration n);

   /**
    * f0 -> n1="class"
    * f1 -> n2=Identifier()
    * f2 -> n4="extends"
    * f3 -> n5=Identifier()
    * f4 -> n7="{"
    * f5 -> ( n9=VarDeclaration() )*
    * f6 -> ( n11=MethodDeclaration() )*
    * f7 -> n13="}"
    */
   public R visit(ClassExtendsDeclaration n);

   /**
    * f0 -> n0=Type()
    * f1 -> n1=Identifier()
    * f2 -> n3=";"
    */
   public R visit(VarDeclaration n);

   /**
    * f0 -> n1="public"
    * f1 -> n2=Type()
    * f2 -> n3=Identifier()
    * f3 -> n5="("
    * f4 -> ( n7=FormalParameterList() )?
    * f5 -> n9=")"
    * f6 -> n11="{"
    * f7 -> ( n13=VarDeclaration() )*
    * f8 -> ( n15=Statement() )*
    * f9 -> n17="return"
    * f10 -> n18=Expression()
    * f11 -> n20=";"
    * f12 -> n22="}"
    */
   public R visit(MethodDeclaration n);

   /**
    * f0 -> n0=FormalParameter()
    * f1 -> ( n2=FormalParameterRest() )*
    */
   public R visit(FormalParameterList n);

   /**
    * f0 -> n0=Type()
    * f1 -> n1=Identifier()
    */
   public R visit(FormalParameter n);

   /**
    * f0 -> n1=","
    * f1 -> n2=FormalParameter()
    */
   public R visit(FormalParameterRest n);

   /**
    * f0 -> ( n1=ArrayType() | n2=BooleanType() | n3=IntegerType() | n4=Identifier() )
    */
   public R visit(Type n);

   /**
    * f0 -> n1="int"
    * f1 -> n3="["
    * f2 -> n5="]"
    */
   public R visit(ArrayType n);

   /**
    * f0 -> n1="boolean"
    */
   public R visit(BooleanType n);

   /**
    * f0 -> n1="int"
    */
   public R visit(IntegerType n);

   /**
    * f0 -> ( n1=Block() | n2=AssignmentStatement() | n3=ArrayAssignmentStatement() | n4=IfStatement() | n5=WhileStatement() | n6=PrintStatement() )
    */
   public R visit(Statement n);

   /**
    * f0 -> n1="{"
    * f1 -> ( n3=Statement() )*
    * f2 -> n5="}"
    */
   public R visit(Block n);

   /**
    * f0 -> n0=Identifier()
    * f1 -> n2="="
    * f2 -> n3=Expression()
    * f3 -> n5=";"
    */
   public R visit(AssignmentStatement n);

   /**
    * f0 -> n0=Identifier()
    * f1 -> n2="["
    * f2 -> n3=Expression()
    * f3 -> n5="]"
    * f4 -> n7="="
    * f5 -> n8=Expression()
    * f6 -> n10=";"
    */
   public R visit(ArrayAssignmentStatement n);

   /**
    * f0 -> n1="if"
    * f1 -> n3="("
    * f2 -> n4=Expression()
    * f3 -> n6=")"
    * f4 -> n7=Statement()
    * f5 -> n9="else"
    * f6 -> n10=Statement()
    */
   public R visit(IfStatement n);

   /**
    * f0 -> n1="while"
    * f1 -> n3="("
    * f2 -> n4=Expression()
    * f3 -> n6=")"
    * f4 -> n7=Statement()
    */
   public R visit(WhileStatement n);

   /**
    * f0 -> n1="System.out.println"
    * f1 -> n3="("
    * f2 -> n4=Expression()
    * f3 -> n6=")"
    * f4 -> n8=";"
    */
   public R visit(PrintStatement n);

   /**
    * f0 -> ( n1=AndExpression() | n2=CompareExpression() | n3=PlusExpression() | n4=MinusExpression() | n5=TimesExpression() | n6=ArrayLookup() | n7=ArrayLength() | n8=MessageSend() | n9=PrimaryExpression() )
    */
   public R visit(Expression n);

   /**
    * f0 -> n0=PrimaryExpression()
    * f1 -> n2="&&"
    * f2 -> n3=PrimaryExpression()
    */
   public R visit(AndExpression n);

   /**
    * f0 -> n0=PrimaryExpression()
    * f1 -> n2="<"
    * f2 -> n3=PrimaryExpression()
    */
   public R visit(CompareExpression n);

   /**
    * f0 -> n0=PrimaryExpression()
    * f1 -> n2="+"
    * f2 -> n3=PrimaryExpression()
    */
   public R visit(PlusExpression n);

   /**
    * f0 -> n0=PrimaryExpression()
    * f1 -> n2="-"
    * f2 -> n3=PrimaryExpression()
    */
   public R visit(MinusExpression n);

   /**
    * f0 -> n0=PrimaryExpression()
    * f1 -> n2="*"
    * f2 -> n3=PrimaryExpression()
    */
   public R visit(TimesExpression n);

   /**
    * f0 -> n0=PrimaryExpression()
    * f1 -> n2="["
    * f2 -> n3=PrimaryExpression()
    * f3 -> n5="]"
    */
   public R visit(ArrayLookup n);

   /**
    * f0 -> n0=PrimaryExpression()
    * f1 -> n2="."
    * f2 -> n4="length"
    */
   public R visit(ArrayLength n);

   /**
    * f0 -> n0=PrimaryExpression()
    * f1 -> n2="."
    * f2 -> n3=Identifier()
    * f3 -> n5="("
    * f4 -> ( n7=ExpressionList() )?
    * f5 -> n9=")"
    */
   public R visit(MessageSend n);

   /**
    * f0 -> n0=Expression()
    * f1 -> ( n2=ExpressionRest() )*
    */
   public R visit(ExpressionList n);

   /**
    * f0 -> n1=","
    * f1 -> n2=Expression()
    */
   public R visit(ExpressionRest n);

   /**
    * f0 -> ( n1=IntegerLiteral() | n2=TrueLiteral() | n3=FalseLiteral() | n4=Identifier() | n5=ThisExpression() | n6=ArrayAllocationExpression() | n7=AllocationExpression() | n8=NotExpression() | n9=BracketExpression() )
    */
   public R visit(PrimaryExpression n);

   /**
    * f0 -> n1=<INTEGER_LITERAL>
    */
   public R visit(IntegerLiteral n);

   /**
    * f0 -> n1="true"
    */
   public R visit(TrueLiteral n);

   /**
    * f0 -> n1="false"
    */
   public R visit(FalseLiteral n);

   /**
    * f0 -> n1=<IDENTIFIER>
    */
   public R visit(Identifier n);

   /**
    * f0 -> n1="this"
    */
   public R visit(ThisExpression n);

   /**
    * f0 -> n1="new"
    * f1 -> n3="int"
    * f2 -> n5="["
    * f3 -> n6=Expression()
    * f4 -> n8="]"
    */
   public R visit(ArrayAllocationExpression n);

   /**
    * f0 -> n1="new"
    * f1 -> n2=Identifier()
    * f2 -> n4="("
    * f3 -> n6=")"
    */
   public R visit(AllocationExpression n);

   /**
    * f0 -> n1="!"
    * f1 -> n2=Expression()
    */
   public R visit(NotExpression n);

   /**
    * f0 -> n1="("
    * f1 -> n2=Expression()
    * f2 -> n4=")"
    */
   public R visit(BracketExpression n);

}

