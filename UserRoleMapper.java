package com.springmvcexample.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springmvcexample.model.UserRoleMapping;

public class UserRoleMapper implements RowMapper<UserRoleMapping> {

	@Override
	public UserRoleMapping mapRow(ResultSet rs, int rownum) throws SQLException {
		UserRoleMapping mappedUsers=new UserRoleMapping();
		mappedUsers.setUsername(rs.getString("username"));
		mappedUsers.setRolename(rs.getString("role_name"));
		mappedUsers.setMappingid(rs.getInt("mappingid"));
		mappedUsers.setUseremailid(rs.getString("emailid"));
		return mappedUsers;
	}

}
