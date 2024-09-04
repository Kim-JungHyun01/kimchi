package com.kr.kimchi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD
=======
import org.springframework.web.bind.annotation.PostMapping;
>>>>>>> origin/0904_dohyun
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kr.kimchi.service.PaService;
<<<<<<< HEAD
import com.kr.kimchi.vo.CategoryVO;
import com.kr.kimchi.vo.PaPageLIst;
import com.kr.kimchi.vo.PaPageVO;
import com.kr.kimchi.vo.PaVO;
=======
import com.kr.kimchi.service.PrpService;
import com.kr.kimchi.vo.PaPageLIst;
import com.kr.kimchi.vo.PaPageVO;
import com.kr.kimchi.vo.PaVO;
import com.kr.kimchi.vo.PrpVO;
>>>>>>> origin/0904_dohyun


@Controller
public class PaController {
	
	@Inject
	private PaService paService;
	
<<<<<<< HEAD
=======
	@Inject
	private PrpService prpaService;
	
>>>>>>> origin/0904_dohyun
	@GetMapping(value="/pa")
	public ModelAndView pa(@RequestParam(defaultValue = "1") int pageNum) {
		
		// 갯수를 구하기 위한 전체 리스트
		List<PaVO> allList = paService.paAllList();
		
		// 페이지 쪽수 처리
		PaPageVO pageVO = new PaPageVO(pageNum, allList.size());
		System.out.println("PaController page : "+ pageVO.getPageNum());
		
<<<<<<< HEAD
=======
		System.out.println("pageNum :" + pageNum);
>>>>>>> origin/0904_dohyun
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("start", (pageVO.getPageNum()-1)*pageVO.getListcnt());
		System.out.println("PaController start : " + pageVO.getStart());
		params.put("end", pageVO.getListcnt());
		System.out.println("PaController listcnt : " + pageVO.getListcnt() );
		System.out.println("PaController startPage : " + pageVO.getStartPage() );
		System.out.println("PaController endPage : " + pageVO.getEndPage() );
<<<<<<< HEAD
=======
		System.out.println("PaController total : " + pageVO.getTotal() );
		System.out.println("PaController listcnt : " + pageVO.getListcnt() );
>>>>>>> origin/0904_dohyun
		
		// 리스트를 분할로 받음
		params.putIfAbsent("ca_id", 3); // 구매발주서라 3으로 고정
		List<PaVO> pageAllList = paService.paList(params);
		System.out.println("PaController pageAllList : " + pageAllList);
		
<<<<<<< HEAD
		PaPageLIst poPageList = new PaPageLIst(pageAllList, pageVO);
		ModelAndView mav = new ModelAndView();
		mav.addObject("paPageList", poPageList);
		mav.setViewName("pa");
		return mav;
	}
	
=======
		PaPageLIst paPageList = new PaPageLIst(pageAllList, pageVO);
		ModelAndView mav = new ModelAndView();
		mav.addObject("paPageList", paPageList);
		mav.setViewName("pa/pa");
		return mav;
	}
	
	@PostMapping(value="/pa")
	public ModelAndView prpSave(PrpVO prpVO,@RequestParam(defaultValue = "1") int pageNum) {
		System.out.println("prpController prpVo :" + prpVO);
		prpaService.prpInsert(prpVO);
		// 갯수를 구하기 위한 전체 리스트
		List<PaVO> allList = paService.paAllList();
		
		// 페이지 쪽수 처리
		PaPageVO pageVO = new PaPageVO(pageNum, allList.size());
		System.out.println("PaController page : "+ pageVO.getPageNum());
		
		System.out.println("pageNum :" + pageNum);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("start", (pageVO.getPageNum()-1)*pageVO.getListcnt());
		System.out.println("PaController start : " + pageVO.getStart());
		params.put("end", pageVO.getListcnt());
		System.out.println("PaController listcnt : " + pageVO.getListcnt() );
		System.out.println("PaController startPage : " + pageVO.getStartPage() );
		System.out.println("PaController endPage : " + pageVO.getEndPage() );
		System.out.println("PaController total : " + pageVO.getTotal() );
		System.out.println("PaController listcnt : " + pageVO.getListcnt() );
		
		// 리스트를 분할로 받음
		params.putIfAbsent("ca_id", 3); // 구매발주서라 3으로 고정
		List<PaVO> pageAllList = paService.paList(params);
		System.out.println("PaController pageAllList : " + pageAllList);
		
		PaPageLIst paPageList = new PaPageLIst(pageAllList, pageVO);
		ModelAndView mav = new ModelAndView();
		mav.addObject("paPageList", paPageList);
		mav.setViewName("pa/pa");
		return mav;
	}
	
	
>>>>>>> origin/0904_dohyun
}
