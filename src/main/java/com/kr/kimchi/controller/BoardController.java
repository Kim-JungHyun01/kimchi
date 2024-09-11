package com.kr.kimchi.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kr.kimchi.service.BoardService;
import com.kr.kimchi.vo.BoardVO;
import com.kr.kimchi.vo.PaginationVO;

@Controller
@RequestMapping("/board/")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
    private BoardService service;
	
	
 	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET(BoardVO board, Model model) throws Exception{
		
		logger.info("register get..........");
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registPOST(BoardVO board, RedirectAttributes rttr)throws Exception{
		
		logger.info("regist post ...........");
		logger.info(board.toString());
		
		service.regist(board);
		
		rttr.addFlashAttribute("msg", "success");
		

		return "redirect:/board/ListAll";
	}
	
	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public void listAll(@RequestParam(defaultValue = "1") int pageNum, Model model) throws Exception {
	    int pageSize = 2; // 한 페이지에 보여줄 갯수 /// 글이 3개여서 페이지 2개로 설정했어요!
	    int pageNavSize = 5; // 페이지 네비 크기
	    
	    // startRow 계산
	    int startRow = (pageNum - 1) * pageSize;
	    
	    // startRow와 pageSize로 서비스 호출
	    List<BoardVO> list = service.listAll(startRow, pageSize);
	    
	    // 총 레코드 수 가져오기
	    Integer totalCount = service.getTotalCount();
	    
	    PaginationVO pagination = new PaginationVO(pageNum, totalCount, pageSize, pageNavSize);
	    
	    logger.info("show all list............." + service.read(8));
	    
	    // 모델에 데이터 추가
	    model.addAttribute("list", list);
	    model.addAttribute("pagination", pagination);
	    model.addAttribute("currentPage", pageNum);
	    model.addAttribute("totalPages", pagination.getTotalPage());
	}

		
		@RequestMapping(value = "/read", method = RequestMethod.GET)
		public void read(@RequestParam("board_no") int board_no, Model model) throws Exception {
			
			
			model.addAttribute(service.read(board_no));
			
			logger.info("show" );
		}
		
		@RequestMapping(value = "/remove", method = RequestMethod.POST)
		public String remove(@RequestParam("board_no") int board_no,
				RedirectAttributes rttr)throws Exception {
			
			service.remove(board_no);
			
			rttr.addFlashAttribute("msg", "SUCCESS");
			
			return "redirect:/board/listAll";
		}
		
		
		@RequestMapping(value = "/modify", method = RequestMethod.GET)
		public void modifyGET(int board_no, Model model) throws Exception {
			
			model.addAttribute(service.read(board_no));
		}
		
		@RequestMapping(value = "/modify", method = RequestMethod.POST)
		public String modifyPOST(BoardVO board_no,
				RedirectAttributes rttr) throws Exception {
			
			logger.info("mod post...........");
			
			service.modify(board_no);
			rttr.addFlashAttribute("msg", "SUCCESS");
			
			return "redirect:/board/listAll";
		}
	
}
