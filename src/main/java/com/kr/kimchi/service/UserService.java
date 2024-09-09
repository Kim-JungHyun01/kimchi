package com.kr.kimchi.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kr.kimchi.dao.UserDAO;
import com.kr.kimchi.vo.UserVO;

@Service
public class UserService {

	@Inject
	private UserDAO userdao;

//	사용자 로그인
	public Map<String, Object> userLogin(Map<String, Object> usermap) {
		return userdao.userLogin(usermap);
	}// end

//	사용자 전체
	public List<UserVO> userAll() {
		return userdao.userAll();
	}// end

//	사용자 상세
	public UserVO userSelect(String user_id) {
		return userdao.userSelect(user_id);
	}// end

//	사용자 회원가입
	public void userInsert(UserVO user) {
		userdao.userInsert(user);
	}// end
	
//	사용자 id중복확인
	public List<String> userIdCheck(String user_id) {
		return userdao.userIdCheck(user_id);
	}//end

//	사용자 정보 수정
	public void userUpdate(UserVO user) {
		userdao.userUpdate(user);
	}// end

//	사용자 승인
	public void userApproval(UserVO user) {
		userdao.userApproval(user);
	}// end

}// end class
