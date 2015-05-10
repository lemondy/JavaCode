package com.lemon.abstractFactoryPattern;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;


public class Client {
	static Hashtable requirements;
	
	public static Hashtable getRequirements(String path) throws Exception{
		Hashtable<String,Integer> needs = new Hashtable<String,Integer>();
		FileReader readFile = new FileReader(path);
		BufferedReader readRequirements = new BufferedReader(readFile);
		String line = null;
		String[] message;
		
		while( (line = readRequirements.readLine()) != null){
			message = line.split(" ");
			needs.put(message[4], Integer.parseInt(message[3]));
			/*for(int i=0;i<message.length;i++)
				System.out.println(message[i]);
			System.out.println(message);
			for(String s:message)
				System.out.println(s);
			System.out.println();*/
		}
		
		return needs;
		
	}
	
	public static void main(String[] args) throws Exception{
		requirements = getRequirements("requirements.txt");
		Set keys=requirements.keySet();
		Iterator it=keys.iterator();
		/*for(;it.hasNext(); ){
			String key = it.next().toString();
			System.out.print("key:"+key);
			System.out.println(" value:"+requirements.get(key));
		}*/
		
		//利用反射机制进行生产
		IFactory breadFactory;
		PizzaMaker pizzaMaker;
		
		String packageName = "com.lemon.abstractFactoryPattern";
		try{
			while(it.hasNext()){
				String product = it.next().toString();
				Class<?> c;
				if(product.contains("Pizza")){
					 c = Class.forName(packageName+"."+"BlackBreadFactory");    //用forName反射一个类时，一定要写全路径名
				}
				else
					 c = Class.forName(packageName+"."+product+"Factory");
			    //Class<?> c = Class.forName("com.lemon.abstractFactoryPattern.BlackBreadFactory");
				try{
				//	System.out.println(c);
					
					breadFactory = (IFactory)c.newInstance();
				//	System.out.println(breadFactory);
					pizzaMaker = breadFactory.createPizza();
				//	System.out.println(pizzaMaker);
					
					pizzaMaker.getPizza();
				}catch(Exception e){
					
				}
		}
		}catch(ClassNotFoundException e){
			System.out.println(e);
		}
	}
}
