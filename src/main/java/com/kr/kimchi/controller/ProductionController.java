package com.kr.kimchi.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kr.kimchi.service.ProductionService;
import com.kr.kimchi.vo.ProductionVO;

@Controller
public class ProductionController {

	@Inject
	private ProductionService proservice;
	
//	생산계획 보기_전체
	@GetMapping(value = "production/productionAll")
	public ModelAndView productionAll() {
		List<ProductionVO> prolist = proservice.productionAll();
		ModelAndView mav = new ModelAndView();
		mav.addObject("prolist",prolist);
		mav.setViewName("production/productionAll");
		return mav;
	}//end
	
//	생산계획 보기_상세
	@GetMapping(value = "production/productionSelect")
	public ModelAndView productionSelect(int production_no) {
		ProductionVO pro = proservice.productionSelect(production_no);
		ModelAndView mav = new ModelAndView();
		mav.addObject("pro",pro);
		mav.setViewName("production/productionSelect");
		return mav;
	}//end
	
//	생산계획 추가
	@GetMapping(value = "production/productionInsertForm")
	public String productionInsertForm() {
		return "production/productionInsertForm";
	}//end
	
	@PostMapping(value = "productionInsert")
	public String productionInsert(ProductionVO pro) {
		proservice.productionInsert(pro);
		return "redirect:/productionAll";
	}//end
	
//	생산계획 수정_생산량, 생산납기
	@GetMapping(value = "production/productionUpdateForm")
	public ModelAndView productionUpdateForm(int production_no) {
		ModelAndView mav = productionSelect(production_no);
		mav.setViewName("production/productionUpdateForm");
		return mav;
	}//end
	
	@PostMapping(value = "productionUpdate")
	public String productionUpdate(ProductionVO pro) {
		proservice.productionUpdate(pro);
		return "redirect:/productionSelect?production_no="+pro.getProduction_no();
	}//end
	
//	생산계획 승인여부
	@PostMapping(value = "productionCheck")
	public String productionCheck(ProductionVO pro) {
		proservice.productionCheck(pro);
		return "redirect:/productionSelect?production_no="+pro.getProduction_no();
	}//end
	
}//end class
