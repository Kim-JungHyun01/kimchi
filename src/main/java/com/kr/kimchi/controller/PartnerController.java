package com.kr.kimchi.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kr.kimchi.service.PartnerService;
import com.kr.kimchi.vo.PaginationVO;
import com.kr.kimchi.vo.PartnerVO;

@Controller
public class PartnerController {

	@Inject
	private PartnerService partservice;

//	협력회사 전체
	@GetMapping(value = "partner/partnerAll")
	public ModelAndView partnerAll(@RequestParam(defaultValue = "1") int pageNum) {
		
		int pageSize = 2; // 한 페이지에 보여줄 갯수 // db에 3개 밖에 없어서 2로 설정했어요!
	    int pageNavSize = 5; // 페이지 네비 크기
	    
	    int startRow = (pageNum - 1) * pageSize; //시작페이지 계산
		
		List<PartnerVO> partnerlist = partservice.partnerAll(startRow, pageSize);
		
		Integer totalCount = partservice.getTotalCount(); // 총 레코드 수 가져옴
		
		PaginationVO pagination = new PaginationVO(pageNum, totalCount, pageSize, pageNavSize);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("pagination", pagination);
	    mav.addObject("currentPage", pageNum);
	    mav.addObject("totalPages", pagination.getTotalPage());
		
		mav.addObject("partnerlist", partnerlist);
		mav.setViewName("partner/partnerAll");
		return mav;
	}// end

//	협력회사 상세
	@GetMapping(value = "partner/partnerSelect")
	public ModelAndView partnerSelect(String partner_taxid) {
		PartnerVO part = partservice.partnerSelect(partner_taxid);
		ModelAndView mav = new ModelAndView();
		mav.addObject("part", part);
		mav.setViewName("partner/partnerSelect");
		return mav;
	}// end

//	협력회사 회원가입
	@GetMapping(value = "partner/partnerInsertForm")
	public ModelAndView partnerInsertForm() {
		List<PartnerVO> partnerlist = partservice.partnerAll(10, 0);//taxid, id중복확인
		ModelAndView mav = new ModelAndView();
		mav.addObject("partnerlist", partnerlist);
		mav.setViewName("partner/partnerInsertForm");
		return mav;
	}// end

	@PostMapping(value = "partner/partnerInsert")
	public String partnerInsert(PartnerVO part) {
		partservice.partnerInsert(part);
		return "redirect:/login/loginForm";
	}// end

//	협력회사 정보 수정
	@GetMapping(value = "partner/partnerUpdateForm")
	public ModelAndView partnerUpdateForm(String partner_taxid) {
		PartnerVO part = partservice.partnerSelect(partner_taxid);
		ModelAndView mav = new ModelAndView();
		mav.addObject("part", part);
		mav.setViewName("partner/partnerUpdateForm");
		return mav;
	}// end

	@PostMapping(value = "partner/partnerUpdate")
	public String partnerUpdate(PartnerVO part) {
		partservice.partnerUpdate(part);
		return "redirect:/partner/partnerSelect?partner_taxid=" + part.getPartner_taxid();
	}// end

//	협력회사 승인
	@PostMapping(value = "partner/partnerApproval")
	public String partnerApproval(PartnerVO part) {
		partservice.partnerApproval(part);
		return "redirect:/partner/partnerSelect?partner_taxid=" + part.getPartner_taxid();
	}// end

}// end class
