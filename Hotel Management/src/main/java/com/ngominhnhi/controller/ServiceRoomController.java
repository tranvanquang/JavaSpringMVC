package com.ngominhnhi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ngominhnhi.entities.ServicesRoom;
import com.ngominhnhi.service.ServicesRoomService;
@Controller
public class ServiceRoomController {
	public int IDadd;
	public int IDview;
	@Autowired
	private ServicesRoomService servicesRoomService;
	@RequestMapping("/room-booked-list")
	public String serviceList(Model model) {
		model.addAttribute("listserviceRoom", servicesRoomService.findAllRoom());
		return "room-booked-list";
	}
	
	@RequestMapping("/room-booked-list/add-serviceRoom/{id}")
	public String addServiceRoom(@PathVariable("id") int idRoom, Model model) {
		model.addAttribute("listService",servicesRoomService.findAllService());
		IDadd = idRoom;
		model.addAttribute("roomID", IDadd);
		return "add-serviceRoom";
	}
	
	@RequestMapping("/room-booked-list/view-serviceRoom/{id}")
	public String viewServiceRoom(@PathVariable("id") int idRoomView, Model model) {
		IDview = idRoomView;
		model.addAttribute("listAllService",servicesRoomService.findAllServiceRoom(IDview));
		return "view-serviceRoom";
	}
	
	@RequestMapping(value = "/room-booked-list/save-serviceRoom/{id}" , method = RequestMethod. POST)
	public String addServiceRoom(@RequestParam(value = "serviceRoom", required = false) int[] checkboxValue, Model model, ServicesRoom servicesRoom) 
	{
		for(int framework: checkboxValue) {
			servicesRoomService.save1(IDadd, framework);
		}
		System.out.println("THÊM THÀNH CÔNG");
		viewServiceRoom(IDadd, model);
		return "view-serviceRoom";
	}
	
	@RequestMapping("/room-booked-list/delete-serviceRoom/{id}")
	public String deleteServiceRoom(@PathVariable int id, Model model) {
		servicesRoomService.delete(id);
		viewServiceRoom(IDadd, model);
		return "view-serviceRoom";
	}
	
}