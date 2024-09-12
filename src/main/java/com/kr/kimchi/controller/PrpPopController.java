package com.kr.kimchi.controller;


import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kr.kimchi.service.PaPopService;
import com.kr.kimchi.vo.PaVO;


@Controller
public class PrpPopController {
	
	@Inject
	private PaPopService paPopService;
	

	@GetMapping(value="/prpPop")
//	public ModelAndView paPop(@RequestParam("pa_no") Integer pa_no) {
	public ModelAndView paPop() {
		ModelAndView mav = new ModelAndView();
//		PaVO paVO = paPopService.paPopList(pa_no);
//		System.out.println("paPopController paVO :" + paVO);
//		mav.addObject("paVO", paVO);
		mav.setViewName("prp/prpPop");
		return mav;
	}
	
}
