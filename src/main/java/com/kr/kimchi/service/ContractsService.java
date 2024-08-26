package com.kr.kimchi.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kr.kimchi.dao.ContractsDAO;

@Service
public class ContractsService {
	
	@Inject
	private ContractsDAO condao;

}//end class
