package com.lemon.abstractFactoryPattern;

//客户端，顾客去面包店买面包
//工厂模式满足的原则是，开放与封闭
public class Customer {
	public static void main(String[] args){
		BreadMaker breadMaker;
		PizzaMaker pizzaMaker;
		IFactory factory;
		System.out.println("面包店开张");
		
		System.out.println("顾客需要黑面包");
		factory = new BlackBreadFactory();
		breadMaker = factory.createBread();
		breadMaker.getBread();
		
		System.out.println("顾客需要黑匹萨");
		factory = new BlackBreadFactory();
		pizzaMaker = factory.createPizza();
		pizzaMaker.getPizza();
		
	
		
		
	}
}
