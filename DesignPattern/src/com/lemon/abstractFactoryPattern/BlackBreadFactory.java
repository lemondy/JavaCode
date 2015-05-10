package com.lemon.abstractFactoryPattern;

//������Ĺ�������ʵ�֣�ͬʱ�������������ƥ��
public class BlackBreadFactory implements IFactory{
	//���Ǹ�����󷽷�
	@Override 
	public BreadMaker createBread(){
		return new BlackBread();
	}
	public PizzaMaker createPizza(){
		return new BlackPizza();
	}
}
