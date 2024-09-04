package com.kr.kimchi.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kr.kimchi.vo.IOVO;
import com.kr.kimchi.vo.ObtainVO;
import com.kr.kimchi.vo.UserVO;

@Repository
public class imformationDAO {
	
	private final static String namespaces="kr.co.kim.mappers.io_imformationMapper";
	
	@Inject
	private SqlSession Session;
	
	//��ȸ
	
	
	//�԰� �߰�
	public int io_insert(IOVO vo) {
		
		return Session.insert(namespaces+".io_add", vo);
	}
	
	// ���ް�ȹ�� �������� ������ �ҷ�����(���â)
	public List<ObtainVO> modar_data(){
		
		return Session.selectList(namespaces+".obtain_malist");
	}
	
	//json radio �� �ҷ�����
	public ObtainVO radio_value(ObtainVO vo) {
		
		return Session.selectOne(namespaces+".radio_value", vo);
	}
	
	//�԰� �� �˼���-> �԰� �Ϸ� ����
	public int io_status_change(IOVO value) {
		
		return Session.update(namespaces+".io_status_change", value);
	}
	
	//�԰� �Ϸ�Ǹ� ���� ����� �̸��� ã��
	public UserVO email_serch(int value){
		
		return Session.selectOne(namespaces+".io_OK_email", value);
	}
	
}
