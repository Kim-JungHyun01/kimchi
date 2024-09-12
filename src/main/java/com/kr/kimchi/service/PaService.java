package com.kr.kimchi.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kr.kimchi.dao.PaDAO;
import com.kr.kimchi.vo.CodeVO;
import com.kr.kimchi.vo.PaVO;

@Service
public class PaService {
	
	@Inject
	private PaDAO padao;
	
	public List<PaVO> paList(Map<String, Object> params) {
		return padao.paList(params);
	}
	
	public List<PaVO> paAllList(int pa_checkStatus){
		return padao.paAllList(pa_checkStatus);
	}
	
	public void paCode(String code) {
		padao.paCode(code);
	}
	
	public int paCodeSelecet(String code_name) {
		return padao.paCodeSelecet(code_name);
	}
	
	public void paPlus(Map<String, Object> map) {
		padao.paPlus(map);
	}
	
	public void prpFinsh(int pa_no ) {
		padao.prpFinsh(pa_no);
	}
	
	public void prpIng(int pa_no ) {
		padao.prpIng(pa_no);
	}
	
	public void paInsert(PaVO pa) {
		padao.paInsert(pa);
	}//end
	
	public void paUpdate(PaVO pa) {
		padao.paUpdate(pa);
	}//end
	
	public void paCheck(int pa_no) {
		padao.paCheck(pa_no);
	}//end
	
	public PaVO paSelect(Map<String, Object> params){
		return padao.paSelect(params);
	}//end
	
}//end class
