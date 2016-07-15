package com.springmvcexample.service;

import java.util.List;

import com.springmvcexample.dao.EmployeeDao;
import com.springmvcexample.model.Department;
import com.springmvcexample.model.Employee;
import com.springmvcexample.model.Role;
import com.springmvcexample.model.User;

public class EmployeeService {

	private EmployeeDao employeeDao;

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	public List<Employee> getEmployee(){
		return employeeDao.getEmployees();
	}
	
	public Employee getEmployeeProfile(int empid){
		return employeeDao.getEmployeeProfile(empid);
	}
	
	public void addEmployee(Employee employee){
		employeeDao.addEmployee(employee);
	}
	
	public void deleteEmployee(int empid){
		employeeDao.deleteEmployee(empid);
	}
	
	public void editEmployee(Employee employee){
		employeeDao.editEmployee(employee);
	}

	public List<Department> getDepartments() {
		
		return employeeDao.getDepartments();
	}
	
}
