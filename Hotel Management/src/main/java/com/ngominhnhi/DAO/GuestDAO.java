package com.ngominhnhi.DAO;

import java.util.List;

import org.bouncycastle.asn1.x509.qualified.TypeOfBiometricData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ngominhnhi.entities.Guest;
import com.ngominhnhi.entities.User;
import com.ngominhnhi.mapper.GuestMapper;
import com.ngominhnhi.mapper.UserMapper;

@Repository
@Transactional
public class GuestDAO {
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Guest> findAll(){
		String sql = "SELECT * FROM guest";
		return jdbcTemplate.query(sql, new GuestMapper());
	}
	
	public void delete(int id) {
		String sql01="delete from guest where id="+id;
		jdbcTemplate.update(sql01);
		
		String sql02 = "SELECT * FROM guest where id="+id;
	    Guest guest = jdbcTemplate.queryForObject(sql02, new GuestMapper());
	    
	    String username = guest.getPhoneNumber();
	    	
	    String sql03 = "update users set enabled = 0 where username=?";		
		jdbcTemplate.update(sql03, username);
	}
	
	public void save(Guest guest) {
	    String sql = "INSERT INTO guest (name, idNumber, phoneNumber, room, checkinDate, checkoutDate) VALUES (?,?,?,?,?,?)";
	    String sql01 = "INSERT INTO users (username, password, enabled) VALUES (?,'{noop}123456',1)";
   
	    
	    jdbcTemplate.update(sql, guest.getName(),guest.getIdNumber(),guest.getPhoneNumber(),guest.getRoom(),guest.getCheckinDate(),guest.getCheckoutDate());
	    jdbcTemplate.update(sql01, guest.getPhoneNumber());
	    
	    String sql02 = "SELECT * FROM users where username=?";
	    User user = jdbcTemplate.queryForObject(sql02, new UserMapper(), guest.getPhoneNumber());  
	    String sql03 = "INSERT INTO `users_roles` (user, role) VALUES (?,2)";
	    jdbcTemplate.update(sql03, user.getId());
	}
	
	public void saveAccount(Guest guest) {

	}
	
	public Guest findId(int id) {
		String sql ="select * from guest where id= ?";
		return jdbcTemplate.queryForObject(sql, new GuestMapper(), id);
	}
	public Guest findByName(String name) {
		String sql = "SELECT * FROM guest WHERE name = ?";
		return jdbcTemplate.queryForObject(sql, new GuestMapper(), name);
	}
	public void update(Guest guest) {
		String sql = " update guest set name = ?, idNumber = ?, phoneNumber = ?, room = ?, checkinDate = ?, checkoutDate = ? where id= ?";
		jdbcTemplate.update(sql, guest.getName(),guest.getIdNumber(),guest.getPhoneNumber(),guest.getCheckinDate(),guest.getCheckoutDate(),guest.getId());
	}
}