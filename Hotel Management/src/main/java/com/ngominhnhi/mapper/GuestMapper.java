package com.ngominhnhi.mapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ngominhnhi.entities.Guest;

public class GuestMapper implements RowMapper<Guest>{

	public Guest mapRow(ResultSet rs, int rowNum) throws SQLException {
		Guest guest= new Guest();

		guest.setId(rs.getInt("id"));
		guest.setName(rs.getString("name"));
		guest.setIdNumber(rs.getString("idNumber"));
		guest.setPhoneNumber(rs.getString("phoneNumber"));
		guest.setRoom(rs.getString("room"));
		guest.setCheckinDate(rs.getString("checkinDate"));
		guest.setCheckoutDate(rs.getString("checkoutDate"));
		
		return guest;
	}

}