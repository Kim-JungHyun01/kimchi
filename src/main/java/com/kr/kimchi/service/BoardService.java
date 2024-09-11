package com.kr.kimchi.service;

import java.util.List;

import com.kr.kimchi.vo.BoardCriteria;
import com.kr.kimchi.vo.BoardSearchCriteria;
import com.kr.kimchi.vo.BoardVO;


public interface BoardService {

	public void regist(BoardVO board)throws Exception;
	
	public BoardVO read(Integer board_no)throws Exception;
	
	public void modify(BoardVO board)throws Exception;
	
	public void remove(Integer board_no)throws Exception;
	
	public List<BoardVO> listAll()throws Exception;
	
	public List<BoardVO> listCriteria(BoardCriteria cri)throws Exception;
	
	public int listCountCriteria(BoardCriteria cri)throws Exception;
	
	public List<BoardVO> listSearchCriteria(BoardSearchCriteria cri)throws Exception;
	
	public int listSearchCount(BoardSearchCriteria cri)throws Exception;
	
}
