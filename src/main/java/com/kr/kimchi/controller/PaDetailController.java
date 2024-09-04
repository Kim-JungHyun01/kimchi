package com.kr.kimchi.controller;

import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kr.kimchi.service.PaPopService;
import com.kr.kimchi.service.PrpService;
import com.kr.kimchi.vo.PaVO;
import com.kr.kimchi.vo.PrpVO;


@Controller
public class PaDetailController {
	
	@Inject
	private PaPopService paPopService;
	
	@Inject
	private PrpService prpaService;
	

	@PostMapping(value="/paDetail")
	public ModelAndView paPop(@RequestParam("pa_no") Integer pa_no, HttpSession session) {
		// 토큰발행
		String token = UUID.randomUUID().toString();
		session.setAttribute("token", token);
		
		
		ModelAndView mav = new ModelAndView();
		PaVO paVO = paPopService.paPopList(pa_no);
		List<PrpVO> prpList = prpaService.prpList(pa_no);
		System.out.println("paDetailController paDetail paVO :" + paVO);
		mav.addObject("paVO", paVO);
		mav.addObject("prpList", prpList);
		mav.addObject("pa_no", pa_no);
		//토큰
		mav.addObject("token", token);
		mav.setViewName("pa/paDetail");
		return mav;
	}
	
	
	@PostMapping(value="/paDetailUpdate")
	public ModelAndView paDetailUpdate(@RequestParam("pa_no") Integer pa_no, PrpVO prpVO,
			@RequestParam("token") String token,HttpSession session) {
		// 토큰 검사
		String sessionToken = (String) session.getAttribute("token");
		
		if (sessionToken != null && sessionToken.equals(token)) {
			// 사용 후 토큰 제거
            session.removeAttribute("token"); 
            
            ModelAndView mav = new ModelAndView();
            System.out.println(prpVO);
            prpaService.prpInsert(prpVO);
            
            PaVO paVO = paPopService.paPopList(pa_no);
            List<PrpVO> prpList = prpaService.prpList(pa_no);
            System.out.println("paDetailController paDetail paVO :" + paVO);
            mav.addObject("paVO", paVO);
            mav.addObject("prpList", prpList);
            mav.setViewName("pa/paDetail");
            return mav;
            
        } else {
        	 ModelAndView mav = new ModelAndView();
             System.out.println(prpVO);
             
             PaVO paVO = paPopService.paPopList(pa_no);
             List<PrpVO> prpList = prpaService.prpList(pa_no);
             System.out.println("paDetailController paDetail paVO :" + paVO);
             mav.addObject("paVO", paVO);
             mav.addObject("prpList", prpList);
             mav.setViewName("pa/paDetail");
             return mav;
        }

		
		
	}
	
//	@ResponseBody
//	@PostMapping(value="/paDetail",  consumes = MediaType.APPLICATION_JSON_VALUE)
//	public List<PrpVO> paPrp(@RequestBody PrpVO prpVO) {
//		System.out.println("paDetail ajax 왔냐?");
//
//		
//		System.out.println("PaDetailController ajax : " +prpVO);
//		int pa_no = prpVO.getPa_no();
//		prpaService.prpInsert(prpVO);
//		List<PrpVO> prpList = prpaService.prpList(pa_no);
//		return prpList;
//	}
	
}
