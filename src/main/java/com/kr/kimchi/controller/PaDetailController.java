package com.kr.kimchi.controller;


import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kr.kimchi.service.PaPopService;
import com.kr.kimchi.service.PrpService;
import com.kr.kimchi.vo.PaVO;
import com.kr.kimchi.vo.PrpVO;


@Controller
public class PaDetailController {
	
	@Inject
	private PaPopService paPopService;
	
	@Inject
	private PrpService prpaService;
	

	@PostMapping(value="/paDetail")
	public ModelAndView paPop(@RequestParam("pa_no") Integer pa_no) {
		ModelAndView mav = new ModelAndView();
		PaVO paVO = paPopService.paPopList(pa_no);
		List<PrpVO> prpList = prpaService.prpList(pa_no);
		System.out.println("paPopController paVO :" + paVO);
		mav.addObject("paVO", paVO);
		mav.addObject("prpList", prpList);
		mav.setViewName("pa/paDetail");
		return mav;
	}
	
}
