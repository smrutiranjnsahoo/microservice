package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.jdbc.EmployeeDAO;
import com.example.demo.jdbc.EmployeeRepository;
import com.example.demo.pojo.Employee;

@RestController
public class MyController {

	@Autowired
	private EmployeeDAO employeeDAO;

	@Autowired
	private EmployeeRepository emprepo;

	@GetMapping("/messages")
	public String getMessage() {
		return "My Mesage";
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployees(@PathVariable int id) {
		//return new Employee(id,"EmpName",12345,"Address");
		Employee employees = employeeDAO.findByEmpId(id);
		if(employees.getEmpid() > 0) {
			return new ResponseEntity<Employee>(employees,HttpStatus.OK);
		}
		return new ResponseEntity<Employee>(employees,HttpStatus.NO_CONTENT);
	}

	@GetMapping("/employees/{id}/{salaray}")
	public Employee getEmployees(@PathVariable int id,@PathVariable int salaray) {
		return new Employee(id,"EmpName",salaray,"Address");

	}
	
	@GetMapping("/employees-jpa/{id}/{salary}")
	public ResponseEntity<Employee> getEmployee(@PathVariable int id, @PathVariable("salary") long sal) {
		
		Optional<Employee> optional= emprepo.findByEmpidAndSalary(id, sal);
		
		if(optional.isPresent()) {
			return new ResponseEntity<Employee>(optional.get(), HttpStatus.OK);
		}
		return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
	}


	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getEmployees() {

		List<Employee> employees = employeeDAO.findAllEmployees();
		if(employees.size() > 0) {
			return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
		}
		return new ResponseEntity<List<Employee>>(employees,HttpStatus.NO_CONTENT);

	}

	@PostMapping("/employees")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		/*
		 * System.out.println("Employee  "+employee);
		 * employee.setEmpname(employee.getEmpname().toUpperCase());
		 * System.out.println("After Employee  "+employee);
		 */
		int added = employeeDAO.addEmployee(employee);
		if(added > 0) {
			return new ResponseEntity<Employee>(employee,HttpStatus.CREATED);	
		}
		return new ResponseEntity<Employee>(employee,HttpStatus.NO_CONTENT);
	}

	@PostMapping("/employees-jpa")
	public ResponseEntity<Employee> addEmployee_jpa(@RequestBody Employee employee) {

		Employee saveEmp = emprepo.save(employee);
		return new ResponseEntity<Employee>(saveEmp,HttpStatus.CREATED);	
	}

	@GetMapping("/employees-jpa/{id}")
	public ResponseEntity<Employee> getEmployees_jpa(@PathVariable int id) {
		Optional<Employee> emp = emprepo.findById(id);
		if(emp.isPresent()) {
			return new ResponseEntity<Employee>(emp.get(),HttpStatus.OK);
		}
		return new ResponseEntity<Employee>(emp.get(),HttpStatus.NO_CONTENT);
	}


}
