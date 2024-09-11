package com.kr.kimchi.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kr.kimchi.dao.PartnerDAO;
import com.kr.kimchi.vo.PartnerVO;

@Service
public class PartnerService {
	
	@Inject
	private PartnerDAO partdao;
	
//	협력회사 로그인
	public Map<String, Object> partnerLogin(Map<String, Object> partnermap){
		return partdao.partnerLogin(partnermap);
	}//end
	
//	협력회사 전체 + 페이징
	public List<PartnerVO> partnerAll(int startRow, int pageSize, String partner_companyname){
		return partdao.partnerAll(startRow, pageSize, partner_companyname);
	}//end
	
//	전체 레코드 수
    public Integer getTotalCount() {
		return partdao.getTotalCount();   	
    }//end
    
    // 검색 이후 페이지 수 
    public Integer partnerSearch(int pageSize, String partner_companyname) {
		return partdao.partnerSearch(pageSize, partner_companyname);
    }
	
//	협력회사 상세
	public PartnerVO partnerSelect(String partner_taxid) {
		return partdao.partnerSelect(partner_taxid);
	}//end
	
//	협력회사 회원가입
	public void partnerInsert(PartnerVO partner) {
		partdao.partnerInsert(partner);
	}//end
	
//	협력회사 정보 수정
	public void partnerUpdate(PartnerVO partner) {
		partdao.partnerUpdate(partner);
	}//end
	
//	협력회사 승인
	public void partnerApproval(PartnerVO partner) {
		partdao.partnerApproval(partner);
	}//end
	
	

}//end class
