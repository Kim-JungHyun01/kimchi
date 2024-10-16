package com.kr.kimchi.service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kr.kimchi.dao.CodeDAO;
import com.kr.kimchi.vo.CodeVO;
import com.kr.kimchi.vo.ContractsVO;
import com.kr.kimchi.vo.ObtainVO;
import com.kr.kimchi.vo.ProductionVO;

@Service
public class CodeService {

	@Inject
	private CodeDAO codedao;
	@Inject
	private ProductionService proservice;

//	코드추가
	public CodeVO codeInsert(CodeVO code) {
		codedao.codeInsert(code);
		return code;
	}// end

//	코드삭제
	public void codeDelete(int code_id) {
		codedao.codeDelete(code_id);
	}// end

	public CodeVO contractsCode(ContractsVO con) {
		CodeVO code = new CodeVO();
		String inputDate = con.getContracts_registrationDate();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime datetime = LocalDateTime.parse(inputDate, formatter);

		// 연도와 월일을 문자열로 포맷
		String year = String.valueOf(datetime.getYear());
		String monthDay = String.format("%02d%02d", datetime.getMonthValue(), datetime.getDayOfMonth());

//		ca_id= 1일때 계약서
//		ca_id : 1 : 계약서 2:  거래명세서 3 : 구매 발주서
		code.setCa_id(1);
//		code_name = (년)(계약서id)(생산계획id)(조달계획id)(월)(일)
		String codeStr = year + con.getContracts_no() + "0" + "0" + monthDay;
		code.setCode_name(codeStr);
		return code;
	}// end

	public CodeVO obtainCode(ObtainVO obtain) {
		ProductionVO pro = proservice.productionSelect(obtain.getProduction_no());
		
		CodeVO code = new CodeVO();
		Date inputDate = obtain.getObtain_registrationDate();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = sdf.format(inputDate);

		// 연도와 월일을 분리
		String year = formattedDate.substring(0, 4);//yyyy
		String monthDay = formattedDate.substring(5, 7) + formattedDate.substring(8, 10);//MMdd
//		ca_id : 1 : 계약서 2:  거래명세서 3 : 구매 발주서
		code.setCa_id(2);
//		code_name = (년)(계약서id)(생산계획id)(조달계획id)(월)(일)
		String conid = Integer.toString(pro.getContracts_no());
		String proid = Integer.toString(obtain.getProduction_no());
		String obid = Integer.toString(obtain.getObtain_no());
		String codeStr = year +conid+proid+obid+monthDay;
		code.setCode_name(codeStr);
		return code;
	}// end

}// end class
