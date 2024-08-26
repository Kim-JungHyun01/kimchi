package com.kr.kimchi.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kr.kimchi.dao.Bom_maDAO;
import com.kr.kimchi.vo.Bom_maVO;

@Service
public class Bom_maService {
	
	@Inject
	private Bom_maDAO bom_madao;

//	bom정보 보기_물품별
	public List<Bom_maVO> bom_maSelect(int item_no){
		return bom_madao.bom_maSelect(item_no);
	}//end
	
//	bom정보_자재 추가
	public void bom_maInsert(Bom_maVO bom_ma) {
		bom_madao.bom_maInsert(bom_ma);
	}//end
	
//	bom정도_자재 수정 
	public void bom_maUpdate(Bom_maVO bom_ma) {
		bom_madao.bom_maUpdate(bom_ma);
	}//end
	
//	bom정보_자재 선택적삭제
	public void bom_maDeleteSelect(int item_no, int ma_id) {
		bom_madao.bom_maDeleteSelect(item_no, ma_id);
	}//end
	
//	bom정보_자재 삭제(bom & item 삭제시)
	public void bom_maDeleteAll(int item_no) {
		bom_madao.bom_maDeleteAll(item_no);
	}//end
	
	
}//end class
