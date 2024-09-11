package com.kr.kimchi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kr.kimchi.service.ChartService;
import com.kr.kimchi.vo.MaterialVO;

@Controller
public class ChartController {

	@Autowired
	private ChartService chartservice;
	
	@GetMapping(value = "/start/chart")
	public ModelAndView machart(@RequestParam(required = false) String startDate, 
	                             @RequestParam(required = false) String endDate) {
	    ModelAndView mav = new ModelAndView("start/chart");
	    List<MaterialVO> chartData = chartservice.machart(startDate, endDate);
	    
	    mav.addObject("chartData", chartData);
	    return mav;
	}
	//===============================
}
