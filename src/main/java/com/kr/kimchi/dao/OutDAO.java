package com.kr.kimchi.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kr.kimchi.vo.IOVO;

@Repository
public class OutDAO {

    private final static String nameSpace = "com.kr.kimchi.mappers.OutMapper";

    @Inject
    private SqlSession session;
    
    // 전체 레코드 수
    public Integer getTotalCount() {
        return session.selectOne(nameSpace + ".getTotalCount");
    }
    
    // 전체 outList
    public List<IOVO> outList(int startRow, int pageSize) {
    	Map<String, Object> params = new HashMap<>();
    	params.put("startRow", startRow);
    	params.put("pageSize", pageSize);
    	
    	// sql 페이지 정보 사용
		return session.selectList(nameSpace +".outList", params);
    }  	 
    
    // 선택 outView
    public IOVO outView(int io_id) {
        return session.selectOne(nameSpace + ".outView", io_id);
    }
    
    // 출고 정보 삽입
    public void outAdd(IOVO out) {
        session.insert(nameSpace + ".outAdd", out);
    }
    
    // 자재 정보 업데이트 (재고 수량 감소)
    public void updateMa(IOVO out) {
        session.update(nameSpace + ".updateMa", out); // 재고 수량 감소
    }   
}
