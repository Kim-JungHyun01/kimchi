package com.kr.kimchi;

import java.sql.SQLException;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;

import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kr.kimchi.service.CalenderService;
import com.kr.kimchi.service.ChartService;
import com.kr.kimchi.vo.CalenderVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Inject
    private CalenderService service;

    @Autowired
    private ChartService chartService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpSession session) throws SQLException, JsonProcessingException {
		//login부분
		Object userLogin = session.getAttribute("userlogin");
	    Object partLogin = session.getAttribute("partlogin");
	    if (userLogin == null && partLogin == null) {
	        return "redirect:/login/loginForm";
	    }
		//캘린더 부분
		List<CalenderVO> list = service.calenderList();
		System.out.println("list : " + list);
		model.addAttribute("list", list );
		

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model, HttpSession session) throws SQLException, JsonProcessingException {

        List<CalenderVO> list = service.calenderList();
        System.out.println("list : " + list);
        model.addAttribute("list", list);

        // 전체 재고 정보 
        List<Map<String, Object>> chartData = chartService.chartData(); 

        // 전체 재고 총액 정보 조회 
        List<Map<String, Object>> totalStock = chartService.totalStockChart(); 

        // 입고 수량 정보
        List<Map<String, Object>> inChart = chartService.inChart();
        
        // 출고 수량 정보
        List<Map<String, Object>> outChart = chartService.outChart();

        // ObjectMapper 생성
        ObjectMapper objectMapper = new ObjectMapper();

        // 모델에 JSON 문자열 추가
        String jsonChartData = objectMapper.writeValueAsString(chartData);
        String jsonTotalStock = objectMapper.writeValueAsString(totalStock);
        String jsonInChart = objectMapper.writeValueAsString(inChart);
        String jsonOutChart = objectMapper.writeValueAsString(outChart);

        model.addAttribute("chartData", jsonChartData);
        model.addAttribute("totalStock", jsonTotalStock);
        model.addAttribute("inChart", jsonInChart);
        model.addAttribute("outChart", jsonOutChart);

        return "calender/startPage";
    }
}
