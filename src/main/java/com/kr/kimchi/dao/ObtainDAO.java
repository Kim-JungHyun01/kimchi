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

	public List<ObtainVO> obtainAll() {
		return session.selectList(namespace + ".obtainAll");
	}// end

	public ObtainVO obtainSelect(int obtain_no) {
		return session.selectOne(namespace + ".obtainSelect", obtain_no);
	}// end

	public void obtainInsert(ObtainVO obt) {
		session.selectOne(namespace+".obtainInsert", obt);
	}// end

	public void obtainUpdate(ObtainVO obt) {
		session.selectOne(namespace+".obtainUpdate", obt);
	}// end

	public void obtainCheck(ObtainVO obt) {
		session.selectOne(namespace+".obtainCheck", obt);
	}// end

	public void obtainPa(int obtain_no) {
		session.selectOne(namespace+".obtainPa", obtain_no);
	}// end
	
	public List<ObtainVO> obSelectList() {
		return session.selectList(namespace + ".obSelectList");
	}// end
	

}// end class
