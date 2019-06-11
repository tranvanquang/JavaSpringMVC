package com.ngominhnhi.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.ngominhnhi.entities.ServicesRoom;

public class ServiceRoomMapper implements RowMapper<ServicesRoom> {
	public ServicesRoom mapRow(ResultSet rs, int rowNum) throws SQLException {
		ServicesRoom servicesRoom = new ServicesRoom();
		servicesRoom.setRoomId(rs.getInt("roomId"));
		servicesRoom.setServiceId(rs.getInt("serviceId"));
		return servicesRoom;
	}
}

