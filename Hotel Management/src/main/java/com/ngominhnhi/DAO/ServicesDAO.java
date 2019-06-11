package com.ngominhnhi.DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.ngominhnhi.mapper.ServicesMapper;
import com.mysql.cj.xdevapi.Statement;
import com.ngominhnhi.entities.Services;
@Repository
@Transactional
public class ServicesDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Services> find(){
		List<Services> listService = new ArrayList<Services>();
//		String sql = "select * from service";
//		List<Services> listService = jdbcTemplate.queryForList(sql, Services.class);
		System.out.println("THIS IS FUNCTION FIND1s");
//		for (int i = 0; i < listService.size(); i++) {
//			Services s = listService.get(i);
//			System.out.println(s);
//		}
		listService.add(new Services(100, "ABC", 200));
		return listService;
	}
	
	public List<Services> findAll(){
		String sql = "select * from service";
		return jdbcTemplate.query(sql, new ServicesMapper());
	}
	
	public void delete(int id) {
		String sql="delete from service where id="+id;
		jdbcTemplate.update(sql);
	}
	
	public void save(Services service) {
		String sql="insert into service (name,price) values (?,?)";
		jdbcTemplate.update(sql, service.getName(),service.getPrice());
	}
	
	public Services findId(int id) {
		String sql ="select * from service where id= ?";
		return jdbcTemplate.queryForObject(sql, new ServicesMapper(), id);
	}
	
	public void update(Services service) {
		String sql = " update service set name = ?, price = ? where id= ?";
		jdbcTemplate.update(sql, service.getName(),service.getPrice(),service.getId());
	}
}
