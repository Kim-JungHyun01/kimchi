package com.kr.kimchi.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kr.kimchi.dao.ObtainDAO;

@Service
public class ObtainService {
	
	@Inject
	private ObtainDAO obtaindao;

}//end class
