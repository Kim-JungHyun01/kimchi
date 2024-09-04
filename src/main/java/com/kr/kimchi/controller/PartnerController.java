package com.kr.kimchi.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kr.kimchi.service.PartnerService;
import com.kr.kimchi.vo.PartnerVO;

@Controller
public class PartnerController {

	@Inject
	private PartnerService partservice;

//	협력회사 전체
	@GetMapping(value = "partner/partnerAll")
	public ModelAndView partnerAll() {
		List<PartnerVO> partnerlist = partservice.partnerAll();
		ModelAndView mav = new ModelAndView();
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
		List<PartnerVO> partnerlist = partservice.partnerAll();//taxid, id중복확인
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
