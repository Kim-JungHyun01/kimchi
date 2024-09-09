package com.kr.kimchi.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kr.kimchi.vo.PartnerVO;

@Repository
public class PartnerDAO {
	
	private final static String namespace = "com.kr.kimchi.mappers.PartnerMapper";

	@Inject
	private SqlSession session;
	
//	협력회사 로그인
	public Map<String, Object> partnerLogin(Map<String, Object> partnermap){
		return session.selectOne(namespace + ".partnerLogin", partnermap);
	}//end
	
//	협력회사 전체  !!!!!!!!!!!!!!!!!!!!!!!! 여기 수정 있어요!!!!!!!!!!!!!!!!!!!!!!!!!
	public List<PartnerVO> partnerAll(int startRow, int pageSize){
		 Map<String, Object> params = new HashMap<>();
	        params.put("startRow", startRow);
	        params.put("pageSize", pageSize);
		return session.selectList(namespace+".partnerAll", params);
	}//end
	
//	레코드 수
	public Integer getTotalCount() {
		return session.selectOne(namespace + ".getTotalCount");		
	} //end
	
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