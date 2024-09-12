package com.kr.kimchi.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kr.kimchi.service.ChartService;
import com.kr.kimchi.vo.ChartVO;

@Controller
public class ChartController {

	@Autowired
	private ChartService chartservice;
	
    // 차트 화면
	@GetMapping("/calender/chart")
	@ResponseBody
	public List<ChartVO> getChartData(@RequestParam(required = false) String startDate,
	                                    @RequestParam(required = false) String endDate) {
	    return chartservice.getChartData(startDate, endDate);
	}
	//===============================
}
