package com.example.demo.jdbc;

import java.util.List;

import com.example.demo.pojo.Employee;

public interface EmployeeDAO {
	
	public int addEmployee(Employee employee);
	boolean updateEmployee(int empId, String address);
	int deleteEmployee(int empid);
	Employee findByEmpId(int empid);
	List<Employee> findAllEmployees();


}
