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

@Controller
public class MaterialController {

	@Autowired
    private MaterialService maService;

    // 전체 목록 조회
    @GetMapping(value = "/material/maList")
    public ModelAndView maList() {
        List<MaterialVO> list = maService.maList();
        ModelAndView mav = new ModelAndView("material/maList");
        mav.addObject("list", list);
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

    // 수정이동
    @GetMapping(value = "/material/maUpdate")
    public String maUpdateForm(@RequestParam("ma_id") int ma_id, Model model) {
        MaterialVO ma = maService.maView(ma_id);
        model.addAttribute("ma", ma); // 
        return "material/maUpdate"; 
    }

    //수정
    @PostMapping(value = "/material/maUpdate")
    public String maUpdate(MaterialVO maUpdate, RedirectAttributes reAtt) {
    	System.out.println("data update" + maUpdate);
        maService.maUpdate(maUpdate);
        reAtt.addAttribute("message", "수정됨"); //
        return "redirect:/material/maList";
    }
    
    // 리포트 요청 처리
    @GetMapping(value = "/material/maReport")
    public ModelAndView maReport(@RequestParam(required = false) String startDate, 
                                  @RequestParam(required = false) String endDate) {
        ModelAndView mav = new ModelAndView("material/maReport");
        
        if (startDate == null || endDate == null) {
            mav.addObject("message", "시작 날짜와 종료 날짜는 필수입니다.");
            return mav;
        }
        try {
            List<Map<String, Object>> list = maService.maReport(startDate, endDate);
            if (list.isEmpty()) {
                mav.addObject("message", "데이터x");
            } else {
                mav.addObject("list", list);
            }
        } catch (SQLException e) {
            mav.addObject("error", "데이터 오류");
        }

        return mav;
    }
}