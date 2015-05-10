package mjc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import message.CompileMessage;
import mjc.frontend.Frontend;

public class JVMMain {
	public JVMMain(String file){
		Frontend frontend = new Frontend(file);
		ArrayList<String> externalList = frontend.getNames();

		BufferedReader input;

		if(frontend.getError())
			System.exit(1);

	
		//System.out.println("Compiling Jasmin code to JVM bytecode....");
		CompileMessage.setCompileMessage("Compiling Jasmin code to JVM bytecode...");
		String exec="";
		Process p;

		String line;
		//System.out.println("Classes: " + externalList);
		CompileMessage.setCompileMessage("Classes:" + externalList);
		for(int i=0; i<externalList.size(); i++){
			exec="java -jar \"C:\\jasmin.jar\" " + externalList.get(i)+".j";

		try {
			p = Runtime.getRuntime().exec(exec);
			input = new BufferedReader(new InputStreamReader(p.getInputStream()));
		    while ((line = input.readLine()) != null) {
			   // System.out.println(line);
		    	CompileMessage.setCompileMessage(line);
		    }
		    input.close();
		 
		   // System.out.println("Finished compiling.");
		    CompileMessage.setCompileMessage("Finished compiling.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
	
	
	
	//test the function within this file
   /* public static void main(String[] args) throws Exception {
        Frontend frontend = new Frontend(args);
		ArrayList<String> externalList = frontend.getNames();

		BufferedReader input;

		if(frontend.getError())
			System.exit(1);

	
		System.out.println("Compiling Jasmin code to JVM bytecode....");
		String exec="";
		Process p;

		String line;
		System.out.println("Classes: " + externalList);
		for(int i=0; i<externalList.size(); i++){
			exec="java -jar \"C:\\jasmin.jar\" " + externalList.get(i)+".j";

		p = Runtime.getRuntime().exec(exec);
	    input = new BufferedReader(new InputStreamReader(p.getInputStream()));
	    while ((line = input.readLine()) != null) {
		    System.out.println(line);
	    }
	    input.close();
	} 
	    System.out.println("Finished compiling.");
    }*/
	}
}