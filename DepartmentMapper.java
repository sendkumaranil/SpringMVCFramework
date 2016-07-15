package com.springmvcexample.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springmvcexample.model.Department;

public class DepartmentMapper implements RowMapper<Department> {

	@Override
	public Department mapRow(ResultSet rs, int rownum) throws SQLException {
		Department department=new Department();
		department.setDeptid(rs.getInt("department_id"));
		department.setDeptname(rs.getString("dept_name"));
		return department;
	}
	

}
