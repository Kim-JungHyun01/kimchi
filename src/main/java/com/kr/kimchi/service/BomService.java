package com.kr.kimchi.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kr.kimchi.dao.BomDAO;

@Service
public class BomService {
	
	@Inject
	private BomDAO bomdao;

}//end class
