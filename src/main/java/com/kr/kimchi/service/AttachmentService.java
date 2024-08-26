package com.kr.kimchi.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kr.kimchi.dao.AttachmentDAO;

@Service
public class AttachmentService {
	
	@Inject
	private AttachmentDAO attdao;
	

}//end class
