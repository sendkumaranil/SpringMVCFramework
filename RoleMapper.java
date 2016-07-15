package com.springmvcexample.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springmvcexample.model.Role;

public class RoleMapper implements RowMapper<Role> {

	@Override
	public Role mapRow(ResultSet rs, int rownum) throws SQLException {
		Role role=new Role();
		role.setRoleid(rs.getInt("roleid"));
		role.setRolename(rs.getString("role_name"));
		return role;
	}

}
