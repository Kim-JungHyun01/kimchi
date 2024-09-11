package com.kr.kimchi.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kr.kimchi.vo.BoardCriteria;
import com.kr.kimchi.vo.BoardSearchCriteria;
import com.kr.kimchi.vo.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject 
	private SqlSession session;
	
	private static String namespace = "com.kr.kimchi.mappers.BoardMapper";
	
	@Override
	public void create(BoardVO vo) throws Exception {
		session.insert(namespace+".create", vo);
	}

	@Override
	public BoardVO read(Integer board_no) throws Exception {
		return session.selectOne(namespace+".read", board_no);
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		session.update(namespace + ".update", vo);
	}

	@Override
	public void delete(Integer board_no) throws Exception {
		session.delete(namespace + ".delete", board_no);

	}
	
	// 레코드수
	@Override
	public Integer getTotalCount() {
		return session.selectOne(namespace + ".getTotalCount");
	}

	@Override
	public List<BoardVO> listPage(int page) throws Exception {
		
		if (page <= 0) {
			page = 1;
		}
		
		page = (page -1) * 10;
		
		return session.selectList(namespace + ".listPage", page);
	}

	@Override
	public List<BoardVO> listCriteria(BoardCriteria cri) throws Exception {
	
		return session.selectList(namespace+".listCriteria", cri);
	}

	@Override
	public int countPaging(BoardCriteria cri) throws Exception {
	
		return session.selectOne(namespace+".countPaging", cri);
	}

	@Override
	public List<BoardVO> listSearch(BoardSearchCriteria cri) throws Exception {
	
		return session.selectList(namespace + ".listSearch", cri);
	}

	@Override
	public int listSearchCount(BoardSearchCriteria cri) throws Exception {

		return session.selectOne(namespace + ".listSearchCount", cri);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
