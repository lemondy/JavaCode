package com.lemon.higherFactoryPattern;

//������Ĺ�������ʵ��
public class BlackBreadFactory implements IFactory{
	//���Ǹ�����󷽷�
	@Override 
	public BreadMaker createBread(){
		return new BlackBread();
	}
}
