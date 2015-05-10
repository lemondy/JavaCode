.class public Good1Sorter
.super java/lang/Object
.field public refr I
.field public lb I
.field public hb I
.field public tmp I
.field public dump I
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

.method public testing()I
.limit locals 3
.limit stack 7
iconst_5
newarray int
astore 1
aload 1
iconst_0
bipush 7
iastore
aload 1
iconst_1
iconst_2
iastore
aload 1
iconst_2
iconst_1
iastore
aload 1
iconst_3
iconst_3
iastore
aload 1
iconst_4
bipush 10
iastore
iconst_0
istore 2
iconst_0
aload 1
arraylength
ifeq Label5
Label4:
dup
aload 1
swap
iaload
invokestatic Good1Sorter.print(I)V
ldc " "
invokestatic Good1Sorter.print(Ljava/lang/String;)V
iconst_1
iadd
dup
aload 1
arraylength
isub
iflt Label4
Label5:
pop
ldc "\n"
invokestatic Good1Sorter.print(Ljava/lang/String;)V
aload_0
aload 1
iconst_0
iconst_4
invokevirtual Good1Sorter/quickSort([III)I
istore 2
aload_0
aload 1
iconst_0
aload 1
arraylength
iconst_1
isub
invokevirtual Good1Sorter/quickSort([III)I
istore 2
iconst_0
aload 1
arraylength
ifeq Label7
Label6:
dup
aload 1
swap
iaload
invokestatic Good1Sorter.print(I)V
ldc " "
invokestatic Good1Sorter.print(Ljava/lang/String;)V
iconst_1
iadd
dup
aload 1
arraylength
isub
iflt Label6
Label7:
pop
ldc "\n"
invokestatic Good1Sorter.print(Ljava/lang/String;)V
iconst_1
ireturn
.end method

.method public quickSort([III)I
.limit locals 5
.limit stack 7
iconst_0
istore 4
iload 3
iload 2
isub
iconst_1
if_icmplt Label8
iconst_0
goto Label9
Label8:
iconst_1
Label9:
ldc 1
isub
ifeq Label10
goto Label12
Label10:
iconst_0
istore 4
goto Label11
Label12:
aload 1
iload 2
iaload
aload_0
swap
putfield Good1Sorter/refr I
iload 2
aload_0
swap
putfield Good1Sorter/lb I
iload 3
iconst_1
iadd
aload_0
swap
putfield Good1Sorter/hb I
aload_0
getfield Good1Sorter/lb I
iconst_1
iadd
aload_0
getfield Good1Sorter/hb I
if_icmplt Label15
iconst_0
goto Label16
Label15:
iconst_1
Label16:
iconst_1
isub
ifeq Label13
goto Label14
Label13:
aload 1
aload_0
getfield Good1Sorter/lb I
iconst_1
iadd
iaload
aload_0
getfield Good1Sorter/refr I
isub
iconst_0
if_icmplt Label17
iconst_0
goto Label18
Label17:
iconst_1
Label18:
ldc 1
isub
ifeq Label19
goto Label21
Label19:
aload_0
getfield Good1Sorter/lb I
iconst_1
iadd
aload_0
swap
putfield Good1Sorter/lb I
goto Label20
Label21:
aload_0
getfield Good1Sorter/hb I
iconst_1
isub
aload_0
swap
putfield Good1Sorter/hb I
aload 1
aload_0
getfield Good1Sorter/hb I
iaload
aload_0
swap
putfield Good1Sorter/tmp I
aload 1
aload_0
getfield Good1Sorter/hb I
aload 1
aload_0
getfield Good1Sorter/lb I
iconst_1
iadd
iaload
iastore
aload 1
aload_0
getfield Good1Sorter/lb I
iconst_1
iadd
aload_0
getfield Good1Sorter/tmp I
iastore
Label20:
aload_0
getfield Good1Sorter/lb I
iconst_1
iadd
aload_0
getfield Good1Sorter/hb I
if_icmplt Label22
iconst_0
goto Label23
Label22:
iconst_1
Label23:
iconst_1
isub
ifeq Label13
Label14:
aload 1
iload 2
aload 1
aload_0
getfield Good1Sorter/lb I
iaload
iastore
aload 1
aload_0
getfield Good1Sorter/lb I
aload_0
getfield Good1Sorter/refr I
iastore
aload_0
aload 1
iload 2
aload_0
getfield Good1Sorter/lb I
iconst_1
isub
invokevirtual Good1Sorter/quickSort([III)I
aload_0
swap
putfield Good1Sorter/dump I
aload_0
aload 1
aload_0
getfield Good1Sorter/lb I
iconst_1
iadd
iload 3
invokevirtual Good1Sorter/quickSort([III)I
aload_0
swap
putfield Good1Sorter/dump I
iconst_0
istore 4
Label11:
iload 4
ireturn
.end method

