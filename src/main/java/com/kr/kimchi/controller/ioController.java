package kr.co.kim.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.co.kim.service.imformationService;
import kr.co.kim.vo.ObtainVO;

@Controller
public class ioController {
	
	@Inject
	imformationService service;

	private static final Logger logger = LoggerFactory.getLogger(ioController.class);
	
	@RequestMapping(value="imformation", method = RequestMethod.GET)
	public ModelAndView io_imformation() {
		ModelAndView mav = new ModelAndView();
		List<ObtainVO> list= service.modar_data();
		
		System.out.println(list);
		
		mav.addObject("list", list);
		mav.setViewName("io/imformation");
		
		return mav;
	}
	
	
}
