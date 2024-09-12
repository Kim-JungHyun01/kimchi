package com.kr.kimchi.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kr.kimchi.dao.MaterialDAO;
import com.kr.kimchi.vo.MaterialVO;

@Service
public class MaterialService {

    @Inject
    private MaterialDAO madao;

    // 전체 + 페이징 + 검색
    public List<MaterialVO> maList(int startRow, int pageSize, String ma_name) {
        return madao.maList(startRow, pageSize, ma_name); 
    }
    
    // 전체 레코드 수
    public Integer getTotalCount() {
        return madao.getTotalCount();   	
    }

    // 검색 페이지 수
    public Integer getSearch(int pageSize, String ma_name) {
        return madao.getSearch(pageSize, ma_name);
    }

    // 선택
    public MaterialVO maView(int ma_id) {
        return madao.maView(ma_id);
    }
    
    // 추가
    public void maAdd(MaterialVO material) {
        material.calStockValue();
        madao.maAdd(material); 
    }

    // 수정
    public void maUpdate(MaterialVO material) {
        madao.maUpdate(material);
    }
    
    // 리포트
    public List<Map<String, Object>> maReport(String startDate, String endDate, String ma_name) throws SQLException {
        return madao.maReport(startDate, endDate, ma_name);
    }
    //===========================
}
