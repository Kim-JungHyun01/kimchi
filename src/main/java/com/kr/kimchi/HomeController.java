package com.kr.kimchi;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
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
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@Inject
	private CalenderService service;
	
	@Autowired
    private ChartService chartService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpSession session) throws Exception {
		Object userLogin = session.getAttribute("userlogin");
	    Object partLogin = session.getAttribute("partlogin");
	    
	    if (userLogin == null && partLogin == null) {
	        return "redirect:/login/loginForm";
	    }
		
		List<CalenderVO> list = service.calenderList();
		model.addAttribute("list", list );
		

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
		
		return "calender/startPage";
	}
	
}
