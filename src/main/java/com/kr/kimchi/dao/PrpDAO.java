package com.kr.kimchi.dao;


import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kr.kimchi.vo.PrpVO;


@Repository
public class PrpDAO {
	
	private final static String namespace="com.kr.kimchi.mappers.prpMapper";
	
	@Inject
	private SqlSession session;

	
	
	public void prpInsert(PrpVO prpVO) {
		session.selectOne(namespace+".prpInsert",prpVO);
	}
	
	public List<PrpVO> prpList(int pa_no) {
		return session.selectList(namespace+".prpList",pa_no);
	}
}
