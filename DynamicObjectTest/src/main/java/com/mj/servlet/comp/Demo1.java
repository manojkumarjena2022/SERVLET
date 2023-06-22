package com.mj.servlet.comp;

public class Demo1 {
	int a=10,b=20;
	public Demo1() {
		System.out.println("Demo1 0-param constructor");
	}
	@Override
	public String toString() {
		return "Demo[a="+a+",b="+b+"]";
	}
}
