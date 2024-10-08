package com.kr.kimchi.controller;

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
import com.kr.kimchi.service.PaPopService;
import com.kr.kimchi.service.PaService;
import com.kr.kimchi.service.PrpDetailPopService;
import com.kr.kimchi.service.PrpService;
import com.kr.kimchi.vo.PaVO;
import com.kr.kimchi.vo.PrpVO;


@Controller
public class PaDetailController {
	
	@Inject
	private PaPopService paPopService;
	
	@Inject
	private PrpService prpaService;
	
	@Inject
	private PaService paService;
	
	@Inject
	private PrpDetailPopService detailPopService;
	

	@PostMapping(value="pa/paDetail")
	public ModelAndView paDetail(@RequestParam("pa_no") Integer pa_no, HttpSession session) {
		String token = UUID.randomUUID().toString();
		session.setAttribute("token", token);
		
		ModelAndView mav = new ModelAndView();
		PaVO paVO = paPopService.paPopList(pa_no);
		List<PrpVO> prpList = prpaService.prpList(pa_no);
		mav.addObject("paVO", paVO);
		mav.addObject("prpList", prpList);
		mav.addObject("pa_no", pa_no);
		mav.addObject("token", token);
		mav.setViewName("pa/paDetail");
		return mav;
	}
	
	@GetMapping(value="/pa/prpUpdatePop")
	public ModelAndView prpUpdatePop(@RequestParam("prp_no") Integer prp_no) {
		ModelAndView mav = new ModelAndView();
		PrpVO prpVO = detailPopService.prpPopData(prp_no);
		mav.addObject("prpVO", prpVO);
		mav.setViewName("prp/prpDetailPop");
		return mav;
	}
	
	@ResponseBody
	@PostMapping(value="modal")
	public void paDetailmodal(@RequestParam("pa_no") Integer pa_no, 
			PrpVO prpVO,
			@RequestParam("partner") String partner,
			@RequestParam("email") String email,
			@RequestParam("token") String token,HttpSession session) {
		String sessionToken = (String) session.getAttribute("token");
		
		if (sessionToken != null && sessionToken.equals(token)) {
            session.removeAttribute("token"); 
            String date = prpVO.getPrp_issueDate();
            EmailSend.sendEmail(date,partner,email);
            paService.prpIng(pa_no);
            prpaService.prpInsert(prpVO);

            session.setAttribute("email", email);
        } else {
        }
	}

	@ResponseBody
	@PostMapping(value="/pa/prpUpdate")
	public void prpUpdate(@RequestParam("prp_no") int prp_no,
			@RequestParam("prp_revisionDate") String prp_revisionDate, 
			@RequestParam("prp_progress") int prp_progress, 
			@RequestParam("prp_notes") String prp_notes,
			@RequestParam("pa_no") int pa_no) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("prp_no", prp_no);
		map.put("prp_revisionDate", prp_revisionDate);
		map.put("prp_progress", prp_progress);
		map.put("prp_notes", prp_notes);
		detailPopService.prpUpdate(map);
	}
		
		

	
}
