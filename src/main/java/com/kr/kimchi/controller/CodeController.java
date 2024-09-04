package com.kr.kimchi.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kr.kimchi.service.CodeService;

@Controller
public class CodeController {
	
	@Inject
	private CodeService codeservice;
	
	@PostMapping(value = "code/codeInsert")
	public String codeInsert() {
		
		return "codeInsert";
	}//end
	

}//end class
