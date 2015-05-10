.class public Good1
.super java/lang/Object
.method public <init>()V
aload_0
invokespecial java/lang/Object/<init>()V
return
.end method

.method public static print(I)V
.limit locals 5
.limit stack 5
iload 0
getstatic java/lang/System/out Ljava/io/PrintStream;
swap
invokevirtual java/io/PrintStream/print(I)V
return
.end method

.method public static print(Ljava/lang/String;)V
.limit locals 5
.limit stack 5
aload 0
getstatic java/lang/System/out Ljava/io/PrintStream;
swap
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
return
.end method

.method public static main([Ljava/lang/String;)V
.limit locals 1
.limit stack 7
new Good1Sorter
dup
invokespecial Good1Sorter/<init>()V
invokevirtual Good1Sorter/testing()I
ifeq Label2
Label1:
ldc "true"
goto Label3
Label2:
ldc "false"
Label3:
invokestatic Good1.print(Ljava/lang/String;)V
ldc "\n"
invokestatic Good1.print(Ljava/lang/String;)V
return
.end method

