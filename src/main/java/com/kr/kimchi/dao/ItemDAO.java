package com.kr.kimchi.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kr.kimchi.vo.ItemVO;

@Repository
public class ItemDAO {

	private final static String namespace = "com.kr.kimchi.mappers.itemMapper";

	@Inject
	private SqlSession session;
	
//	제품정보(전체)
	public List<ItemVO> itmeAll(Map<String, Object> list) {
		return session.selectList(namespace+".itmeAll", list);
	}//end
	
//	제품정보(상세)
	public ItemVO itemSelect(int item_no){
		return session.selectOne(namespace+".itemSelect",item_no);
	}//end
	
//	제품정보추가
	public void itemInsert(ItemVO item) {
		session.selectOne(namespace+".itemInsert",item);
	}//end
	
//	제품정보 수정
	public void itemUpdate(ItemVO item) {
		session.selectOne(namespace+".itemUpdate",item);
	}//end
	
//	제품 bom등록여부수정
	public void bomCheck(ItemVO item) {
		session.selectOne(namespace+".bomCheck",item);
	}//end
	
//	제품삭제
	public void itemDelete(int item_no) {
		session.selectOne(namespace+".itemDelete",item_no);
	}//end
	
	
	

}// end class
