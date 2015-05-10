package com.lemon.abstractFactoryPattern;

//抽象工厂接口，使用这个借口，不必每次有新产品生产时，新建新的工厂，招聘新的员工，都交给这个抽象工厂
//有新的品种直接交给抽象工厂，
//工厂抽象出来它们做的相同的工作，而各个具体的工厂决定内部的细节
public interface IFactory {
	BreadMaker createBread();
	PizzaMaker createPizza();
}
