package com.kr.kimchi.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kr.kimchi.vo.UserVO;
import com.mysql.cj.protocol.Resultset;

@Repository
public class UserDAO {

	private final static String namespace = "com.kr.kimchi.mappers.UserMapper";

	@Inject
	private SqlSession session;

//	사용자 로그인
	public Map<String, Object> userLogin(Map<String, Object> usermap) {
		return session.selectOne(namespace + ".userLogin", usermap);
	}// end

//	사용자 전체
	public List<UserVO> userAll() {
		return session.selectList(namespace + ".userAll");
	}// end

//	사용자 상세
	public UserVO userSelect(String user_id) {
		return session.selectOne(namespace + ".userSelect", user_id);
	}// end

//	사용자 회원가입
	public void userInsert(UserVO user) {
		session.selectOne(namespace + ".userInsert", user);
	}// end

//	사용자 id중복확인
	public List<String> userIdCheck(String user_id) {
		return session.selectList(namespace + ".userIdCheck", user_id);
	}// end

//	사용자 정보 수정
	public void userUpdate(UserVO user) {
		session.selectOne(namespace + ".userUpdate", user);
	}// end

//	사용자 승인
	public void userApproval(UserVO user) {
		session.selectOne(namespace + ".userApproval", user);
	}// end

}// end class
