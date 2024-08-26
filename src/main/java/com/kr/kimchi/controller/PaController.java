package com.kr.kimchi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kr.kimchi.service.PaService;
import com.kr.kimchi.vo.CategoryVO;
import com.kr.kimchi.vo.PaPageLIst;
import com.kr.kimchi.vo.PaPageVO;
import com.kr.kimchi.vo.PaVO;


@Controller
public class PaController {
	
	@Inject
	private PaService paService;
	
	@GetMapping(value="/pa")
	public ModelAndView pa(@RequestParam(defaultValue = "1") int pageNum) {
		
		// ������ ���ϱ� ���� ��ü ����Ʈ
		List<PaVO> allList = paService.paAllList();
		
		// ������ �ʼ� ó��
		PaPageVO pageVO = new PaPageVO(pageNum, allList.size());
		System.out.println("PaController page : "+ pageVO.getPageNum());
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("start", (pageVO.getPageNum()-1)*pageVO.getListcnt());
		System.out.println("PaController start : " + pageVO.getStart());
		params.put("end", pageVO.getListcnt());
		System.out.println("PaController listcnt : " + pageVO.getListcnt() );
		System.out.println("PaController startPage : " + pageVO.getStartPage() );
		System.out.println("PaController endPage : " + pageVO.getEndPage() );
		
		// ����Ʈ�� ���ҷ� ����
		params.putIfAbsent("ca_id", 3); // ���Ź��ּ��� 3���� ����
		List<PaVO> pageAllList = paService.paList(params);
		System.out.println("PaController pageAllList : " + pageAllList);
		
		PaPageLIst poPageList = new PaPageLIst(pageAllList, pageVO);
		ModelAndView mav = new ModelAndView();
		mav.addObject("paPageList", poPageList);
		mav.setViewName("pa");
		return mav;
	}
	
}
