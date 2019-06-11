package com.ngominhnhi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.ngominhnhi.entities.Services;
import com.ngominhnhi.mapper.ServicesMapper;
import com.ngominhnhi.service.ServicesService;
@Controller
public class RevenueReportController extends AbstractController{
	private ServicesService servicesService;
	private JdbcTemplate jdbcTemplate;
	@Override
	@RequestMapping("/output")
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String sql = "select * from service";
		System.out.println("ccc");	
		List<Services> listServicee = jdbcTemplate.query(sql, new ServicesMapper());
		
		
		for (Services s : listServicee) {
            System.out.println(s);
        }
		
		System.out.println("BBBBBBBBBBBBBBBB");
		//dummy data
		Map<String,String> revenueData = new HashMap<String,String>();
		revenueData.put("1/20/2010", "$100,000");
		revenueData.put("1/21/2010", "$200,000");
		revenueData.put("1/22/2010", "$300,000");
		revenueData.put("1/23/2010", "$400,000");
		revenueData.put("1/24/2010", "$500,000");
		revenueData.put("Quang", "UIT");
		return new ModelAndView("PdfRevenueSummary","revenueData",revenueData);
	}
		
	
}