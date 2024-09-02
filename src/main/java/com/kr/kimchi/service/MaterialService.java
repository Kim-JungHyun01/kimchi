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

    // 전체
    public List<MaterialVO> maList() {
        return madao.maList();
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
    public List<Map<String, Object>> maReport(String startDate, String endDate) throws SQLException {
        return madao.maReport(startDate, endDate);
    }
    //===========================
}
