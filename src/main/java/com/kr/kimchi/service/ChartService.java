package com.kr.kimchi.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
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
    //=========================
}
