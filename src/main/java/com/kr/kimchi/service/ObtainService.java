package com.kr.kimchi.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kr.kimchi.dao.ObtainDAO;
import com.kr.kimchi.vo.ObtainVO;

@Service
public class ObtainService {
	
	@Inject
	private ObtainDAO obtaindao;


	public List<ObtainVO> obtainAll() {
		return obtaindao.obtainAll();
	}// end

	public ObtainVO obtainSelect(int obtain_no) {
		return obtaindao.obtainSelect(obtain_no);
	}// end

	public void obtainInsert(ObtainVO obt) {
		obtaindao.obtainInsert(obt);
	}// end

	public void obtainUpdate(ObtainVO obt) {
		obtaindao.obtainUpdate(obt);
	}// end

	public void obtainCheck(ObtainVO obt) {
		obtaindao.obtainCheck(obt);
	}// end
	
	public void obtainPa(int obtain_no) {
		obtaindao.obtainPa(obtain_no);
	}
	
	public List<ObtainVO> obSelectList() {
		return obtaindao.obSelectList();
	}// end
	
}//end class
