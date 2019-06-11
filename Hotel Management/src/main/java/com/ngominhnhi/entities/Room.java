package com.ngominhnhi.entities;

import java.util.List;

import com.ngominhnhi.entities.Guest;

public class Room {
	private int id;
	private String name;
	private String standard;
	private String status;
	private List<Guest> occupants;
	public Room() {
		
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
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<Guest> getOccupants() {
		return occupants;
	}
	public void setOccupants(List<Guest> occupants) {
		this.occupants = occupants;
	}
	
}

