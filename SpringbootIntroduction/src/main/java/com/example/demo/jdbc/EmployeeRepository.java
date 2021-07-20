package com.example.demo.jdbc;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.pojo.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	Optional<Employee>findByEmpidAndSalary(int empid, long salary);

}
