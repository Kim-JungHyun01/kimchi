package com.kr.kimchi.controller;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	public ModelAndView obtainAll() {
		List<ObtainVO> oblist = obtservice.obtainAll();
		ModelAndView mav = new ModelAndView();
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
		List<PartnerVO> partnerlist = partservice.partnerAll(0,10);
		List<MaterialVO> malist = maservice.maList(0, 10);
		List<Bom_maVO> bom_malist = bom_maservice.bom_maSelect(con.getItem_no());
		List<UserVO> userlist = userservice.userAll();
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
		ModelAndView mav = obtainSelect(obtain_no);
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
