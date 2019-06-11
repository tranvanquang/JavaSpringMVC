package com.ngominhnhi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ngominhnhi.DAO.ServicesRoomDAO;
import com.ngominhnhi.entities.Room;
import com.ngominhnhi.entities.Services;
import com.ngominhnhi.entities.ServicesRoom;

@Service
@Transactional
public class ServicesRoomService {

	@Autowired
	private ServicesRoomDAO servicesRoomDAO;
	public List<ServicesRoom> findAll(){
		return servicesRoomDAO.findAll();
	}
	
	public List<Room> findAllRoom(){
		return servicesRoomDAO.findAllRoom();
	}
	
	public void save(ServicesRoom servicesRoom){
		servicesRoomDAO.save(servicesRoom);
	}
	
	public void save1(int id, int framework){
		servicesRoomDAO.save1(id, framework);
	}
	
	public List<Services> findAllService(){
		return servicesRoomDAO.findAllService();
	}
	
	public List<Services> findAllServiceRoom(int IDview){
		return servicesRoomDAO.findAllServiceRoom(IDview);
	}
	
	public void delete(int id) {
		servicesRoomDAO.delete(id);
	}
	
	
//	public List<Services> findService(int framework){
//		return servicesRoomDAO.findService();
//	}
//	
//	public List<Room> findRoom(){
//		return servicesRoomDAO.findRoom();
//	}
}