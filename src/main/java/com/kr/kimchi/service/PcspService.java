package com.kr.kimchi.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kr.kimchi.dao.PaDAO;
import com.kr.kimchi.dao.PcspDAO;
import com.kr.kimchi.vo.CodeVO;
import com.kr.kimchi.vo.PaVO;
import com.kr.kimchi.vo.PcspVO;

@Service
public class PcspService {
	
	@Inject
	private PcspDAO dao;
	
	public List<PcspVO> pcspList(String partner_taxid) {
		return dao.pcspList(partner_taxid);
	}
	
	public void pcspInsert(PcspVO pcspVO) {
		dao.pcspInsert(pcspVO);
	}
	
}//end class
