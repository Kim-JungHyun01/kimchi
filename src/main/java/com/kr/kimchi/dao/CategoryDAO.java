package com.kr.kimchi.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kr.kimchi.vo.CategoryVO;

@Repository
public class CategoryDAO {
	private final static String namespace = "com.kr.kimchi.mappers.categoryMapper";

	@Inject
	private SqlSession session;
	
	public List<CategoryVO> cateAll(Map<String, Object> cate){
		return session.selectList(namespace+".cateAll", cate);
	}//end

}// end class
