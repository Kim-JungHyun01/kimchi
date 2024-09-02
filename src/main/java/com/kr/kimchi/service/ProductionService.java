package com.kr.kimchi.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kr.kimchi.dao.ProductionDAO;
import com.kr.kimchi.vo.ProductionVO;

@Service
public class ProductionService {

	@Inject
	private ProductionDAO prodao;

//	생산계획 보기_전체
	public List<ProductionVO> productionAll() {
		return prodao.productionAll();
	}// end

//	생산계획 보기_상세
	public ProductionVO productionSelect(int production_no) {
		return prodao.productionSelect(production_no);
	}// end

//	생산계획 추가
	public void productionInsert(ProductionVO pro) {
		prodao.productionInsert(pro);
	}// end

//	생산계획 수정_생산량, 생산납기
	public void productionUpdate(ProductionVO pro) {
		prodao.productionUpdate(pro);
	}// end

//	생산계획 승인여부
	public void productionCheck(ProductionVO pro) {
		prodao.productionCheck(pro);
	}// end

}// end class
