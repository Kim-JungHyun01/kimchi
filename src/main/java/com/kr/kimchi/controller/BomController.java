package com.kr.kimchi.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;

import com.kr.kimchi.service.BomService;

@Controller
public class BomController {
	
	@Inject
	private BomService bomservice;

}// end class
