package com.tranvanquang.report;

import java.util.*;

import com.ngominhnhi.entities.*;
import com.ngominhnhi.service.*;

public class ServiceReport {

	public List<Map<String, ?>> find(){
		
		System.out.println("THIS IS FUNCTION FIND");
		List<Map<String, ?>> listServices = new ArrayList<Map<String, ?>>();
		ServicesService servicesService = new ServicesService();
		System.out.println("Service report");
		for (Services s : servicesService.find()) {
			Map<String, Object> m = new HashMap<String, Object>();
			m.put("id", s.getId());
			m.put("id", s.getName());
			m.put("id", s.getPrice());
			listServices.add(m);
		}
		return listServices;
	}
}
