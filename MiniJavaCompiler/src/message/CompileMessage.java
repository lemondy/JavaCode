package message;

import mjc.frontend.syntaxtree.NewArray;

public class CompileMessage {
	//the follow array save the compiler output data,which will be displayed in the ui;
	private final static int MAXSIZE = 100;
	private static String[] compileMessageStrings = new String[MAXSIZE];
	private static int index=0;
	
	public static String[] getCompileMessaage(){
		return compileMessageStrings;
	}
	
	public static void setCompileMessage(String message){
		compileMessageStrings[index++] = message;
	}
	
}
