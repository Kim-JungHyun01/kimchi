package com.kr.kimchi.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kr.kimchi.dao.ContractsDAO;
import com.kr.kimchi.vo.ContractsVO;

@Service
public class ContractsService {
	
	@Inject
	private ContractsDAO condao;
	
//	계약 보기_전체
	public List<ContractsVO> contractsAll(Map<String, Object> conlist){
		return condao.contractsAll(conlist);
	}//end
	
//	계약 보기_상세 
	public ContractsVO contractsSelect(int contracts_no) {
		return condao.contractsSelect(contracts_no);
	}//end
	
//	계약 추가
	public void contractsInsert(ContractsVO contr) {
		condao.contractsInsert(contr);
	}//end
	
//	계약 수정_계약갯수, 계약가격, 납기일, 상새내역
	public void contractsUpdate(ContractsVO contr) {
		condao.contractsUpdate(contr);
	}//end
	
//	계약 승인 & 취소
	public void contractsCheck(ContractsVO contr) {
		condao.contractsCheck(contr);
	}//end
	

}//end class
