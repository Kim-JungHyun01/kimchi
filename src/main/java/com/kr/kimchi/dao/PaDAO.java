package com.kr.kimchi.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kr.kimchi.vo.PaVO;


@Repository
public class PaDAO {
	
	private final static String namespace="com.kr.kimchi.mappers.paMapper";
	
	@Inject
	private SqlSession session;

	public List<PaVO> paList(Map<String, Object> params) {
		return session.selectList(namespace+".paList",params);
	}
	
	public List<PaVO> paAllList() {
		return session.selectList(namespace+".paAllList");
	}
}
