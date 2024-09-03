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


//	조달계획 보기_전체
	public List<ObtainVO> obtainAll() {
		return obtaindao.obtainAll();
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
	public void obtainCheck(ObtainVO obt) {
		obtaindao.obtainCheck(obt);
	}// end
	
	
}//end class
