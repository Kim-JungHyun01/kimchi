package com.kr.kimchi.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kr.kimchi.EmailSend;
import com.kr.kimchi.service.CodeService;
import com.kr.kimchi.service.MaterialService;
import com.kr.kimchi.service.ObtainService;
import com.kr.kimchi.service.PaPopService;
import com.kr.kimchi.service.PaService;
import com.kr.kimchi.service.PartnerService;
import com.kr.kimchi.service.ProductionService;
import com.kr.kimchi.service.PrpService;
import com.kr.kimchi.service.UserService;
import com.kr.kimchi.vo.MaterialVO;
import com.kr.kimchi.vo.ObtainVO;
import com.kr.kimchi.vo.PaPageLIst;
import com.kr.kimchi.vo.PaPageVO;
import com.kr.kimchi.vo.PaVO;
import com.kr.kimchi.vo.PartnerVO;
import com.kr.kimchi.vo.ProductionVO;
import com.kr.kimchi.vo.PrpVO;
import com.kr.kimchi.vo.UserVO;

@Controller
public class PaController {

	@Inject
	private PaService paService;

	@Inject
	private PrpService prpService;
	
	@Inject
	private ObtainService obtservice;
	
	@Inject
	private PaPopService paPopService;
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
	
	
	// 조달계획 -> 구매발주 리스트 페이지
	@GetMapping(value = "pa/paInsert")
	public ModelAndView paInsert() {
		ModelAndView mav = new ModelAndView();
		List<ObtainVO> oblist = obtservice.obSelectList();
		mav.addObject("oblist", oblist);
		mav.setViewName("pa/paInsert");
		return mav;
	}// end
	
	@GetMapping(value="/obPaPop")
	public ModelAndView obPaPop(@RequestParam("obtain_no") int obtain_no) {
		
		// 조달계획
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
		mav.setViewName("pa/obPaPop");
		return mav;
	}
	
	@ResponseBody
	@PostMapping(value="pa/paInsert")
	public void paInsert(@RequestParam("pa_referenceNo") int pa_referenceNo,
			@RequestParam("user_id") String user_id,
			@RequestParam("pa_issueDate") String pa_issueDate,
			@RequestParam("code") String code,
			@RequestParam("obtain_no") int obtain_no,
			@RequestParam("notes") String notes) throws ParseException {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pa_referenceNo", pa_referenceNo);
		map.put("user_id", user_id);
		map.put("notes", notes);
		
		// 날짜 정리
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = sdf.parse(pa_issueDate);
		map.put("pa_issueDate", date);
		
		// 구매발주서 코드 먼저 발행
		paService.paCode(code);
		
		// 발주코드로 발주 번호 검색
		int code_id = paService.paCodeSelecet(code);
		map.put("code_id", code_id);
		
		// 구매발주서(pa) 추가
		paService.paPlus(map);

		// 조달계획서 구매발주서 발급값으로 변경
		obtservice.obtainPa(obtain_no);
	}
			

	@PostMapping(value = "/pa/pa")
	public ModelAndView pa(@RequestParam(defaultValue = "1") int pageNum, 
			@RequestParam(defaultValue = "99") int pa_checkStatus,
			@RequestParam(defaultValue = "99") int prpFinsh,
			@RequestParam(defaultValue = "99") int pa_no,
			HttpSession session) {		
		
		if(prpFinsh == 1) {
			paService.prpFinsh(pa_no);
			System.out.println("prp완료처리");
		}
		
		// 토큰발행
		String token = UUID.randomUUID().toString();
		session.setAttribute("token", token);

		// 갯수를 구하기 위한 전체 리스트
		List<PaVO> allList = paService.paAllList(pa_checkStatus);
		
		// 페이지 쪽수 처리
		PaPageVO pageVO = new PaPageVO(pageNum, allList.size());

		System.out.println("pageNum :" + pageNum);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("start", (pageVO.getPageNum() - 1) * pageVO.getListcnt());
		params.put("end", pageVO.getListcnt());

		// 리스트를 분할로 받음
		params.put("pa_checkStatus",pa_checkStatus);
		params.put("ca_id", 3); // 구매발주서라 3으로 고정
		List<PaVO> pageAllList = paService.paList(params);

		PaPageLIst paPageList = new PaPageLIst(pageAllList, pageVO);
		ModelAndView mav = new ModelAndView();
		mav.addObject("paPageList", paPageList);
		mav.addObject("pa_checkStatus", pa_checkStatus);

		// 토큰
		mav.addObject("token", token);
		mav.setViewName("pa/pa");
		return mav;
	}
	
	@PostMapping(value="/pa/printPop")
	public ModelAndView printPop(@RequestParam("pa_no") Integer pa_no) {
		ModelAndView mav = new ModelAndView();
		PaVO paVO = paPopService.paPopList(pa_no);
		mav.addObject("paVO", paVO);
		mav.setViewName("pa/printPop");
		return mav;
	}

	@ResponseBody
	@PostMapping(value = "/pa/modal")
	public void paModal(PrpVO prpVO, 
			@RequestParam(defaultValue = "1") int pageNum,
			@RequestParam(defaultValue = "99") int pa_checkStatus,
			@RequestParam("pa_no") int pa_no,
			@RequestParam("partner") String parthner,
			@RequestParam("email") String email,
			@RequestParam("token") String token, 
			HttpSession session) {
		
		// 토큰 검사
		String sessionToken = (String) session.getAttribute("token");

		if (sessionToken != null && sessionToken.equals(token)) {
			// 사용 후 토큰 제거
			session.removeAttribute("token");
			
			// prp 진행중 값으로 변경 
			paService.prpIng(pa_no);
			
            // email 발송
			String date = prpVO.getPrp_issueDate();
            EmailSend.sendEmail(date,parthner,email);
            
			prpService.prpInsert(prpVO);
			session.setAttribute("email", "email");
		} else {
		}
	}
	
	@GetMapping(value = "contracts/paSelect")
	public ModelAndView paSelect(@RequestParam("ca_id") int ca_id, @RequestParam("pa_referenceNo") int pa_referenceNo) {

		Map<String, Object> params = new HashMap<>();
		params.put("ca_id", ca_id);
		params.put("pa_referenceNo", pa_referenceNo);
		PaVO palist = paService.paSelect(params);

		paService.paCheck(palist.getPa_no());

		ModelAndView mav = new ModelAndView();
		mav.addObject("palist", palist);
		mav.setViewName("contracts/paSelect");
		return mav;
	}// end

}
