package com.kr.kimchi.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kr.kimchi.dao.ItemDAO;

@Service
public class ItemService {
	
	@Inject
	private ItemDAO itemdao;
	

}//end class
