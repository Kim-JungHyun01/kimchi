package com.kr.kimchi.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;

import com.kr.kimchi.service.ItemService;

@Controller
public class ItemController {
	
	@Inject
	private ItemService itemservice;

}//end class
