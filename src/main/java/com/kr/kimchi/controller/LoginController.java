package com.kr.kimchi.controller;

import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kr.kimchi.service.PartnerService;
import com.kr.kimchi.service.UserService;


@Controller
public class LoginController {

	@Inject
	private UserService userserivce;
	@Inject
	private PartnerService partservice;

//	로그인화면 이동
	@GetMapping(value = "login/loginForm")
	public String loginForm() {
		return "login/loginForm";
	}//end

//	사용자 로그인
	@PostMapping(value = "login/userLogin")
	public String userLogin(@RequestParam Map<String, Object> usermap, HttpSession session) {
	    Map<String, Object> userlogin = userserivce.userLogin(usermap);
	    if (userlogin == null) {// 로그인 실패
			return "redirect:/login/loginForm";
		} else {// 로그인 성공
			session.setAttribute("userlogin", userlogin);
			return "redirect:/";
		} // end
	}

//	협력회사 로그인
	@PostMapping(value = "login/partnerLogin")
	public String partnerLogin(@RequestParam Map<String, Object> partmap, HttpSession session) {
		Map<String, Object> partlogin = partservice.partnerLogin(partmap);
		if (partlogin == null) {// 로그인 실패
			return "redirect:/login/loginForm";
		} else {// 로그인 성공
			session.setAttribute("partlogin", partlogin);
			return "redirect:/";
		} // end
	}// end

// 사용자 & 협력회사 로그아웃
	@GetMapping(value = "login/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login/loginForm";
	}// end

}// end class
