package com.kr.kimchi.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kr.kimchi.service.ContractsService;
import com.kr.kimchi.service.ItemService;
import com.kr.kimchi.vo.ContractsVO;
import com.kr.kimchi.vo.ItemVO;

@Controller
public class ContractsController {

	@Inject
	private ContractsService conservice;
	@Inject
	private ItemService itemservice;

//	계약 보기_전체
	@GetMapping(value = "contracts/contractsAll")
	public ModelAndView contractsAll() {
		List<ContractsVO> conlist = conservice.contractsAll();
		ModelAndView mav = new ModelAndView();
		mav.addObject("conlist", conlist);
		mav.setViewName("contracts/contractsAll");
		return mav;
	}// end

//	계약 보기_상세
	@GetMapping(value = "contracts/contractsSelect")
	public ModelAndView contractsSelect(int contracts_no) {
		ContractsVO con = conservice.contractsSelect(contracts_no);
		ItemVO item = itemservice.itemSelect(con.getItem_no());
//		partner, user 정보불러오기
		ModelAndView mav = new ModelAndView();
		mav.addObject("con", con);
		mav.addObject("item", item);
		mav.setViewName("contracts/contractsSelect");
		return mav;
	}// end

//	계약 추가
	@GetMapping(value = "contracts/contractsInsertForm")
	public ModelAndView contractsInsertForm() {
		List<ItemVO> itemlist = itemservice.itemAll();
//		user=> 선택 or 로그인이 되어 있는 상태에서 들어가는 것?
//		parter 정보 보여주는 것
		ModelAndView mav = new ModelAndView();
		mav.addObject("itemlist", itemlist);
		mav.setViewName("contracts/contractsInsertForm");
		return mav;
	}// end

	@PostMapping(value = "contracts/contractsInsert")
	public String contractsInsert(ContractsVO con) {
		conservice.contractsInsert(con);
		return "redirect:/contractsAll";
	}// end

//	계약 수정_계약갯수, 계약가격, 납기일, 상새내역
	@GetMapping(value = "contracts/contractsUpdateForm")
	public ModelAndView contractsUpdateForm(int contracts_no) {
		ModelAndView mav = contractsSelect(contracts_no);
		mav.setViewName("contracts/contractsUpdateForm");
		return mav;
	}// end

	@PostMapping(value = "contracts/contractsUpdate")
	public String contractsUpdate(ContractsVO con) {
		conservice.contractsUpdate(con);
		return "redirect:/contracts/contractsSelect?contracts_no=" + con.getContracts_no();
	}// end

//	계약 승인 & 취소
	@PostMapping(value = "contracts/contractsCheck")
	public String contractsCheck(ContractsVO con) {
		conservice.contractsCheck(con);
		return "redirect:/contracts/contractsSelect?contracts_no=" + con.getContracts_no();
	}// end

}// end class
