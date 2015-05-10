package com.wtu.lemon.doubleObject;

public class DoubleObject {
	
	private static DoubleObject object1 = new DoubleObject();
	private static DoubleObject object2 = new DoubleObject();
	
	private DoubleObject(){}
	
	/**
	 * 
	 * @param item ��������Ĳ�����1����2�����ض���
	 * @return
	 */
	public static DoubleObject getInstance(int item){
		if(item == 1)
			return object1;
		else
			return object2;
	}
	
	//you can define function below to do something 
	
}
