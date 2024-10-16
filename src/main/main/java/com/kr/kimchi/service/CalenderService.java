package com.kr.kimchi.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kr.kimchi.dao.AttachmentDAO;
import com.kr.kimchi.dao.CalenderDAO;
import com.kr.kimchi.vo.AttachmentVO;
import com.kr.kimchi.vo.CalenderVO;

@Service
public class CalenderService {
	
	@Inject
	private CalenderDAO dao;
	
	public List<CalenderVO> calenderList(){
		return dao.calenderList();
	}

}
