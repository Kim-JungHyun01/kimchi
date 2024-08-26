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
	private PaDAO padao;
	
	public List<PaVO> paList(Map<String, Object> params) {
		return padao.paList(params);
	}
	
	public List<PaVO> paAllList(){
		return padao.paAllList();
	}
	
	
//	 페이퍼 추가
	public void paInsert(PaVO pa) {
		padao.paInsert(pa);
	}//end
	
//	 페이퍼 수정
	public void paUpdate(PaVO pa) {
		padao.paUpdate(pa);
	}//end
	
//	페이처 체크
	public void paCheck(PaVO pa) {
		padao.paCheck(pa);
	}//end
	
}//end class
