package com.kr.kimchi.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kr.kimchi.vo.CodeVO;

@Repository
public class CodeDAO {

	private final static String namespace = "com.kr.kimchi.codeMapper";

	@Inject
	private SqlSession session;
	
//	코드추가
	public void codeInsert(CodeVO code) {
		session.selectOne(namespace+".codeInsert", code);
	}//end
	
//	코드삭제
	public void codeDelete(int code_id) {
		session.selectOne(namespace+".codeDelete", code_id);
	}//end
	
}// end class
