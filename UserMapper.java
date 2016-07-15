package com.springmvcexample.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springmvcexample.model.User;

public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rownum) throws SQLException {
		User user=new User();
		user.setUserid(rs.getInt("userid"));
		user.setUsername(rs.getString("username"));
		user.setEmailid(rs.getString("emailid"));
		return user;
	}

}
