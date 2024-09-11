package com.kr.kimchi.dao;


import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kr.kimchi.vo.PaVO;


@Repository
public class PaPopDAO {
	
	private final static String namespace="com.kr.kimchi.mappers.paPopMapper";
	
	@Inject
	private SqlSession session;

	public PaVO paPopList(int pa_no) {
		return session.selectOne(namespace+".paPopList",pa_no);
	}
}
