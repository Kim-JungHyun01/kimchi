package kr.co.kim.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.kim.vo.PagingVO;

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
