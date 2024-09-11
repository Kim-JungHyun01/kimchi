package com.kr.kimchi.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kr.kimchi.service.MaterialService;
import com.kr.kimchi.service.ObtainService;
import com.kr.kimchi.service.OutService;
import com.kr.kimchi.vo.IOVO;
import com.kr.kimchi.vo.MaterialVO;
import com.kr.kimchi.vo.ObtainVO;
import com.kr.kimchi.vo.PaginationVO;

@Controller
public class OutController {

    private static final Logger logger = LoggerFactory.getLogger(OutController.class);

    @Autowired
    private OutService outservice;

    @Autowired 
    private MaterialService maService;
    
    @Autowired 
    private ObtainService obService; 
    
    // 전체 출고 목록
    @GetMapping(value = "/out/outList")
    public ModelAndView outList(@RequestParam(defaultValue = "1") int pageNum,
                                @RequestParam(required = false) Integer io_id) {
        int pageSize = 4; // 한 페이지에 보여줄 갯수
        int pageNavSize = 5; // 페이지 네비 크기
        
        // startRow 계산
        int startRow = (pageNum - 1) * pageSize; 
        
        List<IOVO> list = outservice.outList(startRow, pageSize, io_id);
        Integer totalCount = outservice.getTotalCount(); // 총 레코드 수 가져오기
        Integer totalPages = outservice.getSearch(pageSize, io_id); // 검색 페이지 수 계산
        
        PaginationVO pagination = new PaginationVO(pageNum, totalCount, pageSize, pageNavSize);
        
        ModelAndView mav = new ModelAndView("out/outList");
       
        mav.addObject("list", list);
        mav.addObject("pagination", pagination);
        mav.addObject("currentPage", pageNum); // 현재 페이지
        mav.addObject("totalPages", totalPages); 
        
        return mav;
    }
    
    // 선택된 출고 정보 보기
    @GetMapping(value = "/out/outView")
    public ModelAndView outView(@RequestParam("io_id") Integer io_id) {
        IOVO outvo = outservice.outView(io_id);
        ModelAndView mav = new ModelAndView("out/outView");
        mav.addObject("out", outvo);
        return mav;
    }

    // 출고 추가이동
    @GetMapping(value = "/out/outAdd")
    public ModelAndView outAddForm(Model model) {
        model.addAttribute("out", new IOVO());
        
        // maList 가져ㅛ올때
        List<MaterialVO> malist = maService.maList(0, Integer.MAX_VALUE, null);
        List<ObtainVO> obList = obService.obtainAll(0,100);
        
        model.addAttribute("malist", malist);
        model.addAttribute("obList", obList);
        
        ModelAndView mav = new ModelAndView();
        mav.addObject("malist", malist);
        mav.addObject("obList", obList);
        
        System.out.println(malist);
        System.out.println(obList);
        
        mav.setViewName("out/outAdd"); 
        return mav; 
    }

    // 출고 추가처리
    @PostMapping(value = "/out/outAdd")
    public String outAdd(IOVO outAdd, RedirectAttributes reAtt) {
        outservice.outAdd(outAdd);
        reAtt.addFlashAttribute("message", "출고등록 완료");
        return "redirect:/out/outList";
    }
}
