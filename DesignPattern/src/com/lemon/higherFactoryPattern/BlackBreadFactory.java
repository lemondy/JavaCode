package com.lemon.higherFactoryPattern;

//黑面包的工厂方法实现
public class BlackBreadFactory implements IFactory{
	//覆盖父类抽象方法
	@Override 
	public BreadMaker createBread(){
		return new BlackBread();
	}
}
