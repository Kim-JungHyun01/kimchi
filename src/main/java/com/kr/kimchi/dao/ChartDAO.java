package com.kr.kimchi.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kr.kimchi.vo.MaterialVO;

@Repository
public class ChartDAO {

	private final static String namespace = "com.kr.kimchi.mappers.MaterialMapper";

	@Inject
	private SqlSession session;	

	// 차트 값
	public List<MaterialVO> machart(String startDate, String endDate) {
	    Map<String, Object> params = new HashMap<>();
	    params.put("startDate", startDate);
	    params.put("endDate", endDate);
	    
	    return session.selectList(namespace + ".machart", params);
	}
	//========================================================================
}
