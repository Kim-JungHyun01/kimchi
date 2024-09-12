package com.kr.kimchi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kr.kimchi.dao.ChartDAO;
import com.kr.kimchi.vo.ChartVO;

@Service
public class ChartService {

    @Autowired
    private ChartDAO chartDAO;

    // 전체 재고 정보 조회
    public List<ChartVO> getChartData(String startDate, String endDate) {
        return chartDAO.getChartData(startDate, endDate);
    }

    // 상품별 총액 정보 조회
    public List<ChartVO> getChartTotalValue(String startDate, String endDate) {
        return chartDAO.getChartTotalValue(startDate, endDate);
    }
    // =================================
}
