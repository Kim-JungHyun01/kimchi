package com.kr.kimchi.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kr.kimchi.vo.CodeVO;
import com.kr.kimchi.vo.PaVO;


@Repository
public class PaDAO {
	
	private final static String namespace="com.kr.kimchi.mappers.paMapper";
	
	@Inject
	private SqlSession session;

	public List<PaVO> paList(Map<String, Object> params) {
		return session.selectList(namespace+".paList",params);
	}
	
	public List<PaVO> paAllList(int pa_checkStatus) {
		return session.selectList(namespace+".paAllList",pa_checkStatus);
	}
	
	// 구매발주서 코드발행
	public void paCode(String code) {
		session.selectOne(namespace+".paCode", code);
	}

	// 구매발주서 코드검색
	public int paCodeSelecet(String code_name) {
		return session.selectOne(namespace+".paCodeSelecet", code_name);
	}

	public void paPlus(Map<String, Object> map) {
		session.selectOne(namespace+".paPlus", map);
	}
	
	public void prpFinsh(int pa_no) {
		session.selectOne(namespace+".prpFinsh", pa_no);
	}

	public void prpIng(int pa_no) {
		session.selectOne(namespace+".prpIng", pa_no);
	}
	
	
	public void paInsert(PaVO pa) {
		session.selectOne(namespace+".paInsert", pa);
	}//end
	
	public void paUpdate(PaVO pa) {
		session.selectOne(namespace+".paUpdate", pa);
	}//end
	
	public void paCheck(int pa_no) {
		session.selectOne(namespace+".paCheck", pa_no);
	}//end
	
	public PaVO paSelect(Map<String, Object> params){
		return session.selectOne(namespace+".paSelect", params);
	}//end
	
	
	
}//end class
