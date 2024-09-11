package com.kr.kimchi.controller;


import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kr.kimchi.service.CodeService;
import com.kr.kimchi.service.ItemService;
import com.kr.kimchi.service.MaterialService;
import com.kr.kimchi.service.ObtainService;
import com.kr.kimchi.service.PaPopService;
import com.kr.kimchi.service.PaService;
import com.kr.kimchi.service.PartnerService;
import com.kr.kimchi.service.ProductionService;
import com.kr.kimchi.service.UserService;
import com.kr.kimchi.vo.MaterialVO;
import com.kr.kimchi.vo.ObtainVO;
import com.kr.kimchi.vo.PaVO;
import com.kr.kimchi.vo.PartnerVO;
import com.kr.kimchi.vo.ProductionVO;
import com.kr.kimchi.vo.UserVO;


@Controller
public class PaPopController {
	
	@Inject
	private PaPopService paPopService;
	
	@Inject
	private ObtainService obtservice;
	@Inject
	private UserService userservice;
	@Inject
	private PartnerService partservice;
	@Inject
	private ProductionService proservice;
	@Inject
	private MaterialService maservice;
	@Inject
	private CodeService codeservice;
	@Inject
	private PaService paservice;
	

	@PostMapping(value="/paPop")
	public ModelAndView paPop(@RequestParam("pa_no") Integer pa_no) {
		ModelAndView mav = new ModelAndView();
		PaVO paVO = paPopService.paPopList(pa_no);
		System.out.println("paPopController paVO :" + paVO);
		mav.addObject("paVO", paVO);
		mav.setViewName("pa/paPop");
		return mav;
	}
	
	@GetMapping(value="/paObPop")
	public ModelAndView paPop(@RequestParam("obtain_no") int obtain_no) {
		ObtainVO obtain = obtservice.obtainSelect(obtain_no);
		ProductionVO pro = proservice.productionSelect(obtain.getProduction_no());
		MaterialVO ma = maservice.maView(obtain.getMa_id());
		UserVO user = userservice.userSelect(obtain.getUser_id());
		PartnerVO partner = partservice.partnerSelect(obtain.getPartner_taxid());
		ModelAndView mav = new ModelAndView();
		mav.addObject("obtain", obtain);
		mav.addObject("pro", pro);
		mav.addObject("ma", ma);
		mav.addObject("user", user);
		mav.addObject("partner", partner);
		mav.setViewName("obtain/obtainSelect");
		mav.setViewName("pa/paObPop");
		return mav;
	}
	
	
}
