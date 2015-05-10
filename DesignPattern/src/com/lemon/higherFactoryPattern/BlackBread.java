package com.lemon.higherFactoryPattern;

//blackBread 继承，实现代码的解耦
public class BlackBread extends BreadMaker{
	@Override
	public void getBread(){
		System.out.println("make black bread!!!");
	}
}