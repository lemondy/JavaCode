package com.wtu.lemon.singleton;
//������ϱ����
public class Mother {
	Wife daughterInLaw = null;
	public void watch(){
		daughterInLaw = Wife.getInstance();
		daughterInLaw.show();
		System.out.println(daughterInLaw);
	}
}
