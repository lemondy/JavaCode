package com.lemon.abstractFactoryPattern;

//�ͻ��ˣ��˿�ȥ����������
//����ģʽ�����ԭ���ǣ���������
public class Customer {
	public static void main(String[] args){
		BreadMaker breadMaker;
		PizzaMaker pizzaMaker;
		IFactory factory;
		System.out.println("����꿪��");
		
		System.out.println("�˿���Ҫ�����");
		factory = new BlackBreadFactory();
		breadMaker = factory.createBread();
		breadMaker.getBread();
		
		System.out.println("�˿���Ҫ��ƥ��");
		factory = new BlackBreadFactory();
		pizzaMaker = factory.createPizza();
		pizzaMaker.getPizza();
		
	
		
		
	}
}
