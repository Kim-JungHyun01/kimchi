package com.kr.kimchi.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kr.kimchi.dao.BoardDAO;
import com.kr.kimchi.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO dao;
	
	@Override
	public void regist(BoardVO board) throws Exception {
		dao.create(board);
	}

	@Override
	public BoardVO read(Integer board_no) throws Exception {
		return dao.read(board_no);
	}

	@Override
	public void modify(BoardVO board) throws Exception {
	    dao.update(board);
	}

	@Override
	public void remove(Integer board_no) throws Exception {
		dao.delete(board_no);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
	return dao.listAll();
	}

}
