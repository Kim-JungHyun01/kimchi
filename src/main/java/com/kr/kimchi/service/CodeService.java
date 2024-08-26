package com.kr.kimchi.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kr.kimchi.dao.CodeDAO;
import com.kr.kimchi.vo.CodeVO;

@Service
public class CodeService {

	@Inject
	private CodeDAO codedao;

//	코드추가
	public void codeInsert(CodeVO code) {
		codedao.codeInsert(code);
	}// end

//	코드삭제
	public void codeDelete(int code_id) {
		codedao.codeDelete(code_id);
	}// end

}// end class
