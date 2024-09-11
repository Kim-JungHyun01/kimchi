package com.kr.kimchi.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kr.kimchi.vo.CodeVO;
import com.kr.kimchi.vo.PaVO;
import com.kr.kimchi.vo.PcspVO;


@Repository
public class PcspDAO {
	
	private final static String namespace="com.kr.kimchi.mappers.pcspMapper";
	
	@Inject
	private SqlSession session;

	public List<PcspVO> pcspList(String partner_taxid) {
		return session.selectList(namespace+".pcspList",partner_taxid);
	}
	
	public void pcspInsert(PcspVO pcspVO) {
		session.selectOne(namespace+".pcspInsert", pcspVO);
	}
	
	
	
	
	
}//end class
