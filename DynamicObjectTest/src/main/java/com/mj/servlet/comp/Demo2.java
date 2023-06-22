package com.mj.servlet.comp;

public class Demo2 {
	int a=10,b=20;
	public Demo2() {
		System.out.println("Demo1 0-param constructor");
	}
	public Demo2(int a,int b) {
		this.a=a;
		this.b=b;
		System.out.println("Demo1 2-param constructor");
	}
	@Override
	public String toString() {
		return "Demo[a="+a+",b="+b+"]";
	}
}
