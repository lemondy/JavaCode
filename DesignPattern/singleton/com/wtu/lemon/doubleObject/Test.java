package com.wtu.lemon.doubleObject;

public class Test {
	public static void main(String[] args){
		String name[] = {"Tom","Jack","Lucy","Rose","Lily","" ,"" ,"" ,"" ,""};
		
		for(int i=0; i<10; i++){
			MulitObject obj = MulitObject.getInstance(name[i]);
			System.out.println(obj);
		}
	}

}
