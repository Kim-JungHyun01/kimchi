package com.kr.kimchi.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kr.kimchi.vo.IOVO;
import com.kr.kimchi.vo.IemailVo;
import com.kr.kimchi.vo.InlistVO;
import com.kr.kimchi.vo.ObtainVO;
import com.kr.kimchi.vo.StatusCheck;
import com.kr.kimchi.vo.transactionVO;

@Repository
public class informationDAO {
	
	private final static String namespaces="kr.co.kimchi.mappers.io_informationMapper";
	
	@Inject
	private SqlSession Session;
	
	//페이징하기
	public List<InlistVO> pa_select(Map<String, Object> params){
		
		
		
		return Session.selectList(namespaces+".io-list-paging", params);
	}
	
	//입출고 정보 리스트 조회
	public List<InlistVO> in_select(){
		return Session.selectList(namespaces+".io-list-all");
	}
	
	//입고 추가
	public int io_insert(IOVO vo) {
		
		return Session.insert(namespaces+".io_add", vo);
	}
	
	//입고 추가시 조달계획에서 상태 조달완료로 변경
	public int in_update_ob(int obtain_no) {
		
		return Session.update(namespaces+".obtain_status", obtain_no);
	}
	// 모달 조달리스트 출력(조달중)
	public List<ObtainVO> modar_data(){
		
		return Session.selectList(namespaces+".obtain_malist");
	}
	
	//json radio이거는 뭔지 모름
	public ObtainVO radio_value(ObtainVO vo) {
		
		return Session.selectOne(namespaces+".radio_value", vo);
	}
	
	//검수 완료 시 입고 + 거래명세서 발행 
	public int io_status_change(int io_id) {
		
		return Session.update(namespaces+".io_status_change", io_id);
	}
	// 검수 시 입고량+자재량
	public int material_io(StatusCheck value) {
		
		return Session.update(namespaces+".materia_io", value);
	}
	
	//검수 완료 시 거래명세서 담장자에게 이메일 발송
	public IemailVo email_serch(int obtain_no){
		
		return Session.selectOne(namespaces+".io_OK_email", obtain_no);
	}
	
	//거래명세서 데이터 불러오기
	public transactionVO transaction_statement(int obtain_no){
		return Session.selectOne(namespaces+".transaction_statement", obtain_no);
	}
	
}
