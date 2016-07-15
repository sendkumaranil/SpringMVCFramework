package com.springmvcexample.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springmvcexample.model.Employee;

public class EmployeeMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rownum) throws SQLException {
		Employee employee=new Employee();
		employee.setEmpid(rs.getInt("empid"));
		employee.setEmpname(rs.getString("empname"));
		employee.setEmailid(rs.getString("email"));
		employee.setMobileno(rs.getString("mobileno"));
		employee.setDob(rs.getString("birthdate"));
		employee.setDoj(rs.getString("joindate"));
		employee.setIdtype(rs.getString("idtype"));
		employee.setIdno(rs.getString("idno"));
		employee.setDeptname(rs.getString("dept_name"));
		return employee;
	}
}
