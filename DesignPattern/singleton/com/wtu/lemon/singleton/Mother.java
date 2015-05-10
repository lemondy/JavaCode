package com.wtu.lemon.singleton;
//¿´¿´¶ùÏ±¸¾¶ù
public class Mother {
	Wife daughterInLaw = null;
	public void watch(){
		daughterInLaw = Wife.getInstance();
		daughterInLaw.show();
		System.out.println(daughterInLaw);
	}
}
