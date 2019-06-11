package com.ngominhnhi.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.ngominhnhi.entities.Room;
import com.ngominhnhi.mapper.RoomMapper;
@Repository
@Transactional
public class RoomDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Room> findAll(){
		String sql = "SELECT * FROM room order by name";
		return jdbcTemplate.query(sql, new RoomMapper());
	}
	public void save(Room room) {
	    String sql = "INSERT INTO room (name, status, standard) VALUES (?, ?,?)";
	    jdbcTemplate.update(sql, room.getName(), room.getStatus(), room.getStandard());
	}
	public Room findByName(String name) {
		String sql = "SELECT * FROM room WHERE name = ?";
		return jdbcTemplate.queryForObject(sql, new RoomMapper(), name);
	}
	public void update(Room room) {
		
		String sql = "update room set name = ?, standard = ?, status = ? where id= ?";
		jdbcTemplate.update(sql,room.getName(),room.getStandard(),room.getStatus(),room.getId());
	}
}