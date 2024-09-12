package com.kr.kimchi.controller;

import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kr.kimchi.service.PcspService;
import com.kr.kimchi.vo.PcspVO;

@Controller
public class PcspController {

	@Inject
	private PcspService pcspService;
	

	@GetMapping(value = "/pcsp")
	public ModelAndView pcsp(HttpSession session) {
		ModelAndView mav = new ModelAndView();

		// 토큰발행
		String token = UUID.randomUUID().toString();
		session.setAttribute("token", token);
		
		//로그인 세션값
//		String value = (String) session.getAttribute("key");
//		List<PcspVO> list = pcspService.pcspList(value);
//		mav.addObject("list", list);

		String value = "111-22-33333";
		List<PcspVO> list = pcspService.pcspList(value);
		mav.addObject("list", list);
		
		// 토큰
		mav.addObject("partner_taxid", value);
		mav.addObject("token", token);
		mav.setViewName("pcsp/pcsp");
		return mav;
	}
	
	@PostMapping(value = "/pcsp")
	public ModelAndView pcspInsert(HttpSession session,PcspVO pcspVO,String token) {
		String sessionToken = (String) session.getAttribute("token");
		
			if (sessionToken != null && sessionToken.equals(token)) {
	            session.removeAttribute("token"); 
			ModelAndView mav = new ModelAndView();
			System.out.println("!!!"+pcspVO);
			pcspService.pcspInsert(pcspVO);
			
			//로그인 세션값
	//		String value = (String) session.getAttribute("key");
	//		List<PcspVO> list = pcspService.pcspList(value);
	//		mav.addObject("list", list);
	
			String value = "111-22-33333";
			List<PcspVO> list = pcspService.pcspList(value);
			mav.addObject("list", list);
			
			// 토큰
			mav.addObject("partner_taxid", value);
			mav.setViewName("pcsp/pcsp");
			return mav;
		}else {
			ModelAndView mav = new ModelAndView();
			//로그인 세션값
	//		String value = (String) session.getAttribute("key");
	//		List<PcspVO> list = pcspService.pcspList(value);
	//		mav.addObject("list", list);
	
			String value = "111-22-33333";
			List<PcspVO> list = pcspService.pcspList(value);
			mav.addObject("list", list);
			
			// 토큰
			mav.addObject("partner_taxid", value);
			mav.setViewName("pcsp/pcsp");
			return mav;
		}
	}

	

}
