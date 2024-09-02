package com.kr.kimchi.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kr.kimchi.service.CodeService;
import com.kr.kimchi.service.ContractsService;
import com.kr.kimchi.service.ItemService;
import com.kr.kimchi.service.PaService;
import com.kr.kimchi.vo.CodeVO;
import com.kr.kimchi.vo.ContractsVO;
import com.kr.kimchi.vo.ItemVO;
import com.kr.kimchi.vo.PaVO;

@Controller
public class ContractsController {

	@Inject
	private ContractsService conservice;
	@Inject
	private ItemService itemservice;
	@Inject
	private CodeService codeservice;
	@Inject
	private PaService paservice;

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
		return "redirect:/contracts/contractsAll";
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

//	계약 승인 & 취소 체크
	@PostMapping(value = "contracts/contractsCheck")
	public String contractsCheck(ContractsVO con) throws ParseException {
		conservice.contractsCheck(con); // 계약서 승인/취소 수정
		// 계약 승인 시 서류 발급
		if (con.getContracts_status().equals("계약승인")) {
			ContractsVO incon = conservice.contractsSelect(con.getContracts_no());
			CodeVO code = codeservice.contractsCode(incon);

			// 여기서 codeInsert 메서드의 반환 값을 사용하여 code_id를 가져옵니다.
			CodeVO insertedCode = codeservice.codeInsert(code);
			int code_id = insertedCode.getCode_id(); // 올바르게 설정된 code_id 사용

			// pa 추가
			PaVO pa = new PaVO();
			pa.setUser_id(incon.getUser_id());
			pa.setCode_id(code_id);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date pa_issueDate = formatter.parse(incon.getContracts_registrationDate());
			pa.setPa_issueDate(pa_issueDate);
			pa.setPa_referenceNo(incon.getContracts_no());
			paservice.paInsert(pa);
		} // end if

		return "redirect:/contracts/contractsSelect?contracts_no=" + con.getContracts_no();
	}//end

//	계약서 작성

// 계약서 보기
	@GetMapping(value = "documentView")
	public String documentView() {

		return null;
	}// end

}// end class
