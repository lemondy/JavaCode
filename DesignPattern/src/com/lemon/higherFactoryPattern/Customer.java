package com.lemon.higherFactoryPattern;

//�ͻ��ˣ��˿�ȥ����������
//����ģʽ�����ԭ���ǣ���������
public class Customer {
	public static void main(String[] args){
		BreadMaker breadMaker;
		System.out.println("����꿪��");
	
		System.out.println("�˿���Ҫ�����");
		IFactory breadFactory = new BlackBreadFactory();
		breadMaker = breadFactory.createBread();
		breadMaker.getBread();
		
	}
}
