package com.ngominhnhi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ngominhnhi.entities.Services;
import com.ngominhnhi.service.ServicesService;
import com.tranvanquang.report.ServiceReport;
@Controller
public class ServicesController {
	
	@Autowired
	private ServicesService servicesService;
	@RequestMapping("/services-list")
	public String serviceList(Model model) {
		model.addAttribute("listService",servicesService.findAll());
		return "services-list";
	}
	
	@RequestMapping("/service/delete-service/{id}")
	public String deleteService(@PathVariable int id, Model model) {
		servicesService.delete(id);
		return "redirect:/services-list";
	}
	
	@RequestMapping("/service/update-service/{id}")
	public String updateService(@PathVariable int id, Model model) {
		model.addAttribute("service",servicesService.findId(id));
		return "edit-service";
	}
	
	@RequestMapping("/service/add-service")
	public String addService(Model model) {
		model.addAttribute("service", new Services());
		return "add-service";
	}
	
	@RequestMapping("/saveService")
	public String saveService(@ModelAttribute("Services") Services service, Model model) {
		servicesService.save(service);
		model.addAttribute("listService", servicesService.findAll());
		return "redirect:/services-list";
	}
	@RequestMapping("/updateService")
	public String updateService(@ModelAttribute("Services") Services service, Model model) {
		servicesService.update(service);
		model.addAttribute("listService", servicesService.findAll());
		return "redirect:/services-list";
	}
	
	@RequestMapping("/service/report")
	public String report(ModelMap modelMap) {
		System.out.println("CCCCCCCCCCCC");
		ServiceReport sr = new ServiceReport();
		modelMap.put("listSercicesReport", sr.find());
		System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBB");
		return "serviceReport";
	}

}
