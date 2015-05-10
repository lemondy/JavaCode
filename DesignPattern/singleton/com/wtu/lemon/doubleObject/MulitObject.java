package com.wtu.lemon.doubleObject;

import java.util.HashMap;

/**
 * 
 * @author lemon
 * 多例模式，这个类可以生产多个实例，但是实例的个数是有限的
 */
public class MulitObject {
	
	private static int UPBOUND = 5;
	private static int count = 0;
	private String name;
	private static HashMap<String,MulitObject> objectPool = new HashMap<String,MulitObject>(); 
	
	private MulitObject(String name){
		this.name = name;
		
	}
	
	public static MulitObject getInstance(String name){
		
		if(objectPool.containsKey(name))
			return (MulitObject)objectPool.get(name);
		else if(count++ < UPBOUND ){
			MulitObject object = new MulitObject(name);
			objectPool.put(name, object);
			return object;
		}else{
			System.err.println("可用实例已经用完，不可再分配新的对象");
			return null;
		}
	}

}
