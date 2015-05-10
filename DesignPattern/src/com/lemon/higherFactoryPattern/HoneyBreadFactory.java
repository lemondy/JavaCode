package com.lemon.higherFactoryPattern;

public class HoneyBreadFactory implements IFactory{
	@Override 
	public BreadMaker createBread()
	{
		return new HoneyBread();
	}
}
