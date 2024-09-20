package com.kr.kimchi.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kr.kimchi.dao.ChartDAO;

@Service
public class ChartService {

    @Autowired
    private ChartDAO chartdao;

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
}
