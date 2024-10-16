package com.kr.kimchi.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kr.kimchi.dao.PrpDAO;
import com.kr.kimchi.dao.PrpDetailPopDAO;
import com.kr.kimchi.vo.PrpVO;

@Service
public class PrpDetailPopService {
	
	@Inject
	private PrpDetailPopDAO dao;
	
	
	
	public PrpVO prpPopData(int prp_no){
		return dao.prpPopData(prp_no);
	}
	
	public void prpUpdate(Map<String, Object> map){
		dao.prpUpdate(map);
	}
	
	
}
