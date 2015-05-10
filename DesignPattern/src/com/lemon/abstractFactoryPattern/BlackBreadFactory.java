package com.lemon.abstractFactoryPattern;

//黑面包的工厂方法实现，同时可以生产面包和匹萨
public class BlackBreadFactory implements IFactory{
	//覆盖父类抽象方法
	@Override 
	public BreadMaker createBread(){
		return new BlackBread();
	}
	public PizzaMaker createPizza(){
		return new BlackPizza();
	}
}
