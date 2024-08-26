package com.kr.kimchi.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;

import com.kr.kimchi.service.AttachmentService;

@Controller
public class AttachmentController {
	
	@Inject
	private AttachmentService attservice;

}//end class
