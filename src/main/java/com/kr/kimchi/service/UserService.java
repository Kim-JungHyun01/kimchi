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

//	사용자 전체 + 페이징 + 서치
	public List<UserVO> userAll(int startRow, int pageSize, String user_name) {
		return userdao.userAll(startRow, pageSize, user_name);
	}// end
	
//	전체 레코드 수
    public Integer getTotalCount() {
		return userdao.getTotalCount();   	
    }//end
    
//    검색이후 페이지 수
    public Integer userSearch(int pageSize, String user_name) {
		return userdao.userSearch(pageSize, user_name);
    }

//	사용자 상세
	public UserVO userSelect(String user_id) {
		return userdao.userSelect(user_id);
	}// end

//	사용자 회원가입
	public void userInsert(UserVO user) {
		userdao.userInsert(user);
	}// end
	
//	사용자 id중복확인
	public int userIdCheck(String user_id) {
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
