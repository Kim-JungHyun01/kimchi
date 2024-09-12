package com.kr.kimchi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChartController {

//    @Autowired
//    private ChartService chartService;

    @GetMapping("/calender/chart")
    public String showChartPage() {
        return "calender/chart"; 
    }
    
    
//    // 차트 화면 데이터
//    @GetMapping("/calender/chart_SHIN")
//    @ResponseBody
//    public List<ChartVO> getChartData(@RequestParam(required = false) String startDate,
//                                       @RequestParam(required = false) String endDate) {
//    	System.out.println("1" + startDate + " - " +  endDate);
//        return chartService.getChartData(startDate, endDate);
//    }
    //================
}
