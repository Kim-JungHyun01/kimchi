package com.kr.kimchi.dao;


import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kr.kimchi.vo.PrpVO;


@Repository
public class PrpDetailPopDAO {
	
	private final static String namespace="com.kr.kimchi.mappers.prpDetailPopMapper";
	
	@Inject
	private SqlSession session;

	
	
	public PrpVO prpPopData(int prp_no) {
		return session.selectOne(namespace+".prpPopData",prp_no);
		
	}
	
	public void prpUpdate(Map<String, Object> map) {
		session.selectOne(namespace+".prpUpdate",map);
		
	}
	
	
}
