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
		
		// ������ ���ϱ� ���� ��ü ����Ʈ
		List<PaVO> allList = paService.paAllList();
		
		// ������ �ʼ� ó��
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
		
		// ����Ʈ�� ���ҷ� ����
		params.putIfAbsent("ca_id", 3); // ���Ź��ּ��� 3���� ����
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
		// ������ ���ϱ� ���� ��ü ����Ʈ
		List<PaVO> allList = paService.paAllList();
		
		// ������ �ʼ� ó��
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
		
		// ����Ʈ�� ���ҷ� ����
		params.putIfAbsent("ca_id", 3); // ���Ź��ּ��� 3���� ����
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
