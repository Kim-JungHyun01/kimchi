package com.kr.kimchi.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kr.kimchi.dao.CodeDAO;

@Service
public class CodeService {
	
	@Inject
	private CodeDAO codedao;
	

}//end class
