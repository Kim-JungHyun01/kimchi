package com.kr.kimchi.controller;


import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kr.kimchi.service.PrpDetailPopService;
import com.kr.kimchi.vo.PrpVO;


@Controller
public class PrpDetailPopController {
	
	@Inject
	private PrpDetailPopService detailPopService;

	@GetMapping(value="/prpDetailPop")
	public ModelAndView paPop(@RequestParam("prp_no") Integer prp_no) {
		ModelAndView mav = new ModelAndView();
		PrpVO prpVO = detailPopService.prpPopData(prp_no);
		System.out.println("PrpDetailPopController prpVO :" + prpVO);
		mav.addObject("prpVO", prpVO);
		mav.setViewName("prp/prpDetailPop");
		return mav;
	}

	@PostMapping(value="/prpUpdate")
	public ModelAndView prpUpdate(@RequestParam("prp_no") int prp_no, @RequestParam("prp_revisionDate") String prp_revisionDate, 
			@RequestParam("prp_progress") int prp_progress, @RequestParam("prp_notes") String prp_notes,@RequestParam("pa_no") int pa_no) {
		ModelAndView mav = new ModelAndView();
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("prp_no", prp_no);
		map.put("prp_revisionDate", prp_revisionDate);
		map.put("prp_progress", prp_progress);
		map.put("prp_notes", prp_notes);
		detailPopService.prpUpdate(map);
		
		mav.addObject("pa_no", pa_no);
		System.out.println("pa-no :"+ pa_no);
		mav.setViewName("pa/paDetail");
		return mav;
	}
	
}
