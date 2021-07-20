package com.example.demo.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name ="myemp1234")
public class Employee {
	
	@Id
	private int empid;
	private String empname;
	private long salary;
	private String address;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public Employee(int empid, String empname, long salary, String address) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.salary = salary;
		this.address = address;
	}
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empname=" + empname + ", salary=" + salary + ", address=" + address
				+ "]";
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}


}
