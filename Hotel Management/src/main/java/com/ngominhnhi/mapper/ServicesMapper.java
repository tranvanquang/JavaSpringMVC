package com.ngominhnhi.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.ngominhnhi.entities.Services;

public class ServicesMapper implements RowMapper<Services> {
	public Services mapRow(ResultSet rs, int rowNum) throws SQLException {
		Services services = new Services();
		services.setId(rs.getInt("id"));
		services.setName(rs.getString("name"));
		services.setPrice(rs.getInt("price"));
		return services;
	}
}
