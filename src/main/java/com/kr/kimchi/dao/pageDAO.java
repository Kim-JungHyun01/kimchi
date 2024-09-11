package com.kr.kimchi.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kr.kimchi.vo.PagingVO;

@Repository
public class pageDAO {
	
	@Inject
	private SqlSession sqlSession;
	private static final String namespces="kr.co.kim.pagemapper";
	
	public int countpage(){

		return 0;
	}
	
	public List<PagingVO> selectwirte(PagingVO vo){
		List<PagingVO> list = null;
		
		return list;
	}

}
