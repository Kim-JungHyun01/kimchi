package com.kr.kimchi.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kr.kimchi.vo.AttachmentVO;
import com.kr.kimchi.vo.CalenderVO;

@Repository
public class CalenderDAO {
	
	private final static String namespace = "com.kr.kimchi.mappers.CalenderMapper";

	@Inject
	private SqlSession session;
	
	public List<CalenderVO> calenderList() {
		return session.selectList(namespace + ".calenderList");
	}

}
