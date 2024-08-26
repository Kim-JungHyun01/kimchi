package com.kr.kimchi.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;

import com.kr.kimchi.service.Bom_maService;

@Controller
public class Bom_maController {
	
	@Inject
	private Bom_maService bom_maservice; 

}//end class
