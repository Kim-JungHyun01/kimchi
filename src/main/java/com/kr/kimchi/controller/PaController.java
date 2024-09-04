package com.kr.kimchi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kr.kimchi.service.PaService;
import com.kr.kimchi.service.PrpService;
import com.kr.kimchi.vo.PaPageLIst;
import com.kr.kimchi.vo.PaPageVO;
import com.kr.kimchi.vo.PaVO;
import com.kr.kimchi.vo.PrpVO;


@Controller
public class PaController {
	
	@Inject
	private PaService paService;
	
	@Inject
	private PrpService prpaService;
	
	@GetMapping(value="/pa")
	public ModelAndView pa(@RequestParam(defaultValue = "1") int pageNum,HttpSession session) {
		// ��ū����
		String token = UUID.randomUUID().toString();
		session.setAttribute("token", token);
		
		
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
		
		//��ū
		mav.addObject("token", token);
		mav.setViewName("pa/pa");
		return mav;
	}
	
	@PostMapping(value="/pa")
	public ModelAndView prpSave(PrpVO prpVO,@RequestParam(defaultValue = "1") int pageNum,
			@RequestParam("token") String token,HttpSession session) {
		// ��ū �˻�
		String sessionToken = (String) session.getAttribute("token");
		
		if (sessionToken != null && sessionToken.equals(token)) {
			// ��� �� ��ū ����
            session.removeAttribute("token"); 
		
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
		}else {
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
		
	}
	
	
}
