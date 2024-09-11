package com.kr.kimchi.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kr.kimchi.service.*;
import com.kr.kimchi.vo.*;

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
	@Inject
	private Bom_maService bom_maservice;
	
//	생산계획 보기_전체
	@GetMapping(value = "production/productionAll")
	public ModelAndView productionAll(@RequestParam(defaultValue = "1") int pageNum) {
		int pageSize = 5; // 한 페이지에 보여줄 갯수 
	    int pageNavSize = 5; // 페이지 네비 크기
	    
	    int startRow = (pageNum - 1) * pageSize; //시작페이지 계산
		
		List<ProductionVO> prolist = proservice.productionAll(startRow, pageSize);
		List<UserVO> userlist = userservice.userAll(0, 100, null);
		List<ContractsVO> conlist = conservice.contractsAll(0, 100);
		List<ItemVO> itemlist = itemservice.itemAll(0, 100, null);
		
		Integer totalCount = proservice.getTotalCount(); // 총 레코드 수 가져옴
		 Integer totalPages = itemservice.itemSearch(pageSize, null); // 검색지만 전체페이지를 위해 적음
		PaginationVO pagination = new PaginationVO(pageNum, totalCount, pageSize, pageNavSize);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("pagination", pagination);
	    mav.addObject("currentPage", pageNum);
	    mav.addObject("totalPages", totalPages);
	    
		mav.addObject("prolist",prolist);
		mav.addObject("conlist", conlist);
		mav.addObject("userlist", userlist);
		mav.addObject("itemlist", itemlist);
		mav.setViewName("production/productionAll");
		return mav;
	}//end
	
//	생산계획 보기_상세
	@GetMapping(value = "production/productionSelect")
	public ModelAndView productionSelect(int production_no) {
		ProductionVO pro = proservice.productionSelect(production_no);
		ContractsVO con = conservice.contractsSelect(pro.getContracts_no());
		ItemVO item = itemservice.itemSelect(con.getItem_no());
		List<Bom_maVO> bom_malist = bom_maservice.bom_maSelect(item.getItem_no());
		UserVO user = userservice.userSelect(pro.getUser_id());
		ModelAndView mav = new ModelAndView();
		mav.addObject("pro",pro);
		mav.addObject("con", con);
		mav.addObject("item", item);
		mav.addObject("user", user);
		mav.addObject("bom_malist", bom_malist);
		mav.setViewName("production/productionSelect");
		return mav;
	}//end
	
//	생산계획 추가
	@GetMapping(value = "production/productionInsertForm")
	public ModelAndView productionInsertForm() {
		List<ContractsVO> conlist = conservice.contractsAll(0,10);
		List<UserVO> userlist = userservice.userAll(0,10, null);
		List<ItemVO> itemlist = itemservice.itemAll(0,10, null);
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
