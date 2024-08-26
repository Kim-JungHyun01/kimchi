package com.kr.kimchi.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;

import com.kr.kimchi.service.CodeService;

@Controller
public class CodeController {
	
	@Inject
	private CodeService codeservice;

}//end class
