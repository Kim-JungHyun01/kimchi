package com.kr.kimchi.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kr.kimchi.service.BomService;
import com.kr.kimchi.service.Bom_maService;
import com.kr.kimchi.vo.BomVO;

@Controller
public class BomController {
	
	@Inject
	private BomService bomservice;
	@Inject
	private Bom_maService bom_maservice;
	
//	bom정보_스케줄 추가
	@GetMapping(value ="bom/bomInsertForm")
	public String bomInsertForm(int item_no) {
		return "bomInsertForm";
	}//end
	
	@PostMapping(value = "bomInsert")
	public String bomInsert(BomVO bom){
		bomservice.bomInsert(bom);
		return "redirect:/itemSelect?items_no="+bom.getItem_no();
	}//end
	
//	bom정보_스케줄 수정
	@GetMapping(value = "bom/bomUpdateForm")
	public ModelAndView bomUpdateForm(int item_no) {
		BomVO bom = bomservice.bomSelect(item_no);
		ModelAndView mav = new ModelAndView();
		mav.addObject("bom", bom);
		mav.setViewName("bom/bomUpdateForm");
		return mav;
	}//end
	
	@PostMapping(value = "bomUpdate")
	public String bomUpdate(BomVO bom) {
		bomservice.bomUpdate(bom);
		return "redirect:/itemSelect?items_no="+bom.getItem_no();
	}//end
	
//	bom정보_스케줄 삭제
	@GetMapping(value = "bomDelete")
	public String bomDelete(int item_no) {
		bom_maservice.bom_maDeleteAll(item_no);
		bomservice.bomDelete(item_no);
		return "redirect:/itemSelect?items_no="+item_no;
	}//end

}// end class
