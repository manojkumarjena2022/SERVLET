package com.mj.servlet;

public class DynamicObjectTest1 {
	public static void main(String[] args) {
		try {
			//load java class
			Class c=Class.forName(args[0]);
			//create dynamic object
			Object obj=c.newInstance();
			System.out.println(obj);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
