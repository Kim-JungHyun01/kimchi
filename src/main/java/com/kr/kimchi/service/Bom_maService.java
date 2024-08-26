package com.kr.kimchi.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kr.kimchi.dao.Bom_maDAO;

@Service
public class Bom_maService {
	
	@Inject
	private Bom_maDAO bom_madao;

}//end class
