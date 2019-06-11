package com.ngominhnhi.DAO;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ngominhnhi.mapper.RoomMapper;
import com.ngominhnhi.mapper.ServiceRoomMapper;
import com.ngominhnhi.mapper.ServicesMapper;
import com.ngominhnhi.entities.Room;
import com.ngominhnhi.entities.Services;
import com.ngominhnhi.entities.ServicesRoom;

@Repository
@Transactional
public class ServicesRoomDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<ServicesRoom> findAll(){
		String sql = "select * from room";
		return jdbcTemplate.query(sql, new ServiceRoomMapper());
	}
	
	public List<Room> findAllRoom(){
		String sql = "select * from room where status='booked'";
		return jdbcTemplate.query(sql, new RoomMapper());
	}
	
	public List<Services> findAllService(){
		String sql = "select * from service";
		return jdbcTemplate.query(sql, new ServicesMapper());
	}
	
	public List<Services> findAllServiceRoom(int IDview){
		
		String sql = "select * from service, servicesroom where service.id = servicesroom.serviceId and roomId = ?";
		System.out.println(IDview);
		return jdbcTemplate.query(sql, new ServicesMapper(), IDview);
		
//		String sql1 = "select * from service, servicesroom where service.id = servicesroom.serviceId and roomId = 10";
//		return jdbcTemplate.query(sql1, new ServicesMapper());
	}
	
	public void delete(int id) {
		String sql="delete from servicesroom where serviceId="+id;
		jdbcTemplate.update(sql);
	}
	
	public void save(ServicesRoom servicesRoom){
//		String sql1 = "select * from servicesroom";
		String sql="insert into servicesroom (roomId, serviceId) values (?,?)";
		jdbcTemplate.update(sql, servicesRoom.getRoomId(), servicesRoom.getServiceId());
	}
	
	public void save1(int id, int framework){
		String sql="insert into servicesroom (roomId, serviceId) values (?,?)";
		jdbcTemplate.update(sql, id, framework);
	}
}
