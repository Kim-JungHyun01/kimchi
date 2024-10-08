package com.kr.kimchi.controller;

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

import com.kr.kimchi.service.PcspService;
import com.kr.kimchi.vo.PcspVO;

@Controller
public class PcspController {

	@Inject
	private PcspService pcspService;
	

	@GetMapping(value = "/pcsp")
	public ModelAndView pcsp(HttpSession session) {
		ModelAndView mav = new ModelAndView();

		String token = UUID.randomUUID().toString();
		session.setAttribute("token", token);
		
		System.out.println(session.getAttribute("partlogin"));
	
		Map<String, Object> value = (Map<String, Object>) session.getAttribute("partlogin");
		String id = (String) value.get("partner_taxid");
		
		List<PcspVO> list = pcspService.pcspList(id);
		mav.addObject("list", list);
		System.out.println(list);
		mav.addObject("partner_taxid", id);
		mav.addObject("token", token);
		mav.setViewName("pcsp/pcsp");
		return mav;
	}
	
	@PostMapping(value = "/pcsp")
	public ModelAndView pcspInsert(HttpSession session,PcspVO pcspVO,String token) {
		String sessionToken = (String) session.getAttribute("token");
		
			if (sessionToken != null && sessionToken.equals(token)) {
	            session.removeAttribute("token"); 
			
			pcspService.pcspInsert(pcspVO);
			
			ModelAndView mav = new ModelAndView();

			System.out.println(session.getAttribute("partlogin"));
		
			Map<String, Object> value = (Map<String, Object>) session.getAttribute("partlogin");
			String id = (String) value.get("partner_taxid");
			
			List<PcspVO> list = pcspService.pcspList(id);
			mav.addObject("list", list);
			System.out.println(list);
			mav.addObject("partner_taxid", id);
			mav.addObject("token", token);
			mav.setViewName("pcsp/pcsp");
			return mav;
		}else {
			ModelAndView mav = new ModelAndView();

			System.out.println(session.getAttribute("partlogin"));
		
			Map<String, Object> value = (Map<String, Object>) session.getAttribute("partlogin");
			String id = (String) value.get("partner_taxid");
			
			List<PcspVO> list = pcspService.pcspList(id);
			mav.addObject("list", list);
			System.out.println(list);
			mav.addObject("partner_taxid", id);
			mav.addObject("token", token);
			mav.setViewName("pcsp/pcsp");
			return mav;
		}
	}

	

}
