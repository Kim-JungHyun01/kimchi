package com.kr.kimchi.controller;

import java.util.List;
import java.util.Properties;
import java.util.UUID;

import javax.inject.Inject;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kr.kimchi.EmailSend;
import com.kr.kimchi.service.PaPopService;
import com.kr.kimchi.service.PaService;
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
	

	@PostMapping(value="/paDetail")
	public ModelAndView paPop(@RequestParam("pa_no") Integer pa_no, HttpSession session) {
		String token = UUID.randomUUID().toString();
		session.setAttribute("token", token);
		
		
		ModelAndView mav = new ModelAndView();
		PaVO paVO = paPopService.paPopList(pa_no);
		List<PrpVO> prpList = prpaService.prpList(pa_no);
		System.out.println("paDetailController paDetail paVO :" + paVO);
		mav.addObject("paVO", paVO);
		mav.addObject("prpList", prpList);
		mav.addObject("pa_no", pa_no);
		mav.addObject("token", token);
		mav.setViewName("pa/paDetail");
		return mav;
	}
	
	
	@PostMapping(value="/paDetailUpdate")
	public ModelAndView paDetailUpdate(@RequestParam("pa_no") Integer pa_no, PrpVO prpVO,@RequestParam("parthner") String parthner,
			@RequestParam("email") String email,
			@RequestParam("token") String token,HttpSession session) {
		String sessionToken = (String) session.getAttribute("token");
		
		if (sessionToken != null && sessionToken.equals(token)) {
            session.removeAttribute("token"); 
            String date = prpVO.getPrp_issueDate();
            EmailSend.sendEmail(date,parthner,email);
            paService.prpIng(pa_no);
            
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
	

	
}
