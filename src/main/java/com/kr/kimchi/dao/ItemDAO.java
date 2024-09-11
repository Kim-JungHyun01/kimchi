package com.kr.kimchi.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kr.kimchi.vo.ItemVO;

@Repository
public class ItemDAO {
	@Inject
	private SqlSession session;

	private final static String namespace = "com.kr.kimchi.mappers.itemMapper";

	
//	제품정보(전체)
	public List<ItemVO> itemAll(int startRow, int pageSize, String item_name){
		 Map<String, Object> params = new HashMap<>();
	        params.put("startRow", startRow);
	        params.put("pageSize", pageSize); 
	        params.put("item_name", item_name);
		return session.selectList(namespace+".itemAll", params);
	}//end
	
//	전체 레코드 수
	public Integer getTotalCount() {
		return session.selectOne(namespace + ".getTotalCount");		
	} //end
	
//	검색 이후 페이지 수 계산
	public Integer itemSearch(int pageSize, String item_name) {
		Map<String, Object> params = new HashMap<>();
		params.put("item_name", item_name);
		Integer totalCount = session.selectOne(namespace +".itemSearch", params);
		if(totalCount == null || totalCount == 0) {
			return 0;
		}
		return (int)Math.ceil((double) totalCount / pageSize);
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
