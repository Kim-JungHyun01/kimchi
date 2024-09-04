package com.kr.kimchi.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kr.kimchi.service.ContractsService;
import com.kr.kimchi.service.ItemService;
import com.kr.kimchi.service.ProductionService;
import com.kr.kimchi.service.UserService;
import com.kr.kimchi.vo.ContractsVO;
import com.kr.kimchi.vo.ItemVO;
import com.kr.kimchi.vo.ProductionVO;
import com.kr.kimchi.vo.UserVO;

@Controller
public class ProductionController {
	@Inject
	private ProductionService proservice;
	@Inject
	private ContractsService conservice;
	@Inject
	private ItemService itemservice;
	@Inject
	private UserService userservice;
	
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
		ContractsVO con = conservice.contractsSelect(pro.getContracts_no());
		ItemVO item = itemservice.itemSelect(con.getItem_no());
		UserVO user = userservice.userSelect(pro.getUser_id());
		ModelAndView mav = new ModelAndView();
		mav.addObject("pro",pro);
		mav.addObject("con", con);
		mav.addObject("item", item);
		mav.addObject("user", user);
		mav.setViewName("production/productionSelect");
		return mav;
	}//end
	
//	생산계획 추가
	@GetMapping(value = "production/productionInsertForm")
	public ModelAndView productionInsertForm() {
		List<ContractsVO> conlist = conservice.contractsAll();
		List<UserVO> userlist = userservice.userAll();
		List<ItemVO> itemlist = itemservice.itemAll();
		ModelAndView mav = new ModelAndView();
		mav.addObject("conlist", conlist);
		mav.addObject("userlist", userlist);
		mav.addObject("itemlist", itemlist);
		mav.setViewName("production/productionInsertForm");
		return mav;
	}//end
	
	@PostMapping(value = "production/productionInsert")
	public String productionInsert(ProductionVO pro) {
		proservice.productionInsert(pro);
		return "redirect:/production/productionAll";
	}//end
	
//	생산계획 수정_생산량, 생산납기
	@GetMapping(value = "production/productionUpdateForm")
	public ModelAndView productionUpdateForm(int production_no) {
		ModelAndView mav = productionSelect(production_no);
		mav.setViewName("production/productionUpdateForm");
		return mav;
	}//end
	
	@PostMapping(value = "production/productionUpdate")
	public String productionUpdate(ProductionVO pro) {
		proservice.productionUpdate(pro);
		return "redirect:/production/productionSelect?production_no="+pro.getProduction_no();
	}//end
	
//	생산계획 승인여부
	@PostMapping(value = "production/productionCheck")
	public String productionCheck(ProductionVO pro) {
		proservice.productionCheck(pro);
		return "redirect:/production/productionSelect?production_no="+pro.getProduction_no();
	}//end
	
}//end class
