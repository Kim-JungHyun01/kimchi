package com.kr.kimchi.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kr.kimchi.vo.ContractsVO;

@Repository
public class ContractsDAO {
	
	private final static String namespace = "com.kr.kimchi.mappers.contractsMapper";

	@Inject
	private SqlSession session;
	
//	계약 보기_전체
	public List<ContractsVO> contractsAll(){
		return session.selectList(namespace+".contractsAll");
	}//end
	
//	계약 보기_상세 
	public ContractsVO contractsSelect(int contracts_no) {
		return session.selectOne(namespace+".contractsSelect", contracts_no);
	}//end
	
//	계약 추가
	public void contractsInsert(ContractsVO contr) {
		session.selectOne(namespace+".contractsInsert", contr);
	}//end
	
//	계약 수정_계약갯수, 계약가격, 납기일, 상새내역
	public void contractsUpdate(ContractsVO contr) {
		session.selectOne(namespace+".contractsUpdate", contr);
	}//end
	
//	계약 승인 & 취소
	public void contractsCheck(ContractsVO contr) {
		session.selectOne(namespace+".contractsCheck", contr);
	}//end
	
//	계약서 보기
	public String documentView(int ca_id, int pa_referenceNo) {
		return session.selectOne(namespace+".documentView");
	}//end

}// end class
