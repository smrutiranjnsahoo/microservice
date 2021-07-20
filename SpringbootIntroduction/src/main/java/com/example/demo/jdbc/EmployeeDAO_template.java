package com.example.demo.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.pojo.Employee;

@Repository
public class EmployeeDAO_template implements EmployeeDAO {
	
	@Autowired
	JdbcTemplate template;

	@Override
	public int addEmployee(Employee employee) {
		int added =0;
		String INSERT = "insert into emp123 values(?,?,?,?)";
		try {
			added = template.update(INSERT,employee.getEmpid(),employee.getEmpname(),employee.getSalary(),employee.getAddress());
		} catch (DuplicateKeyException e) {
			e.printStackTrace();
		}
		
		return added;
	}

	@Override
	public boolean updateEmployee(int empId, String address) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int deleteEmployee(int empid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Employee findByEmpId(int empid) {
		String SELECT = "select * from emp123 where empid=?";
		Employee employee = new Employee();
		try {
			employee = template.queryForObject(SELECT, new RowMapper<Employee>() {

				@Override
				public Employee mapRow(ResultSet set, int arg1) throws SQLException {
					// TODO Auto-generated method stub
					Employee emp = new Employee();
					emp.setEmpid(set.getInt(1));
					emp.setEmpname(set.getString(2));
					emp.setSalary(set.getLong(3));
					emp.setAddress(set.getString(4));
					return emp;
				}
			}, empid);
		} catch (EmptyResultDataAccessException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return employee;

	}

	@Override
	public List<Employee> findAllEmployees() {
		
		List<Employee> employee = new ArrayList<>();
		String SELECT  = "select * from emp123";
		//template.query(SELECT, new RowMapper<Employee>());
		employee = template.query(SELECT, new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee employee = new Employee();
				employee.setEmpid(rs.getInt(1));
				employee.setEmpname(rs.getString(2));
				employee.setSalary(rs.getLong(3));
				employee.setAddress(rs.getString(4));
				return employee;
			}
			
		});
		return employee;
	}

}
