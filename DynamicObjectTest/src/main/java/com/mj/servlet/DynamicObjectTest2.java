package com.mj.servlet;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class DynamicObjectTest2 {
	public static void main(String[] args) {
		try {
			//load java class
			Class c=Class.forName(args[0]);
			//get declared constructors of java class
			Constructor consts[]=c.getConstructors();
			//object creation using 0-param constructor of java class
			//order of constructor is decided based on order of declaration
			Object obj1=consts[0].newInstance();
			System.out.println("Data of obj1 :"+obj1);
			//object creation using 2-param constructor of java class
			Object obj2=consts[1].newInstance(30,40);
			System.out.println("Data of obj2 :"+obj2);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
