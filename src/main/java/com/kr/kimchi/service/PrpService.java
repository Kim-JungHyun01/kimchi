package com.kr.kimchi.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kr.kimchi.dao.PrpDAO;
import com.kr.kimchi.vo.PrpVO;

@Service
public class PrpService {
	
	@Inject
	private PrpDAO dao;
	
	
	
	public void prpInsert(PrpVO prpVO){
		dao.prpInsert(prpVO);
	}
	
	public List<PrpVO> prpList(int pa_no){
		return dao.prpList(pa_no);
	}
}
