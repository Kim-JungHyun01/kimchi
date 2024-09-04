package com.kr.kimchi.dao;

import java.util.List;

import com.kr.kimchi.vo.BoardVO;

public interface BoardDAO {
   
	public void create(BoardVO vo)throws Exception;
	
	public BoardVO read(Integer board_no)throws Exception;
	
	public void update(BoardVO vo)throws Exception;
	
	public void delete(Integer board_no)throws Exception;
	
	public List<BoardVO> listAll()throws Exception;
}
