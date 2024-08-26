package com.kr.kimchi.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;

import com.kr.kimchi.service.ObtainService;

@Controller
public class ObtainController {
	
	@Inject
	private ObtainService obtservice;

}//end class
