package com.kr.kimchi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kr.kimchi.service.informationService;
import com.kr.kimchi.vo.IOVO;
import com.kr.kimchi.vo.InlistVO;
import com.kr.kimchi.vo.ObtainVO;
import com.kr.kimchi.vo.StatusCheck;
import com.kr.kimchi.vo.transactionVO;

@Controller
public class ioController {
	
	@Inject
	informationService service;

	private static final Logger logger = LoggerFactory.getLogger(ioController.class);
	
	@RequestMapping(value="information", method = RequestMethod.GET)
	public ModelAndView io_imformation() {
		ModelAndView mav = new ModelAndView();
		List<ObtainVO> list= service.modar_data();
		List<InlistVO> in_list=service.in_select();
		
		
		mav.addObject("in", in_list);
		mav.addObject("list", list);
		mav.setViewName("io/information");
		
		return mav;
	}
	
	@PostMapping(value = "insert_io")
	public String IN_io_imformation(IOVO vo, RedirectAttributes rttr) {
	    
		vo.setIo_status("입고중");
	    
	    System.out.println(vo);

	    int obtain_no = vo.getObtain_no();
	    System.out.println(obtain_no);

	    int result = service.in_add(vo);
	    int result2 = service.in_update_ob(obtain_no);

	    if (result > 0 && result2 > 0) {
	        rttr.addFlashAttribute("msg", "success");
	    }

	    return "redirect:/information"; 
	}
	
	@PostMapping("io_status_ch")
	public String handleFormSubmit(@RequestParam(value = "iocheck", required = false) List<String> iocheck , RedirectAttributes rttr) {
	    List<StatusCheck> dataList = new ArrayList<>();
	    
	    if (iocheck != null) {
	        for (String item : iocheck) {
	            try {
	                String[] parts = item.split(",");
	                if (parts.length == 5) {
	                    StatusCheck dataObject = new StatusCheck();
	                    dataObject.setIo_id(parseInteger(parts[0]));
	                    dataObject.setObtain_no(parseInteger(parts[1]));
	                    dataObject.setIo_status(parts[2]);
	                    dataObject.setIo_quantity(parseInteger(parts[3]));
	                    dataObject.setMa_id(parseInteger(parts[4]));
	                    dataList.add(dataObject);
	                }
	            } catch (Exception e) {
	                // 예외 처리 로직
	                e.printStackTrace();
	            }
	        }
	    }

	    // 데이터 처리 로직
	    System.out.println(dataList);
	    
	    
	    for(int i=0 ; i < dataList.size();i++) {
	    	
	    	int status_done=service.io_status_change(dataList.get(i).getIo_id());
	    	int material_plus=service.material_io(dataList.get(i));
	    	
	    	if(status_done < 0 || material_plus < 0) {
	    		break;
	    	}
	    }
	    
	    rttr.addFlashAttribute("msg", "plus");
	    
	    
	    

	    return "redirect:/information"; // 리다이렉트할 페이지 또는 뷰 이름
	}

	private Integer parseInteger(String value) {
	    try {
	        return value == null || value.isEmpty() ? null : Integer.parseInt(value);
	    } catch (NumberFormatException e) {
	        // 숫자 변환 실패 시 null을 반환
	        return null;
	    }
	}
	
	@GetMapping(value = "transaction")
    public String transaction(@RequestParam(value = "obtain_no", required = false)  String obtainNo,
                              RedirectAttributes rttr, Model model) {

		  if (obtainNo != null) {
		        try {
		            Integer obtainNoInt = parseInteger(obtainNo);
		            StatusCheck dataObject = new StatusCheck();
		            dataObject.setObtain_no(obtainNoInt);
		            
		            // 데이터 처리 로직
		            transactionVO statement = service.transaction_statement(obtainNoInt);
		            System.out.println(statement);
		            model.addAttribute("statement", statement);

		            // 반환하는 뷰 이름
		            return "/io/transaction";
		        } catch (Exception e) {
		            e.printStackTrace();
		            // 에러 처리
		            return "/error";
		        }
		    }

		    return "/error"; // 잘못된 요청 처리
    }

    private Integer parseIntegers(String value) {
        try {
            return value == null || value.isEmpty() ? null : Integer.parseInt(value);
        } catch (NumberFormatException e) {
            // 숫자 변환 실패 시 null을 반환
            return null;
        }
    }
		
	    
	
		
	}
		
		
	
	
	

