package com.kr.kimchi.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kr.kimchi.dao.PaDAO;
import com.kr.kimchi.vo.PaVO;

@Service
public class PaService {
	
	@Inject
	private PaDAO podao;
	
	public List<PaVO> paList(Map<String, Object> params) {
		return podao.paList(params);
	}
	
	public List<PaVO> paAllList(){
		return podao.paAllList();
	}
}
