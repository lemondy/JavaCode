package com.wtu.lemon.singleton;

public class SimpleWifeClass {
//jvm会首先加载类中的静态变量，之后访问都是同一个对象。所以为了避免多个类访问这个类生成不同的对象，可以采用下面简单的方法,
	private static SimpleWifeClass wife = new SimpleWifeClass();
	
	private SimpleWifeClass(){}
	
	public SimpleWifeClass getInstance(){
		return wife;
	}
}
