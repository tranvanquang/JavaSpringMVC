package com.ngominhnhi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ngominhnhi.entities.Guest;
import com.ngominhnhi.service.GuestService;
@Controller
public class GuestController {
	
	@Autowired
	private GuestService guestService;
	@RequestMapping("/guest-list")
	public String serviceList(Model model) {
		model.addAttribute("listGuest", guestService.findAll());
		return "guest-list";
	}
	
	@RequestMapping("/guest/add-guest")
	public String addService(Model model) {
		model.addAttribute("guest", new Guest());
		return "add-guest";
	}
	
	@RequestMapping("/guest/update-guest/{id}")
	public String updateGuest(@PathVariable int id, Model model) {
		model.addAttribute("guest",guestService.findId(id));
		return "edit-guest";
	}
	
	@RequestMapping("/saveGuest")
	public String saveGuest(@ModelAttribute("Guest") Guest guest, Model model) {
		guestService.save(guest);
		
//		guestService.saveAccount(guest);
		model.addAttribute("listGuest", guestService.findAll());
		return "redirect:/guest-list";
	}
	
	@RequestMapping("/guest/delete-guest/{id}")
	public String deleteGuest(@PathVariable int id, Model model) {
		guestService.delete(id);
		return "redirect:/guest-list";
	}
	
	@RequestMapping("/updateGuest")
	public String updateGuest(@ModelAttribute("Guest") Guest guest, Model model) {
		guestService.update(guest);
		model.addAttribute("listGuest", guestService.findAll());
		return "redirect:/guest-list";
	}
}