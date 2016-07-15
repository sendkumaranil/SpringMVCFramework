package com.springmvcexample.dao;

import java.util.List;

import com.springmvcexample.model.Department;
import com.springmvcexample.model.Employee;
import com.springmvcexample.model.Role;
import com.springmvcexample.model.User;
import com.springmvcexample.model.UserRoleMapping;

public interface EmployeeDao {

	public List<Employee> getEmployees();
	public Employee getEmployeeProfile(int empid);
	public void addEmployee(Employee employee);
	public void deleteEmployee(int empid);
	public void editEmployee(Employee employee);
	public void addUser(User user);
	public void addRole(Role role);
	public List<User> getUsers();
	public List<Role> getRoles();
	public void assignRoleToUser(int userid, int roleid);
	public List<UserRoleMapping> getMappedUsers();
	public String removeMappedUsers(UserRoleMapping userRoleMap);
	public void resetPassword(User user);
	public boolean isValidUser(User user);
	public void changePassword(User user);
	public String getRegisteredEmailid(User user);
	public List<Department> getDepartments();
}
