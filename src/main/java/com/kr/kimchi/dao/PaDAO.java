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
	
	
//	 페이퍼 추가
	public void paInsert(PaVO pa) {
		session.selectOne(namespace+".paInsert", pa);
	}//end
	
//	 페이퍼 수정
	public void paUpdate(PaVO pa) {
		session.selectOne(namespace+".paUpdate", pa);
	}//end
	
//	페이처 체크
	public void paCheck(int pa_no) {
		session.selectOne(namespace+".paCheck", pa_no);
	}//end
	
//	페이퍼 보기
	public PaVO paSelect(Map<String, Object> params){
		return session.selectOne(namespace+".paSelect", params);
	}//end
	
	
	
}//end class
