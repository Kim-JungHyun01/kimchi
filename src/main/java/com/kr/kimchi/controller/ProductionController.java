package com.kr.kimchi.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;

import com.kr.kimchi.service.ProductionService;

@Controller
public class ProductionController {

	@Inject
	private ProductionService proservice;
	
	
}//end class
