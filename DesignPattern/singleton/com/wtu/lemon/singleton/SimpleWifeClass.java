package com.wtu.lemon.singleton;

public class SimpleWifeClass {
//jvm�����ȼ������еľ�̬������֮����ʶ���ͬһ����������Ϊ�˱������������������ɲ�ͬ�Ķ��󣬿��Բ�������򵥵ķ���,
	private static SimpleWifeClass wife = new SimpleWifeClass();
	
	private SimpleWifeClass(){}
	
	public SimpleWifeClass getInstance(){
		return wife;
	}
}
