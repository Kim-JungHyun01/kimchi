package com.kr.kimchi.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kr.kimchi.dao.ChartDAO;
import com.kr.kimchi.vo.MaterialVO;

@Service
public class ChartService {

	@Inject
	private ChartDAO chartdao;
	
	public List<MaterialVO> machart(String startDate, String endDate) {
	    return chartdao.machart(startDate, endDate);
	}
	//=================
}
