package com.lemon.higherFactoryPattern;

//客户端，顾客去面包店买面包
//工厂模式满足的原则是，开放与封闭
public class Customer {
	public static void main(String[] args){
		BreadMaker breadMaker;
		System.out.println("面包店开张");
	
		System.out.println("顾客需要黑面包");
		IFactory breadFactory = new BlackBreadFactory();
		breadMaker = breadFactory.createBread();
		breadMaker.getBread();
		
	}
}
