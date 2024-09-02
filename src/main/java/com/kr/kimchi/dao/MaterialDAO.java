package com.kr.kimchi.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kr.kimchi.vo.MaterialVO;

@Repository
public class MaterialDAO {
	
	private final static String nameSpace = "com.kr.kimchi.mappers.MaterialMapper";
	
	@Inject
	private SqlSession session;
	
	// 전체
	public List<MaterialVO> maList() {
		return session.selectList(nameSpace + ".maList");
	}
	
	// 선택
	public MaterialVO maView(int ma_id) {
		return session.selectOne(nameSpace + ".maView", ma_id);
	}
	
	// 추가
	public void maAdd(MaterialVO material) {
		session.insert(nameSpace + ".maAdd", material);
	}
	
	// 수정
	public void maUpdate(MaterialVO material) {
		session.update(nameSpace + ".maUpdate", material);
	}
	
	// 금액현황
	public List<Map<String, Object>> maReport(String startDate, String endDate) throws SQLException {

	    // 파라미터 설정
	    Map<String, Object> params = new HashMap<>();
	    params.put("startDate", startDate);
	    params.put("endDate", endDate);

	    // SQL 쿼리 실행
	    List<Map<String, Object>> reportData = session.selectList(nameSpace + ".maReport", params);
	    
	    return reportData;
	}

	//============================
}
