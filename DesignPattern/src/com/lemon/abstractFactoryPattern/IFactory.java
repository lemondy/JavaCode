package com.lemon.abstractFactoryPattern;

//���󹤳��ӿڣ�ʹ�������ڣ�����ÿ�����²�Ʒ����ʱ���½��µĹ�������Ƹ�µ�Ա����������������󹤳�
//���µ�Ʒ��ֱ�ӽ������󹤳���
//���������������������ͬ�Ĺ���������������Ĺ��������ڲ���ϸ��
public interface IFactory {
	BreadMaker createBread();
	PizzaMaker createPizza();
}
