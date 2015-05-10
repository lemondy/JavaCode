package com.wtu.lemon.singleton;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//只产生一个wife的实例，这样Husband和Mother都对应同一个姑娘
public class Wife {
	//产生一个私有地静态对象
	private static Wife wife = null;
	
	//定义一个锁对象
	static Lock lock = new ReentrantLock();
	
	//私有化构造函数,仅供内部访问
	private Wife(){
		
	}
	
	//静态方法产生对象，供外部访问，得到实例
	public static Wife getInstance(){
		
		//此方法对于一个线程访问没问题，当有多个线程同时访问这个代码时，就会产生不同大wife对象，因此需要锁机制
		if(wife == null){
			//一个线程访问其他的不准访问临界区
			lock.lock();
				if(wife == null)
					wife = new Wife();
			lock.unlock();
			
		}
		return wife;
	}
	
	public void show(){
		System.out.println("姑娘出来展示自己");
	}
	
	public void marry(){
		System.out.println("姑娘和男子去结婚");
	}
}
