package com.wtu.lemon.singleton;

public class Husband {
	//������ȥ���
	public void chooseWife(){
		Wife wife = Wife.getInstance();
		wife.show();
		System.out.println(wife);
	}
	
	public void toMarry(){
		Wife wife = Wife.getInstance();
		wife.marry();
		System.out.println(wife);
	}
}
