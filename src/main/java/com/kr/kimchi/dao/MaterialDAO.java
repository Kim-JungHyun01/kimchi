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

	private final static String namespace = "com.kr.kimchi.mappers.MaterialMapper";

	@Inject
	private SqlSession session;
	
	/// 전체 레코드 수
    public Integer getTotalCount() {		
        return session.selectOne(namespace + ".getTotalCount");
    }

    // 전체
    public List<MaterialVO> maList(int startRow, int pageSize) {
        Map<String, Object> params = new HashMap<>();
        params.put("startRow", startRow);
        params.put("pageSize", pageSize);
        
        // SQL 쿼리에서 페이지 정보 사용
        return session.selectList(namespace + ".maList", params);
    }

	// 선택
	public MaterialVO maView(int ma_id) {
		return session.selectOne(namespace + ".maView", ma_id);
	}

	// 추가
	public void maAdd(MaterialVO material) {
		session.insert(namespace + ".maAdd", material);
	}

	// 수정
	public void maUpdate(MaterialVO material) {
		session.update(namespace + ".maUpdate", material);
	}

	// 금액현황
	public List<Map<String, Object>> maReport(String startDate, String endDate, String ma_name) throws SQLException {

		// 파라미터 설정
		Map<String, Object> params = new HashMap<>();
		params.put("startDate", startDate);
		params.put("endDate", endDate);
		params.put("ma_name", ma_name);

		// SQL 쿼리 실행 (ma_date 기준)
		List<Map<String, Object>> reportData = session.selectList(namespace + ".maReport", params);

		return reportData;
	}
	// ============================
}
