package com.kr.kimchi.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kr.kimchi.service.MaterialService;
import com.kr.kimchi.vo.MaterialVO;
import com.kr.kimchi.vo.PaginationVO;

@Controller
public class MaterialController {

    @Autowired
    private MaterialService maService;

    // 전체 목록 조회
    @GetMapping(value = "/material/maList")
    public ModelAndView maList(@RequestParam(defaultValue = "1") int pageNum, 
                                @RequestParam(required = false) String ma_name) {
        int pageSize = 2; // 한 페이지에 보여줄 갯수
        int pageNavSize = 5; // 페이지 네비 크기
        
        // startRow 계산
        int startRow = (pageNum - 1) * pageSize; 

        List<MaterialVO> list = maService.maList(startRow, pageSize, ma_name); // startRow와 pageSize로 서비스 호출
        Integer totalCount = maService.getTotalCount(); // 총 레코드 수 가져오기
        Integer totalPages = maService.getSearch(pageSize, ma_name); // 검색 페이지 수 계산
        
        PaginationVO pagination = new PaginationVO(pageNum, totalCount, pageSize, pageNavSize);
        
        ModelAndView mav = new ModelAndView("material/maList");
        mav.addObject("list", list);
        mav.addObject("pagination", pagination);
        mav.addObject("currentPage", pageNum);
        mav.addObject("totalPages", totalPages);
        
        return mav;
    }

    // 선택
    @GetMapping(value = "/material/maView")
    public ModelAndView maView(@RequestParam("ma_id") int ma_id) {
        MaterialVO ma = maService.maView(ma_id);
        ModelAndView mav = new ModelAndView("material/maView");
        mav.addObject("ma", ma);
        return mav;
    }

    // 추가 이동
    @GetMapping(value = "/material/maAdd")
    public String maAddForm(Model model) {
        model.addAttribute("ma", new MaterialVO());
        return "material/maAdd";
    }

    // 추가
    @PostMapping(value = "/material/maAdd")
    public String maAdd(MaterialVO maAdd, RedirectAttributes reAtt) {
        maService.maAdd(maAdd);
        reAtt.addFlashAttribute("message", "추가됨");
        return "redirect:/material/maList";
    }

    // 수정 이동
    @GetMapping(value = "/material/maUpdate")
    public String maUpdateForm(@RequestParam("ma_id") int ma_id, Model model) {
        MaterialVO ma = maService.maView(ma_id);
        model.addAttribute("ma", ma);
        return "material/maUpdate"; 
    }

    // 수정
    @PostMapping(value = "/material/maUpdate")
    public String maUpdate(MaterialVO maUpdate, RedirectAttributes reAtt) {
        maService.maUpdate(maUpdate);
        reAtt.addFlashAttribute("message", "수정됨");
        return "redirect:/material/maList";
    }

    // 리포트 요청 처리
    @GetMapping(value = "/material/maReport")
    public ModelAndView maReport(@RequestParam(required = false) String startDate, 
                                 @RequestParam(required = false) String endDate,
                                 @RequestParam(required = false) String ma_name) {
        ModelAndView mav = new ModelAndView("material/maReport");

        if (startDate == null || endDate == null) {
            mav.addObject("message", "시작 날짜와 종료 날짜 입력이 필요합니다.");
            return mav;
        }

        try {
            List<Map<String, Object>> list = maService.maReport(startDate, endDate, ma_name);
            if (list.isEmpty()) {
                mav.addObject("message", "조회된 데이터가 없습니다.");
            } else {
                mav.addObject("list", list);
            }
        } catch (SQLException e) {
            mav.addObject("error", "데이터베이스 오류: " + e.getMessage());
        } catch (Exception e) {
            mav.addObject("message", "형식 오류: " + e.getMessage());
        }
        return mav;
    }
    //------------------------
}
