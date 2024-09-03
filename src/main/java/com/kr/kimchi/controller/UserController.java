package com.kr.kimchi.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kr.kimchi.service.UserService;
import com.kr.kimchi.vo.UserVO;

@Controller
public class UserController {

	@Inject
	private UserService userserivce;

//	사용자 전체
	@GetMapping(value = "user/userAll")
	public ModelAndView userAll() {
		List<UserVO> userlist = userserivce.userAll();
		ModelAndView mav = new ModelAndView();
		mav.addObject("userlist", userlist);
		mav.setViewName("user/userAll");
		return mav;
	}// end

//	사용자 상세
	@GetMapping(value = "user/userSelect")
	public ModelAndView userSelect(String user_id) {
		UserVO user = userserivce.userSelect(user_id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("user", user);
		mav.setViewName("user/userSelect");
		return mav;
	}// end

//	사용자 회원가입
	@GetMapping(value = "user/userInsertForm")
	public String userInsertForm() {
		return "user/userInsertForm";
	}// end

	@PostMapping(value = "user/userInsert")
	public String userInsert(UserVO user) {
		userserivce.userInsert(user);
		return "redirect:/";
	}// end

//	사용자 정보 수정
	@GetMapping(value = "user/userUpdateForm")
	public ModelAndView userUpdateForm(String user_id) {
		UserVO user = userserivce.userSelect(user_id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("user", user);
		mav.setViewName("user/userUpdateForm");
		return mav;
	}// end
	
	@PostMapping(value = "user/userUpdate")
	public String userUpdate(UserVO user) {
		userserivce.userUpdate(user);
		return "redirect:/user/userSelect?user_id=" + user.getUser_id();
	}// end
	
//	사용자 승인
	@PostMapping(value = "user/userApproval")
	public String userApproval(UserVO user) {
		userserivce.userApproval(user);
		return "redirect:/user/userSelect?user_id=" + user.getUser_id();
	}//end

}// end class
