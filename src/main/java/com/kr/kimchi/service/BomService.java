package com.kr.kimchi.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kr.kimchi.dao.BomDAO;
import com.kr.kimchi.vo.BomVO;

@Service
public class BomService {
	
	@Inject
	private BomDAO bomdao;

//	bom정보_스케줄 보기
	public BomVO bomSelect(int item_no){
		return bomdao.bomSelect(item_no);
	}//end
	
//	bom정보_스케줄 추가
	public void bomInsert(BomVO bom) {
		bomdao.bomInsert(bom);
	}//end
	
//	bom정보_스케줄 수정
	public void bomUpdate(BomVO bom) {
		bomdao.bomUpdate(bom);
	}//end 
	
//	bom정보_스케줄 삭제
	public void bomDelete(int item_no) {
		bomdao.bomDelete(item_no);
	}//end
	
	
}//end class
