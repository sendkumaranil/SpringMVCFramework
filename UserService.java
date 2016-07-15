package com.springmvcexample.service;

import java.util.List;

import com.springmvcexample.dao.EmployeeDao;
import com.springmvcexample.model.Role;
import com.springmvcexample.model.User;
import com.springmvcexample.model.UserRoleMapping;
import com.springmvcexample.util.MailUtility;
import com.springmvcexample.util.RandomPasswordGenerator;

public class UserService {

	private EmployeeDao employeeDao;
	private MailUtility sendMail;

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	public void setSendMail(MailUtility sendMail) {
		this.sendMail = sendMail;
	}

	public void addUser(User user){
		employeeDao.addUser(user);
	}
	
	public void addRole(Role role){
		role.setRolename(role.getRolename().toUpperCase());
		employeeDao.addRole(role);
	}

	public List<User> getUsers() {
		return employeeDao.getUsers();
	}

	public List<Role> getRoles() {
		return employeeDao.getRoles();
	}
	
	public void userRoleMapping(UserRoleMapping userRole){
		int userid=userRole.getUserid();
		int roleid=userRole.getRoleid();
		employeeDao.assignRoleToUser(userid,roleid);
	}

	public List<UserRoleMapping> getMappedUsers() {
		return employeeDao.getMappedUsers();
	}

	public String removeMappedUsers(UserRoleMapping userRoleMap) {
		String status="";
		status=employeeDao.removeMappedUsers(userRoleMap);
		return status;
	}

	public String resetPassword(User user) {
		String genPassword=RandomPasswordGenerator.generateRandomString();
		user.setPassword(genPassword);
		employeeDao.resetPassword(user);
		String registeredEmailid=employeeDao.getRegisteredEmailid(user);
		String status=" ";
		//-------------------------------------------------
			String toMail=registeredEmailid;
			String username=user.getUsername();
			String subject="Employee Management System : User Credentials";
			String bodyMsg="Hi "+username+" ,\nbelow is your username and password details:\n";
			String credentials="User Name:"+username+"  \nPassword:"+genPassword;
			String extmsg="\n\n Note: Please change your password once you login with this password.";
			String body=bodyMsg+credentials+extmsg;
			
			body="<table border='0' cellpadding='0' cellspacing='0' height='100%' width='100%' id='bodyTable'>"
					+ "<tr>"
					+ "<td align='center' valign='top'>"
					+ "<table border='0' cellpadding='20' cellspacing='0' width='600' id='emailContainer'>"
					+ "<tr>"
					+ "<td align='center' valign='top'>"
					+ bodyMsg
					+ "</td>"
					+ "<td align='center' valign='top'>"
					+ credentials
					+ "</td>"
					+ "</tr>"
					+ "</table>"
					+ "</td>"
					+ "<td align='center' valign='top'>"
					+ extmsg
					+ "</td>"
					+ "</tr>"
					+ "</table>";
			//sending mail 
			sendMail.sendMail("sendkumaranil@gmail.com", toMail, subject, body);
			status="success";
		//-------------------------------------------------
		
		return status;
	}

	public boolean isValidUser(User user){
		boolean isValidUser=employeeDao.isValidUser(user);
		if(!isValidUser){
			return false;
		}
		return true;
	}
	public void changePassword(User user){
		employeeDao.changePassword(user);
	}
}
