package com.kr.kimchi.controller;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kr.kimchi.service.Bom_maService;
import com.kr.kimchi.vo.Bom_maVO;

public class Bom_maController {
		
	@Inject
	private Bom_maService bom_maservice;
	
//	bom_ma 추가
//	@GetMapping(value = "bom_maInsertForm")
//	public String bom_maInsertFrom() {
//		return "bom/bom_maInsertFrom";
//	}//end
	@PostMapping(value = "bom_maInsert")
	public String bom_maInsert(Bom_maVO bom_ma) {
		bom_maservice.bom_maInsert(bom_ma);
		return "redirect:/itemSelect?item_no="+bom_ma.getItem_no();
	}//end
	
//	bom_ma 수정
//	@GetMapping(value = "bom_maUpdateForm")
//	public String bom_maUpdateFrom() {
//		return "bom/bom_maUpdateFrom";
//	}//end
	
	@PostMapping(value = "bom_maUpdate")
	public String bom_maUpdate(Bom_maVO bom_ma) {
		bom_maservice.bom_maUpdate(bom_ma);
		return "redirect:/itemSelect?item_no="+bom_ma.getItem_no();
	}//end
	
//	bom_ma 삭제
	@GetMapping(value = "bom_maDelete")
	public String bom_maDeleteForm(Bom_maVO bom_ma) {
		bom_maservice.bom_maDeleteSelect(bom_ma.getMa_id(), bom_ma.getItem_no());
		return "bom_maDelete";
	}//end
	
	
}//end class
