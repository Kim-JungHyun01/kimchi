package com.kr.kimchi.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kr.kimchi.service.ObtainService;
import com.kr.kimchi.vo.ContractsVO;
import com.kr.kimchi.vo.ObtainVO;

@Controller
public class ObtainController {
	
	@Inject
	private ObtainService obtservice;
	
//	조달계획 보기_전체
	@GetMapping(value = "obtain/obtainAll")
	public ModelAndView obtainAll() {
		List<ObtainVO> oblist = obtservice.obtainAll();
		ModelAndView mav = new ModelAndView();
		mav.addObject("oblist", oblist);
		mav.setViewName("obtain/obtainAll");
		return mav;
	}//end
	
//	조달계획 보기_상세
	@GetMapping(value = "obtain/obtainSelect")
	public ModelAndView obtainSelect(int obtain_no) {
		ObtainVO ob = obtservice.obtainSelect(obtain_no);
		ModelAndView mav = new ModelAndView();
		mav.addObject("ob", ob);
		mav.setViewName("obtain/obtainSelect");
		return mav;
	}//end
	
//	조달계획 추가
	@GetMapping(value = "obtain/obtainInsertForm")
	public String obtainInsertForm() {
		return "obtain/obtainInsertForm";
	}//end
	
	@PostMapping(value = "obtainInsert")
	public String obtainInsert(ObtainVO ob) {
		obtservice.obtainInsert(ob);
		return "redirect:/obtainAll";
	}//end
	
//	조달계획 수정
	@GetMapping(value = "obtain/obtainUpdateForm")
	public ModelAndView obtainUpdateForm(int obtain_no) {
		ModelAndView mav = obtainSelect(obtain_no);
		mav.setViewName("obtain/obtainUpdateForm");
		return mav;
	}//end
	
	@PostMapping(value = "obtainUpdate")
	public String obtainUpdate(ObtainVO ob) {
		obtservice.obtainUpdate(ob);
		return "redirect:/obtainSelect?obtain_no="+ob.getObtain_no();
	}//end
	
//	조달계획 승인 
	@PostMapping(value="obainCheck")
	public String obainCheck(ObtainVO ob) {
		obtservice.obainCheck(ob);
		return "redirect:/obtainSelect?obtain_no="+ob.getObtain_no();
	}//end
	

	

	

	


}//end class
