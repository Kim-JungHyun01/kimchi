package com.kr.kimchi.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kr.kimchi.dao.ProductionDAO;

@Service
public class ProductionService {
	
	@Inject
	private ProductionDAO prodao;
	

}//end class
