package com.example.demo.pojo;

public class MyPojo {
	
	private String name;
	private int pincode;
	
	public MyPojo() {
		// TODO Auto-generated constructor stub
	}

	public MyPojo(String name, int pincode) {
		super();
		this.name = name;
		this.pincode = pincode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}


}
