package com.kr.kimchi.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kr.kimchi.vo.ProductionVO;

@Repository
public class ProductionDAO {

	private final static String namespace="com.kr.kimchi.mappers.productionMapper";
	
	@Inject
	private SqlSession session;
	
//	생산계획 보기_전체
	public List<ProductionVO> productionAll(){
		return session.selectList(namespace+".productionAll");
	}//end
	
//	생산계획 보기_상세
	public ProductionVO productionSelect(int production_no) {
		return session.selectOne(namespace+".productionSelect", production_no);
	}//end
	
//	생산계획 추가
	public void productionInsert(ProductionVO pro) {
		session.selectOne(namespace+".productionInsert", pro);
	}//end
	
//	생산계획 수정_생산량, 생산납기
	public void productionUpdate(ProductionVO pro) {
		session.selectOne(namespace+".productionUpdate", pro);
	}//end
	
//	생산계획 승인여부
	public void productionCheck(ProductionVO pro) {
		session.selectOne(namespace+".productionCheck", pro);
	}//end
	
	
}//end class
