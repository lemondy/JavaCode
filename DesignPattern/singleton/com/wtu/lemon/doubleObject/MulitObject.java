package com.wtu.lemon.doubleObject;

import java.util.HashMap;

/**
 * 
 * @author lemon
 * ����ģʽ�����������������ʵ��������ʵ���ĸ��������޵�
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
			System.err.println("����ʵ���Ѿ����꣬�����ٷ����µĶ���");
			return null;
		}
	}

}
