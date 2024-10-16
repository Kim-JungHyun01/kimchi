package com.kr.kimchi.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;

import com.kr.kimchi.service.CategoryService;

@Controller
public class CategoryController {
	
	@Inject
	private CategoryService cateservice;

}//end class
