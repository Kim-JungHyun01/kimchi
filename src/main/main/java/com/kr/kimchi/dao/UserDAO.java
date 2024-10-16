package com.kr.kimchi.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kr.kimchi.vo.UserVO;

@Repository
public class UserDAO {
	
	private final static String namespace = "com.kr.kimchi.mappers.UserMapper";

	@Inject
	private SqlSession session;
	
//	사용자 로그인
	public Map<String, Object> userLogin(Map<String, Object> usermap){
		return session.selectOne(namespace + ".userLogin", usermap);
	}//end
	
//	사용자 전체 + 페이징
	public List<UserVO> userAll(int startRow, int pageSize, String user_name, String user_department){
		Map<String, Object> params = new HashMap<>();
			params.put("startRow", startRow);
	        params.put("pageSize", pageSize);
	        params.put("user_name", user_name);
	        params.put("user_department", user_department);
	        
		    // SQL 쿼리에서 페이지 정보 + 검색 조건 사용 
		return session.selectList(namespace+".userAll", params);
	}//end
	
//	전체 레코드 수
	public Integer getTotalCount() {
		return session.selectOne(namespace + ".getTotalCount");		
	} //end
	
//	검색 이후 페이지 수 계산
	public Integer userSearch(int pageSize, String user_name, String user_department) {
	    Map<String, Object> params = new HashMap<>();
	    params.put("user_name", user_name);
	    params.put("user_department", user_department); // department 추가

	    Integer totalCount = session.selectOne(namespace + ".userSearch", params);
	    if (totalCount == null || totalCount == 0) {
	        return 0;
	    }
	    return (int) Math.ceil((double) totalCount / pageSize);
	}//end
	
//	사용자 상세
	public UserVO userSelect(String user_id) {
		return session.selectOne(namespace+".userSelect", user_id);
	}//end
	
//	사용자 회원가입
	public void userInsert(UserVO user) {
		session.selectOne(namespace+".userInsert", user);
	}//end

//	사용자 id중복확인
	public Integer userIdCheck(String user_id) {
		return session.selectOne(namespace + ".userIdCheck", user_id);
	}// end
	
//	사용자 정보 수정
	public void userUpdate(UserVO user) {
		session.selectOne(namespace+".userUpdate", user);
	}//end
	
//	사용자 승인
	public void userApproval(UserVO user) {
		session.selectOne(namespace+".userApproval", user);
	}//end

}// end class
