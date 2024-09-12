package com.kr.kimchi;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.kr.kimchi.dao.BoardDAO;
import com.kr.kimchi.vo.BoardCriteria;
import com.kr.kimchi.vo.BoardSearchCriteria;
import com.kr.kimchi.vo.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/*.xml"})
public class BoardDAOTest {
 
    @Inject
    private BoardDAO dao;
    
    private static Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);
    
    
    @Test
     public void testCreate() throws Exception {
    	
    	Date d = new Date(0);
    	BoardVO board = new BoardVO();
    	board.setBoard_title("새로운 글을 넣습니다.");
    	board.setBoard_content("새로운 글을 넣습니다.");
    	board.setBoard_comment("dfasd");
    	board.setBoard_createdDate(d);
    	board.setBoard_modifiedDate(d);
    	board.setUser_id("abcd");
    	board.setAttachment_no(3);
    	dao.create(board);
    }
    
    @Test
    public void testRead() throws Exception {
    	
    	logger.info(dao.read(6).toString());
    	
    }
    
    @Test
    public void testUpdate() throws Exception{
    	
      BoardVO board = new BoardVO();
      board.setBoard_no(1);
      board.setBoard_title("수정된 글입니다.");
      board.setBoard_content("수정 테스트");
      dao.update(board);
    }
    
    @Test
    public void testDelete() throws Exception {
    	
     dao.delete(1);
    }
    
    @Test
    public void testListPage()throws Exception{
    	
    	int page = 3;
    	
    	List<BoardVO> list = dao.listPage(page);
    	
    	for (BoardVO boardVO : list) {
			logger.info(boardVO.getBoard_no() + ":" + boardVO.getBoard_title());
		}
    }
    
    @Test
     public void testListCriteria()throws Exception{
    	
    	BoardCriteria cri = new BoardCriteria();
    	cri.setPage(2);
    	cri.setPerPageNum(20);
    	
    	List<BoardVO> list = dao.listCriteria(cri);
    	
    	for (BoardVO boardVO : list) {
			logger.info(boardVO.getBoard_no() + ":" + boardVO.getBoard_title());
		}
    }
    
    @Test
     public void testURI()throws Exception{
    	
    	UriComponents uriComponents = 
    	  UriComponentsBuilder.newInstance().path("/board/read").queryParam("board_no", 12).queryParam("perPageNum", 20).build();
    	
    logger.info("/board/read?board_no=12&perPageNum=20");
    logger.info(uriComponents.toString());
    	
    }
    
    
    @Test
    public void testDynamic1() throws Exception{
    	
    	BoardSearchCriteria cri = new BoardSearchCriteria();
    	
    	cri.setPage(1);
    	cri.setKeyword("글");
    	cri.setSearchType("t");
    	
    	logger.info("====================");
    	
    	List<BoardVO> list = dao.listSearch(cri);
    	
    	for (BoardVO boardVO : list) {
			logger.info(boardVO.getBoard_no() + ":" + boardVO.getBoard_title() );
		}
    	
    	logger.info("====================");
    	
    	logger.info("COUNT: " + dao.listSearchCount(cri));
    	
    }
    
}
