package com.kr.kimchi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kr.kimchi.service.UserService;
import com.kr.kimchi.vo.PaginationVO;
import com.kr.kimchi.vo.UserVO;

@Controller
public class UserController {

	@Inject
	private UserService userservice;

//	사용자 전체+페이징+서치
	@GetMapping(value = "user/userAll")
	public ModelAndView userAll(@RequestParam(defaultValue = "1") int pageNum,
								@RequestParam(required = false) String user_name,
								@RequestParam(required = false) String user_department) {
		
		int pageSize = 10; // 한 페이지에 보여줄 갯수 
	    int pageNavSize = 5; // 페이지 네비 크기
	    
	    int startRow = (pageNum - 1) * pageSize; //시작페이지 계산
	    
		List<UserVO> userlist = userservice.userAll(startRow, pageSize, user_name, user_department);
		
		Integer totalCount = userservice.getTotalCount(); // 총 레코드 수 가져옴
		Integer totalPages = userservice.userSearch(pageSize, user_name, null); // 검색 이후 ㄹㅔ코드수 계산
		
		PaginationVO pagination = new PaginationVO(pageNum, totalCount, pageSize, pageNavSize);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("pagination", pagination);
	    mav.addObject("currentPage", pageNum);
	    mav.addObject("totalPages", totalPages);
	    
		mav.addObject("userlist", userlist);
		mav.setViewName("user/userAll");
		return mav;
	}// end

//	사용자 상세
	@GetMapping(value = "user/userSelect")
	public ModelAndView userSelect(String user_id) {
		UserVO user = userservice.userSelect(user_id);
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
	
//	사용자 id 중복확인
	@GetMapping(value = "user/userIdCheck")
	public ResponseEntity<Map<String, String>> userIdCheck(@RequestParam String user_id) {
	    Map<String, String> response = new HashMap<>();
	    int user = userservice.userIdCheck(user_id);
	    if (user == 0) {
	        response.put("status", "없음");
	    } else {
	        response.put("status", "있음");
	    }
	    return ResponseEntity.ok(response);
	}

	@PostMapping(value = "user/userInsert")
	public String userInsert(UserVO user) {
		userservice.userInsert(user);
		return "redirect:/login/loginForm";
	}// end

//	사용자 정보 수정
	@GetMapping(value = "user/userUpdateForm")
	public ModelAndView userUpdateForm(String user_id) {
		UserVO user = userservice.userSelect(user_id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("user", user);
		mav.setViewName("user/userUpdateForm");
		return mav;
	}// end
	
	@PostMapping(value = "user/userUpdate")
	public String userUpdate(UserVO user) {
		userservice.userUpdate(user);
		return "redirect:/user/userSelect?user_id=" + user.getUser_id();
	}// end
	
//	사용자 승인
	@PostMapping(value = "user/userApproval")
	public String userApproval(UserVO user) {
		userservice.userApproval(user);
		return "redirect:/user/userSelect?user_id=" + user.getUser_id();
	}//end

}// end class
