package kr.co.kim.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.kim.vo.IOVO;
import kr.co.kim.vo.ObtainVO;
import kr.co.kim.vo.UserVO;

@Repository
public class imformationDAO {
	
	private final static String namespaces="kr.co.kim.mappers.io_imformationMapper";
	
	@Inject
	private SqlSession Session;
	
	//조회
	
	
	//입고 추가
	public int io_insert(IOVO vo) {
		
		return Session.insert(namespaces+".io_add", vo);
	}
	
	// 조달계획에 조달중인 데이터 불러오기(모달창)
	public List<ObtainVO> modar_data(){
		
		return Session.selectList(namespaces+".obtain_malist");
	}
	
	//json radio 값 불러오기
	public ObtainVO radio_value(ObtainVO vo) {
		
		return Session.selectOne(namespaces+".radio_value", vo);
	}
	
	//입고 후 검수중-> 입고 완료 변경
	public int io_status_change(IOVO value) {
		
		return Session.update(namespaces+".io_status_change", value);
	}
	
	//입고 완료되면 발주 담당자 이메일 찾기
	public UserVO email_serch(int value){
		
		return Session.selectOne(namespaces+".io_OK_email", value);
	}
	
}
