package com.ngominhnhi.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ngominhnhi.entities.User;

public class UserMapper implements RowMapper<User>{
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user= new User();

		user.setId(rs.getInt("id"));
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		return user;
	}
}
