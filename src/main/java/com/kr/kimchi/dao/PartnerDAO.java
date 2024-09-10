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
	public List<PartnerVO> partnerAll(int startRow, int pageSize, String partner_companyname){
		 Map<String, Object> params = new HashMap<>();
		 
	        params.put("startRow", startRow);
	        params.put("pageSize", pageSize);
	        params.put("partner_companyname", partner_companyname);
	        
	     // SQL 쿼리에서 페이지 정보 + 검색 조건 사용   
		return session.selectList(namespace+".partnerAll", params);
	}//end
	
//	전체 레코드 수
	public Integer getTotalCount() {
		return session.selectOne(namespace + ".getTotalCount");		
	} //end
	
//	검색 이후 페이지 수 계산
	public Integer partnerSearch(int pageSize, String partner_companyname) {
		Map<String, Object> params = new HashMap<>();
		params.put("partner_companyname", partner_companyname);
		Integer totalCount = session.selectOne(namespace + ".partnerSearch", params);
		if (totalCount == null || totalCount == 0) {
    		return 0;
    	}
		return (int) Math.ceil((double) totalCount / pageSize);
	}
	
//	협력회사 상세
	public PartnerVO partnerSelect(String partner_taxid) {
		return session.selectOne(namespace+".partnerSelect", partner_taxid);
	}//end
	
//	협력회사 회원가입
	public void partnerInsert(PartnerVO partner) {
		session.selectOne(namespace+".partnerInsert", partner);
	}//end
	
//	협력사 사업자번호 중목확인
	public Integer partnertaxIdCheck(String partner_taxid) {
		return session.selectOne(namespace+".partnertaxIdCheck", partner_taxid);
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