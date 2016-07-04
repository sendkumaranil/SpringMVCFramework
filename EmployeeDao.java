package com.springmvcexample.dao;

import java.util.List;

import com.springmvcexample.model.Employee;

public interface EmployeeDao {

	public List<Employee> getEmployees();
	public Employee getEmployeeProfile(int empid);
	public void addEmployee(Employee employee);
	public void deleteEmployee(int empid);
	public void editEmployee(Employee employee);
}
