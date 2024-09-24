package com.kr.kimchi.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper; // 추가
import com.kr.kimchi.service.ChartService;

@Controller
public class ChartController {

    @Autowired
    private ChartService chartService;

    // 시작 페이지 보여주기
    @GetMapping("/calender/chart")
    public String showStartPage(Model model) throws SQLException, JsonProcessingException {
        // 차트 데이터 조회
        List<Map<String, Object>> chartData = chartService.chartData();
        // 전체 재고 총액 정보 조회
        List<Map<String, Object>> totalStock = chartService.totalStockChart();

        // ObjectMapper 생성
        ObjectMapper objectMapper = new ObjectMapper();
        
        // 모델에 JSON 문자열 추가
        String jsonChartData = objectMapper.writeValueAsString(chartData);
        String jsonTotalStock = objectMapper.writeValueAsString(totalStock);

        model.addAttribute("chartData", jsonChartData);
        model.addAttribute("totalStock", jsonTotalStock);

        return "calender/start"; 
        //======================
    }
}

    // 시작 페이지 보여주기
    @GetMapping("/calender/chart")
    public String showStartPage(Model model) throws SQLException, JsonProcessingException {
        // 차트 데이터 조회
        List<Map<String, Object>> chartData = chartService.chartData();
        // 전체 재고 총액 정보 조회
        List<Map<String, Object>> totalStock = chartService.totalStockChart();

        // ObjectMapper 생성
        ObjectMapper objectMapper = new ObjectMapper();
        
        // 모델에 JSON 문자열 추가
        String jsonChartData = objectMapper.writeValueAsString(chartData);
        String jsonTotalStock = objectMapper.writeValueAsString(totalStock);

        model.addAttribute("chartData", jsonChartData);
        model.addAttribute("totalStock", jsonTotalStock);

        return "calender/chart"; 
    }
    
//    itemmodal창에서
    @GetMapping("item/itemchart")
    public String totalitemChart(Model model) throws SQLException, JsonProcessingException{
    	
    	//계약량 데이터 조회
    	List<Map<String, Object>> chartData = chartService.totalitemChart();
    	
    	// ObjectMapper 생성
        ObjectMapper objectMapper = new ObjectMapper();
        
     // 모델에 JSON 문자열 추가
        String jsonChartData = objectMapper.writeValueAsString(chartData);
        
        model.addAttribute("chartData", jsonChartData);
    	
    	return "item/itemchart";
    }//end
    
    
    
    
    
}//end class
