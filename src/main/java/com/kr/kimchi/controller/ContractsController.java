package com.kr.kimchi.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;

import com.kr.kimchi.service.ContractsService;

@Controller
public class ContractsController {
	
	@Inject
	private ContractsService conservice;

}//end class
