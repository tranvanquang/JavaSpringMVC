package com.ngominhnhi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ngominhnhi.DAO.ServicesDAO;
import com.ngominhnhi.entities.Services;

@Service
@Transactional
public class ServicesService {

	@Autowired
	private ServicesDAO serviceDAO;
	
	public List<Services> find(){
		return serviceDAO.find();
	}
	
	public List<Services> findAll(){
		return serviceDAO.findAll();
	}
	public void delete(int id) {
		serviceDAO.delete(id);
	}
	public void save(Services service) {
		serviceDAO.save(service);
	}
	public Services findId(int id) {
		return serviceDAO.findId(id);
	}
	
	public void update(Services service) {
		serviceDAO.update(service);
	}
}