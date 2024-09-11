package com.kr.kimchi.dao;

import java.util.List;import com.kr.kimchi.controller.SearchBoardController;
import com.kr.kimchi.vo.BoardCriteria;
import com.kr.kimchi.vo.BoardSearchCriteria;
import com.kr.kimchi.vo.BoardVO;

public interface BoardDAO {
   
	public void create(BoardVO vo)throws Exception;
	
	public BoardVO read(Integer board_no)throws Exception;
	
	public void update(BoardVO vo)throws Exception;
	
	public void delete(Integer board_no)throws Exception;
	
	public List<BoardVO> listAll()throws Exception;
	
	public List<BoardVO> listPage(int page)throws Exception;
	
	public List<BoardVO> listCriteria(BoardCriteria cri) throws Exception;
	
	public int countPaging(BoardCriteria cri)throws Exception;
	
	public List<BoardVO> listSearch(BoardSearchCriteria cri) throws Exception;
	
	public int listSearchCount(BoardSearchCriteria cri)throws Exception;
	
}
