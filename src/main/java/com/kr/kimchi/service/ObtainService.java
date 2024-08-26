package com.kr.kimchi.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kr.kimchi.dao.ObtainDAO;
import com.kr.kimchi.vo.ObtainVO;

@Service
public class ObtainService {
	
	@Inject
	private ObtainDAO obtaindao;


//	조달계획 보기_전체
	public List<ObtainVO> obtainAll(Map<String, Object> oblist) {
		return obtaindao.obtainAll(oblist);
	}// end

//	조달계획 보기_상세
	public ObtainVO obtainSelect(int obtain_no) {
		return obtaindao.obtainSelect(obtain_no);
	}// end

//	조달계획 추가
	public void obtainInsert(ObtainVO obt) {
		obtaindao.obtainInsert(obt);
	}// end

//	조달계획 수정
	public void obtainUpdate(ObtainVO obt) {
		obtaindao.obtainUpdate(obt);
	}// end

//	조달계획 승인 
	public void obainCheck(ObtainVO obt) {
		obtaindao.obainCheck(obt);
	}// end
	
	
}//end class
