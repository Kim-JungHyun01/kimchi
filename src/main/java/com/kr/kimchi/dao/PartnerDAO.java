package com.kr.kimchi.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kr.kimchi.vo.PartnerVO;

@Repository
public class PartnerDAO {
	
	private final static String namespace = "com.kr.kimchi.PartnerMapper";

	@Inject
	private SqlSession session;
	
//	협력회사 로그인
	public Map<String, Object> partnerLogin(Map<String, Object> partnermap){
		return session.selectOne(namespace + ".partnerLogin", partnermap);
	}//end
	
//	협력회사 전체
	public List<PartnerVO> partnerAll(){
		return session.selectList(namespace+".partnerAll");
	}//end
	
//	협력회사 상세
	public PartnerVO partnerSelect(String partner_taxid) {
		return session.selectOne(namespace+".partnerSelect", partner_taxid);
	}//end
	
//	협력회사 회원가입
	public void partnerInsert(PartnerVO partner) {
		session.selectOne(namespace+".partnerInsert", partner);
	}//end
	
//	협력회사 정보 수정
	public void partnerUpdate(PartnerVO partner) {
		session.selectOne(namespace+".partnerUpdate", partner);
	}//end
	
//	협력회사 승인
	public void partnerApproval(PartnerVO partner) {
		session.selectOne(namespace+".partnerApproval", partner);
	}//end
	
}// end class