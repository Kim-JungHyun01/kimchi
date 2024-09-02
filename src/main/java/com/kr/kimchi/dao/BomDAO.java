package com.kr.kimchi.dao;


import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kr.kimchi.vo.BomVO;

@Repository
public class BomDAO {
	
private final static String namespace="com.kr.kimchi.bomMapper";
	
	@Inject
	private SqlSession session;
	
//	bom정보_스케줄 보기
	public BomVO bomSelect(int item_no){
		return session.selectOne(namespace+".bomSelect", item_no);
	}//end
	
//	bom정보_스케줄 추가
	public void bomInsert(BomVO bom) {
		session.selectOne(namespace+".bomInsert", bom);
	}//end
	
//	bom정보_스케줄 수정
	public void bomUpdate(BomVO bom) {
		session.selectOne(namespace+".bomUpdate", bom);
	}//end 
	
//	bom정보_스케줄 삭제
	public void bomDelete(int item_no) {
		session.selectOne(namespace+".bomDelete", item_no);
	}//end

}//end class
