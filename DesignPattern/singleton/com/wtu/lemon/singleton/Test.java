package com.wtu.lemon.singleton;
//���Ե����Ƿ�ɹ�
/**
 * @author lemon
 *
 */

/**
 * 
 * ʵ�������߳��࣬�ֱ���н����ֳ�ֱ��
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
		System.out.println(male + "��"+female+"��������....");
		System.out.println("��ʦ���ֻ���...");
		System.out.println(male + "��" + female + "˵����Ը��޸�����");
		System.out.println(female+"�޺�����˵��Yes I Do");
		System.out.println("������ָ");
		System.out.println("�׻�...");
		System.out.println("�����·�");
		
	}
}
public class Test {
	public static void main(String[] args) throws Exception{
		/*
		Wife wife1 = Wife.getInstance();
		Wife wife2 = Wife.getInstance();
		
		//wife1��wife2��ͬһ������
		System.out.println(wife1);
		System.out.println(wife2);
		
		*/
		String male = "Jack";
		String female = "Rose";
		//��ʱ�ڴ���ֻ��һ��wife�Ķ�������husband��mother����ͬһ����
		Husband husband = new Husband();
		System.out.println(male+"��Ҫ��飬��ȥѡ������");
		husband.chooseWife();
		
		System.out.println(male+"���ò�������ȥ���");
		husband.toMarry();
		
		Mother mother = new Mother();
		System.out.println(male+"��ĸ���뿴��ϱ��");
		mother.watch();
		System.out.println(male+"��ĸ�׾��û�����");
		
		System.out.println();
		System.out.println();
		
		System.out.println("<-------�˴�ʡ��������------->");
		
		System.out.println();
		System.out.println();
				
		System.out.println("����ʼ");
	
		//ThreadGroup����ʹ�ã�����
//		ThreadGroup group = new ThreadGroup("group");
		
		
		//Marry marry = new Marry(male,female);
		BroadCast bc = new BroadCast(male,female);
	//	new Thread(marry).start();
		bc.start();
		bc.join();    //�ȴ�bc�߳�ִ�����
	/*	
		while(group.activeCount() != 0)
			Thread.currentThread().sleep(1000);
	*/
		System.out.println("���"+male+"��"+female+"�Ҹ���������ȥ....");
		
	}
}
