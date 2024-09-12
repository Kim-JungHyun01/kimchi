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
	public List<ObtainVO> obtainAll(int startRow, int pageSize) {
		return obtaindao.obtainAll(startRow, pageSize);
	}// end
	
//	전체 레코드 수
    public Integer getTotalCount() {
		return obtaindao.getTotalCount();   	
    }//end

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
