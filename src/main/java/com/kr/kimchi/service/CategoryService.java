package com.kr.kimchi.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kr.kimchi.dao.CategoryDAO;

@Service
public class CategoryService {
	
	@Inject
	private CategoryDAO catedao;

}//end class
