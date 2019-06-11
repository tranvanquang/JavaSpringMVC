package com.ngominhnhi.entities;

import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.jdbc.core.RowCallbackHandler;

public class Guest {
	private int id;
	private String name;
	private String idNumber;
	private String phoneNumber;
	private String room;
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	private String checkinDate;
	private String checkoutDate;
	private List<Guest> listGuest;
	
	public List<Guest> getListGuest() {
		return listGuest;
	}

	public void setListGuest(List<Guest> listGuest) {
		this.listGuest = listGuest;
	}

	public Guest() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String string) {
		this.room = string;
	}

	public String getCheckinDate() {
		return checkinDate;
	}
	
	public void setCheckinDate(String checkinDate) {
		this.checkinDate = checkinDate;
	}
	
	public String getCheckoutDate() {
		return checkoutDate;
	}
	public void setCheckoutDate(String checkoutDate) {
		this.checkoutDate = checkoutDate;
	}
//	public Date getCheckinDate() {
//		return checkinDate;
//	}
//
//	public void setCheckinDate(Date checkinDate) {
//		this.checkinDate = checkinDate;
//	}
//
//	public Date getCheckoutDate() {
//		return checkoutDate;
//	}
//
//	public void setCheckoutDate(Date checkoutDate) {
//		this.checkoutDate = checkoutDate;
//	}
}