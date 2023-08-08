package com.mj.bean;

import java.io.Serializable;

public class Student implements Serializable {
private String name;
private String class_name;
private Float percentage;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getClass_name() {
	return class_name;
}
public void setClass_name(String class_name) {
	this.class_name = class_name;
}
public Float getPercentage() {
	return percentage;
}
public void setPercentage(Float percentage) {
	this.percentage = percentage;
}

}
