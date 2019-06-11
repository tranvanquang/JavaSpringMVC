package com.ngominhnhi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ngominhnhi.entities.Room;
import com.ngominhnhi.service.RoomService;

@Controller
public class RoomController {
	
	@Autowired
	private RoomService roomService;
	
	@RequestMapping(value = { "/login", "/" })
	public String login() {
		return "login";
	}
	
	@RequestMapping("/home")
	public String admin() {
		return "admin";
	}

	@RequestMapping("/logout")
	public String logout(final Model model) {
		model.addAttribute("message", "Logged out!");
		return "login";
	}

	@RequestMapping(value= {"/admin"})
	public String loginUser(Model model) {
		model.addAttribute("listRoom", roomService.findAll());
		return "bookingroom";
	}
	
	@RequestMapping(value= {"/bookingroom"})
	public String bookingroom(Model model) {
		model.addAttribute("listRoom", roomService.findAll());
		return "bookingroom";
	}
	
	@RequestMapping("/room/{name}/reservation")
	public String reservation(@PathVariable String name, Model model) {
		Room room = roomService.findByName(name);
		model.addAttribute("room", room);
		return "reservation";
	}
	@RequestMapping("/room/{name}/change-room-information")
	public String changeRoomInformation(@PathVariable String name, Model model) {
		Room room = roomService.findByName(name);
		model.addAttribute("room", room);
		return "change-room-information";
	}
	@RequestMapping("/updateRoom")
	public String changeRomInfo(@ModelAttribute("Room") Room room, Model model) {
		roomService.update(room);
		System.out.println(room.getStandard()+room.getStatus());
		model.addAttribute("listRoom", roomService.findAll());
		return "redirect:/bookingroom"; 
	}
	@RequestMapping("/add-single-room")
	public String addSingleRoom(Model model) {
		model.addAttribute("room", new Room());
		model.addAttribute("standard", "single");
		return "add-room";
	}
	@RequestMapping("/add-douple-room")
	public String addDoupleRoom(Model model) {
		model.addAttribute("room", new Room());
		model.addAttribute("standard", "douple");
		return "add-room";
	}
	@RequestMapping(value= {"/saveRoom"})
	public String saveRoom(@ModelAttribute("Room") Room room,Model model) {
//		Room room1 = roomService.findByName(room.getName());
//		if(room1 != room.name) {
//			return "redirect:/bookingroom";
//		} 
		roomService.save(room);
		model.addAttribute("listRoom", roomService.findAll());
		return "redirect:/bookingroom";
	}

	@RequestMapping("/room/{name}")
	public String displayRoom(@PathVariable String name, Model model) {
		Room room = roomService.findByName(name);
		model.addAttribute("room", room);
		if(room.getStatus().equals("available")) {
			return "availableroom";
		} else if(room.getStatus().equals("booked")) {
			return "booked-room";
		} else {
			return "redirect:/room/{name}/change-room-information";
		}
		
	}
}
