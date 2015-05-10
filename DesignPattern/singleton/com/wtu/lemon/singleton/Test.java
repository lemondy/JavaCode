package com.wtu.lemon.singleton;
//测试单例是否成功
/**
 * @author lemon
 *
 */

/**
 * 
 * 实现两个线程类，分别进行结婚和现场直播
 *
 */

class Marry implements Runnable{
	String male,female;
	public Marry(String male,String female){
		this.male = male;
		this.female = female;
	}
	public void run(){
		
	}
}

class BroadCast extends Thread{
	String male,female;
	public BroadCast(String male,String female){
		this.male = male;
		this.female = female;
	}
	public void run(){
		System.out.println(male + "和"+female+"步入礼堂....");
		System.out.println("牧师主持婚礼...");
		System.out.println(male + "对" + female + "说：你愿意嫁给我吗？");
		System.out.println(female+"哭红着眼说：Yes I Do");
		System.out.println("交换戒指");
		System.out.println("抛花...");
		System.out.println("送人新房");
		
	}
}
public class Test {
	public static void main(String[] args) throws Exception{
		/*
		Wife wife1 = Wife.getInstance();
		Wife wife2 = Wife.getInstance();
		
		//wife1和wife2是同一个对象
		System.out.println(wife1);
		System.out.println(wife2);
		
		*/
		String male = "Jack";
		String female = "Rose";
		//此时内存中只有一个wife的对象，所以husband和mother都看同一个人
		Husband husband = new Husband();
		System.out.println(male+"想要结婚，就去选择老婆");
		husband.chooseWife();
		
		System.out.println(male+"觉得不错，决定去结婚");
		husband.toMarry();
		
		Mother mother = new Mother();
		System.out.println(male+"的母亲想看儿媳妇");
		mother.watch();
		System.out.println(male+"的母亲觉得还不错");
		
		System.out.println();
		System.out.println();
		
		System.out.println("<-------此处省略若干字------->");
		
		System.out.println();
		System.out.println();
				
		System.out.println("婚礼开始");
	
		//ThreadGroup不会使用，不懂
//		ThreadGroup group = new ThreadGroup("group");
		
		
		//Marry marry = new Marry(male,female);
		BroadCast bc = new BroadCast(male,female);
	//	new Thread(marry).start();
		bc.start();
		bc.join();    //等待bc线程执行完毕
	/*	
		while(group.activeCount() != 0)
			Thread.currentThread().sleep(1000);
	*/
		System.out.println("最后"+male+"和"+female+"幸福的生活下去....");
		
	}
}
