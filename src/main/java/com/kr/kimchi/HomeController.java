package com.kr.kimchi;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kr.kimchi.service.CalenderService;
import com.kr.kimchi.vo.CalenderVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@Inject
	private CalenderService service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpSession session) {
		//로그인 여부 확인
		Object userLogin = session.getAttribute("userlogin");
	    Object partLogin = session.getAttribute("partlogin");
	    
	    if (userLogin == null && partLogin == null) {
	        return "redirect:/login/loginForm";
	    }
		
		List<CalenderVO> list = service.calenderList();
		System.out.println("list : " + list);
		model.addAttribute("list", list );
		
		return "calender/startPage";
	}
	
}
