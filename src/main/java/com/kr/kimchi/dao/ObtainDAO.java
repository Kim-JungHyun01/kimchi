package com.kr.kimchi.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kr.kimchi.vo.ObtainVO;

@Repository
public class ObtainDAO {
	private final static String namespace = "com.kr.kimchi.mappers.obtainMapper";

	@Inject
	private SqlSession session;

//	조달계획 보기_전체
	public List<ObtainVO> obtainAll() {
		return session.selectList(namespace + ".obtainAll");
	}// end

//	조달계획 보기_상세
	public ObtainVO obtainSelect(int obtain_no) {
		return session.selectOne(namespace + ".obtainSelect", obtain_no);
	}// end

//	조달계획 추가
	public void obtainInsert(ObtainVO obt) {
		session.selectOne(namespace+".obtainInsert", obt);
	}// end

//	조달계획 수정
	public void obtainUpdate(ObtainVO obt) {
		session.selectOne(namespace+".obtainUpdate", obt);
	}// end

//	조달계획 승인 
	public void obtainCheck(ObtainVO obt) {
		session.selectOne(namespace+".obtainCheck", obt);
	}// end

}// end class
