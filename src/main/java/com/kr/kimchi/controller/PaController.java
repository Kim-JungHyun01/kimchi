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
import org.springframework.web.servlet.ModelAndView;

import com.kr.kimchi.EmailSend;
import com.kr.kimchi.service.ObtainService;
import com.kr.kimchi.service.PaService;
import com.kr.kimchi.service.PrpService;
import com.kr.kimchi.vo.ObtainVO;
import com.kr.kimchi.vo.PaPageLIst;
import com.kr.kimchi.vo.PaPageVO;
import com.kr.kimchi.vo.PaVO;
import com.kr.kimchi.vo.PrpVO;

@Controller
public class PaController {

	@Inject
	private PaService paService;

	@Inject
	private PrpService prpaService;
	
	@Inject
	private ObtainService obtservice;
	

	@GetMapping(value = "/pa")
	public ModelAndView pa(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "99") int pa_checkStatus, HttpSession session) {
		// 토큰발행
		String token = UUID.randomUUID().toString();
		session.setAttribute("token", token);

		// 갯수를 구하기 위한 전체 리스트
		List<PaVO> allList = paService.paAllList(pa_checkStatus);
		
		// 페이지 쪽수 처리
		PaPageVO pageVO = new PaPageVO(pageNum, allList.size());
		System.out.println("PaController page : " + pageVO.getPageNum());

		System.out.println("pageNum :" + pageNum);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("start", (pageVO.getPageNum() - 1) * pageVO.getListcnt());
		System.out.println("PaController start : " + pageVO.getStart());
		params.put("end", pageVO.getListcnt());
		System.out.println("PaController listcnt : " + pageVO.getListcnt());
		System.out.println("PaController startPage : " + pageVO.getStartPage());
		System.out.println("PaController endPage : " + pageVO.getEndPage());
		System.out.println("PaController total : " + pageVO.getTotal());
		System.out.println("PaController listcnt : " + pageVO.getListcnt());

		// 리스트를 분할로 받음
		params.put("pa_checkStatus",pa_checkStatus);
		params.put("ca_id", 3); // 구매발주서라 3으로 고정
		List<PaVO> pageAllList = paService.paList(params);
		System.out.println("PaController pageAllList : " + pageAllList);

		PaPageLIst paPageList = new PaPageLIst(pageAllList, pageVO);
		ModelAndView mav = new ModelAndView();
		mav.addObject("paPageList", paPageList);
		mav.addObject("pa_checkStatus", pa_checkStatus);

		// 토큰
		mav.addObject("token", token);
		mav.setViewName("pa/pa");
		return mav;
	}

	@PostMapping(value = "/pa")
	public ModelAndView prpSave(PrpVO prpVO, @RequestParam(defaultValue = "1") int pageNum,
			@RequestParam(defaultValue = "99") int pa_checkStatus,
			@RequestParam("pa_no") int pa_no,
			@RequestParam("partner") String parthner,
			@RequestParam("email") String email,
			@RequestParam("token") String token, HttpSession session) {
		
		// 토큰 검사
		String sessionToken = (String) session.getAttribute("token");

		if (sessionToken != null && sessionToken.equals(token)) {
			// 사용 후 토큰 제거
			session.removeAttribute("token");
			System.out.println("tsetdd"+pa_checkStatus);

			paService.prpIng(pa_no);
            // email 발송
			String date = prpVO.getPrp_issueDate();
			System.out.println("email :"+email);
            EmailSend.sendEmail(date,parthner,email);
            
			System.out.println("prpController prpVo :" + prpVO);
			prpaService.prpInsert(prpVO);
			// 갯수를 구하기 위한 전체 리스트
			List<PaVO> allList = paService.paAllList(pa_checkStatus);

			// 페이지 쪽수 처리
			PaPageVO pageVO = new PaPageVO(pageNum, allList.size());
			System.out.println("PaController page : " + pageVO.getPageNum());

			System.out.println("pageNum :" + pageNum);
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("start", (pageVO.getPageNum() - 1) * pageVO.getListcnt());
			System.out.println("PaController start : " + pageVO.getStart());
			params.put("end", pageVO.getListcnt());
			System.out.println("PaController listcnt : " + pageVO.getListcnt());
			System.out.println("PaController startPage : " + pageVO.getStartPage());
			System.out.println("PaController endPage : " + pageVO.getEndPage());
			System.out.println("PaController total : " + pageVO.getTotal());
			System.out.println("PaController listcnt : " + pageVO.getListcnt());

			// 리스트를 분할로 받음
			params.put("pa_checkStatus",pa_checkStatus);
			params.putIfAbsent("ca_id", 3); // 구매발주서라 3으로 고정
			List<PaVO> pageAllList = paService.paList(params);
			System.out.println("PaController pageAllList : " + pageAllList);

			PaPageLIst paPageList = new PaPageLIst(pageAllList, pageVO);
			ModelAndView mav = new ModelAndView();
			mav.addObject("pa_checkStatus", pa_checkStatus);
			mav.addObject("paPageList", paPageList);
			mav.setViewName("pa/pa");
			return mav;
		} else {
			// 갯수를 구하기 위한 전체 리스트
			List<PaVO> allList = paService.paAllList(pa_checkStatus);
			// 페이지 쪽수 처리
			PaPageVO pageVO = new PaPageVO(pageNum, allList.size());
			System.out.println("PaController page : " + pageVO.getPageNum());

			System.out.println("pageNum :" + pageNum);
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("start", (pageVO.getPageNum() - 1) * pageVO.getListcnt());
			System.out.println("PaController start : " + pageVO.getStart());
			params.put("end", pageVO.getListcnt());
			System.out.println("PaController listcnt : " + pageVO.getListcnt());
			System.out.println("PaController startPage : " + pageVO.getStartPage());
			System.out.println("PaController endPage : " + pageVO.getEndPage());
			System.out.println("PaController total : " + pageVO.getTotal());
			System.out.println("PaController listcnt : " + pageVO.getListcnt());

			params.put("pa_checkStatus",pa_checkStatus);
			// 리스트를 분할로 받음
			params.putIfAbsent("ca_id", 3); // 구매발주서라 3으로 고정
			List<PaVO> pageAllList = paService.paList(params);
			System.out.println("PaController pageAllList : " + pageAllList);

			PaPageLIst paPageList = new PaPageLIst(pageAllList, pageVO);
			ModelAndView mav = new ModelAndView();
			mav.addObject("pa_checkStatus", pa_checkStatus);
			mav.addObject("paPageList", paPageList);
			mav.setViewName("pa/pa");
			return mav;
		}

	}
	
	@PostMapping(value = "/prpFinsh")
	public ModelAndView prpFinsh(@RequestParam(defaultValue = "1") int pageNum, 
			@RequestParam(defaultValue = "99") int pa_checkStatus,
			@RequestParam("pa_no") int pa_no, HttpSession session) {
		
		// 토큰발행
		String token = UUID.randomUUID().toString();
		session.setAttribute("token", token);
		
		paService.prpFinsh(pa_no);

		// 갯수를 구하기 위한 전체 리스트
		List<PaVO> allList = paService.paAllList(pa_checkStatus);

		// 페이지 쪽수 처리
		PaPageVO pageVO = new PaPageVO(pageNum, allList.size());
		System.out.println("PaController page : " + pageVO.getPageNum());

		System.out.println("pageNum :" + pageNum);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("start", (pageVO.getPageNum() - 1) * pageVO.getListcnt());
		System.out.println("PaController start : " + pageVO.getStart());
		params.put("end", pageVO.getListcnt());
		System.out.println("PaController listcnt : " + pageVO.getListcnt());
		System.out.println("PaController startPage : " + pageVO.getStartPage());
		System.out.println("PaController endPage : " + pageVO.getEndPage());
		System.out.println("PaController total : " + pageVO.getTotal());
		System.out.println("PaController listcnt : " + pageVO.getListcnt());

		// 리스트를 분할로 받음
		params.put("pa_checkStatus",pa_checkStatus);
		params.putIfAbsent("ca_id", 3); // 구매발주서라 3으로 고정
		List<PaVO> pageAllList = paService.paList(params);
		System.out.println("PaController pageAllList : " + pageAllList);

		PaPageLIst paPageList = new PaPageLIst(pageAllList, pageVO);
		ModelAndView mav = new ModelAndView();
		mav.addObject("paPageList", paPageList);
		mav.addObject("pa_checkStatus", pa_checkStatus);
		// 토큰
		mav.addObject("token", token);
		mav.setViewName("pa/pa");
		return mav;
	}
	
	@GetMapping(value = "paInsert")
	public ModelAndView obtainAll() {
		ModelAndView mav = new ModelAndView();
		List<ObtainVO> oblist = obtservice.obSelectList();
		mav.addObject("oblist", oblist);
		mav.setViewName("pa/paInsert");
		return mav;
	}// end
	
	@PostMapping(value="paUpdate")
	public ModelAndView prpUpdate(@RequestParam("pa_referenceNo") int pa_referenceNo,
			@RequestParam("user_id") String user_id,@RequestParam("pa_issueDate") String pa_issueDate,@RequestParam("code") String code,
			@RequestParam("obtain_no") int obtain_no) throws ParseException {
		// 구매발주서 발급
		obtservice.obtainPa(obtain_no);
		
		ModelAndView mav = new ModelAndView();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pa_referenceNo", pa_referenceNo);
		map.put("user_id", user_id);
		map.put("code", code);
//		map.put("pa_issueDate", pa_issueDate);
		System.out.println(pa_issueDate);
		

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = sdf.parse(pa_issueDate);
		map.put("pa_issueDate", date);
		
		paService.paCode(code);
		int code_id = paService.paCodeSelecet(code);
		map.put("code_id", code_id);
		
		paService.paPlus(map);

		obtservice.obtainPa(obtain_no);

		List<ObtainVO> oblist = obtservice.obtainAll(0,100);
		mav.addObject("oblist", oblist);
		mav.setViewName("pa/paInsert");
		return mav;
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
