package com.kr.kimchi.service;


import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kr.kimchi.dao.PaPopDAO;
import com.kr.kimchi.vo.PaVO;


@Service
public class PaPopService {
	
	@Inject
	private PaPopDAO dao;
	
	public PaVO paPopList(int pa_no) {
		return dao.paPopList(pa_no);
	}

}
