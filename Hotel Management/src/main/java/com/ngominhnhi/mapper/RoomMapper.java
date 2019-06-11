package com.ngominhnhi.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ngominhnhi.entities.Room;

public class RoomMapper implements RowMapper<Room>{

	public Room mapRow(ResultSet rs, int rowNum) throws SQLException {
		Room room= new Room();
		room.setId(rs.getInt("id"));
		room.setName(rs.getString("name"));
		room.setStandard(rs.getString("standard"));
		room.setStatus(rs.getString("status"));
		return room;
	}
}
