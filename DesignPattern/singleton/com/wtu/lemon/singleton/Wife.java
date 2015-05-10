package com.wtu.lemon.singleton;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//ֻ����һ��wife��ʵ��������Husband��Mother����Ӧͬһ������
public class Wife {
	//����һ��˽�еؾ�̬����
	private static Wife wife = null;
	
	//����һ��������
	static Lock lock = new ReentrantLock();
	
	//˽�л����캯��,�����ڲ�����
	private Wife(){
		
	}
	
	//��̬�����������󣬹��ⲿ���ʣ��õ�ʵ��
	public static Wife getInstance(){
		
		//�˷�������һ���̷߳���û���⣬���ж���߳�ͬʱ�����������ʱ���ͻ������ͬ��wife���������Ҫ������
		if(wife == null){
			//һ���̷߳��������Ĳ�׼�����ٽ���
			lock.lock();
				if(wife == null)
					wife = new Wife();
			lock.unlock();
			
		}
		return wife;
	}
	
	public void show(){
		System.out.println("�������չʾ�Լ�");
	}
	
	public void marry(){
		System.out.println("���������ȥ���");
	}
}
