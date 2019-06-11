package com.ngominhnhi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ngominhnhi.DAO.GuestDAO;
import com.ngominhnhi.entities.Guest;
@Service
@Transactional
public class GuestService {
	@Autowired
	private GuestDAO guestDAO;
	public List<Guest> findAll(){
		return guestDAO.findAll();
	}

	public void save(Guest guest) {
		guestDAO.save(guest);
	}
	
	public void saveAccount(Guest guest) {
		guestDAO.saveAccount(guest);
	}
	
	public Guest findByName(String name) {
		return guestDAO.findByName(name);
	}
	public void update(Guest guest) {
		guestDAO.update(guest);
	}
	
	public Guest findId(int id) {
		return guestDAO.findId(id);
	}
	
	public void delete(int id) {
		guestDAO.delete(id);
	}
}