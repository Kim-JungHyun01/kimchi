package com.kr.kimchi.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kr.kimchi.dao.informationDAO;
import com.kr.kimchi.vo.IOVO;
import com.kr.kimchi.vo.InlistVO;
import com.kr.kimchi.vo.ObtainVO;
import com.kr.kimchi.vo.StatusCheck;
import com.kr.kimchi.vo.transactionVO;

@Service
public class informationService {
	
	@Inject
	private informationDAO dao;
	
	//페이징하기
		public List<InlistVO> pa_select(Map<String, Object> params){
			return dao.pa_select(params);
		}
	
	public List<InlistVO> in_select(){
		return dao.in_select();
	}
	
	public int in_add(IOVO vo) {
		
		return dao.io_insert(vo);
	}
	
	public List<ObtainVO> modar_data(){
		
		return dao.modar_data();
	}
	
	public ObtainVO radio_value(ObtainVO vo) {
		
		return dao.radio_value(vo);
	}
	
	public int in_update_ob(int obtain_no) {
		
		return dao.in_update_ob(obtain_no);
	}
	
	//검수 완료 시 입고 + 거래명세서 발행 
	public int io_status_change(int io_id) {
			
		return dao.io_status_change(io_id);
	}
		
	// 검수 시 입고량+자재량
	public int material_io(StatusCheck value) {
			
		return dao.material_io(value);
	}
	
	//거래명세서 데이터 불러오기
		public transactionVO transaction_statement(int obtain_no){
			return dao.transaction_statement(obtain_no);
		}


	
	
	
	

}