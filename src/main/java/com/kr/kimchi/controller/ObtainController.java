package com.kr.kimchi.controller;

import java.util.Date;
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
public class ObtainController {

	@Inject
	private ObtainService obtservice;
	@Inject
	private UserService userservice;
	@Inject
	private PartnerService partservice;
	@Inject
	private ProductionService proservice;
	@Inject
	private MaterialService maservice;
	@Inject
	private CodeService codeservice;
	@Inject
	private PaService paservice;
	@Inject
	private ContractsService conservice;
	@Inject
	private Bom_maService bom_maservice;

//	조달계획 보기_전체
	@GetMapping(value = "obtain/obtainAll")
	public ModelAndView obtainAll(@RequestParam(defaultValue = "1") int pageNum) {
		int pageSize = 5; // 한 페이지에 보여줄 갯수 
	    int pageNavSize = 5; // 페이지 네비 크기
	    
	    int startRow = (pageNum - 1) * pageSize; //시작페이지 계산
		
		List<ObtainVO> oblist = obtservice.obtainAll(startRow,pageSize);
		Integer totalCount = obtservice.getTotalCount(); // 총 레코드 수 가져옴
		PaginationVO pagination = new PaginationVO(pageNum, totalCount, pageSize, pageNavSize);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("pagination", pagination);
	    mav.addObject("currentPage", pageNum);
		mav.addObject("oblist", oblist);
		mav.setViewName("obtain/obtainAll");
		return mav;
	}// end

//	조달계획 보기_상세
	@GetMapping(value = "obtain/obtainSelect")
	public ModelAndView obtainSelect(int obtain_no) {
		ObtainVO obtain = obtservice.obtainSelect(obtain_no);
		ProductionVO pro = proservice.productionSelect(obtain.getProduction_no());
		MaterialVO ma = maservice.maView(obtain.getMa_id());
		UserVO user = userservice.userSelect(obtain.getUser_id());
		PartnerVO partner = partservice.partnerSelect(obtain.getPartner_taxid());
		ModelAndView mav = new ModelAndView();
		mav.addObject("obtain", obtain);
		mav.addObject("pro", pro);
		mav.addObject("ma", ma);
		mav.addObject("user", user);
		mav.addObject("partner", partner);
		mav.setViewName("obtain/obtainSelect");
		return mav;
	}// end

//	조달계획 추가
	@GetMapping(value = "obtain/obtainInsertForm")
	public ModelAndView obtainInsertForm(int production_no) {
		ProductionVO pro = proservice.productionSelect(production_no);
		ContractsVO con = conservice.contractsSelect(pro.getContracts_no());
		List<PartnerVO> partnerlist = partservice.partnerAll(0,100, null);
		List<MaterialVO> malist = maservice.maList(0, 100);
		List<Bom_maVO> bom_malist = bom_maservice.bom_maSelect(con.getItem_no());
		List<UserVO> userlist = userservice.userAll(0,10, null);
		ModelAndView mav = new ModelAndView();
		mav.addObject("pro", pro);
		mav.addObject("partnerlist", partnerlist);
		mav.addObject("malist", malist);
		mav.addObject("userlist", userlist);
		mav.addObject("bom_malist", bom_malist);
		mav.setViewName("obtain/obtainInsertForm");
		return mav;
	}// end
	
	@PostMapping(value = "obtain/obtainInsert")
	public String obtainInsert(ObtainVO ob) {
		obtservice.obtainInsert(ob);
		return "redirect:/obtain/obtainAll";
	}// end

//	조달계획 수정
	@GetMapping(value = "obtain/obtainUpdateForm")
	public ModelAndView obtainUpdateForm(int obtain_no) {
		ObtainVO obtain = obtservice.obtainSelect(obtain_no);
		ProductionVO pro = proservice.productionSelect(obtain.getProduction_no());
		ContractsVO con = conservice.contractsSelect(pro.getContracts_no());
		MaterialVO ma = maservice.maView(obtain.getMa_id());
		Bom_maVO bom_ma = bom_maservice.bom_maMaterial(con.getItem_no(),ma.getMa_id());
		UserVO user = userservice.userSelect(obtain.getUser_id());
		PartnerVO partner = partservice.partnerSelect(obtain.getPartner_taxid());
		ModelAndView mav = new ModelAndView();
		mav.addObject("obtain", obtain);
		mav.addObject("pro", pro);
		mav.addObject("ma", ma);
		mav.addObject("bom_ma", bom_ma);
		mav.addObject("user", user);
		mav.addObject("partner", partner);
		mav.setViewName("obtain/obtainUpdateForm");
		return mav;
	}// end

	@PostMapping(value = "obtain/obtainUpdate")
	public String obtainUpdate(ObtainVO ob) {
		obtservice.obtainUpdate(ob);
		return "redirect:/obtain/obtainSelect?obtain_no=" + ob.getObtain_no();
	}// end

//	조달계획 승인 
	@PostMapping(value = "obtain/obtainCheck")
	public String obtainCheck(ObtainVO ob) {
		obtservice.obtainCheck(ob);
		// 계약 승인 시 서류 발급
		if (ob.getObtain_status().equals("조달계획확인완료")) {
			ObtainVO inobtain = obtservice.obtainSelect(ob.getObtain_no());
			CodeVO code = codeservice.obtainCode(inobtain);

			// 여기서 codeInsert 메서드의 반환 값을 사용하여 code_id를 가져옵니다.
			CodeVO insertedCode = codeservice.codeInsert(code);
			int code_id = insertedCode.getCode_id(); // 올바르게 설정된 code_id 사용

			// pa 추가
			PaVO pa = new PaVO();
			pa.setUser_id(inobtain.getUser_id());
			pa.setCode_id(code_id);
			Date pa_issueDate = inobtain.getObtain_registrationDate();
			pa.setPa_issueDate(pa_issueDate);
			pa.setPa_referenceNo(inobtain.getObtain_no());
			paservice.paInsert(pa);
		} // end if

		return "redirect:/obtain/obtainSelect?obtain_no=" + ob.getObtain_no();
	}// end

}// end class
