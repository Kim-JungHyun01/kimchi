package com.kr.kimchi.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kr.kimchi.dao.ChartDAO;

@Service
public class ChartService {

    @Autowired
    private ChartDAO chartdao;

    @Scheduled(cron = "0 0 0 * * ?") // 매일 자정에 실행
    public void updateChartData() {
        // 데이터 갱신 로직
    }

    // 전체 재고 정보 조회
    public List<Map<String, Object>> chartData() throws SQLException {
        return chartdao.chartData();
    }

    // 전체 재고 총액 정보 조회
    public List<Map<String, Object>> totalStockChart() throws SQLException {
        return chartdao.totalStockChart();
    }
    
    // 입고 수량 정보
    public List<Map<String, Object>> inChart() throws SQLException {
        return chartdao.inChart();
    }

    // 출고 수량 정보
    public List<Map<String, Object>> outChart() throws SQLException {
        return chartdao.outChart();
    }
    //====================================
    
//  물품별 계약수량, 계약금액_누적
    public List<Map<String, Object>> totalitemChart() throws SQLException{
    	return chartdao.totalitemChart();
    }//end
}
