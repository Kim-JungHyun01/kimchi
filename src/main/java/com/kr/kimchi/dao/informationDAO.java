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
	
	//����¡�ϱ�
	public List<InlistVO> pa_select(Map<String, Object> params){
		
		
		
		return Session.selectList(namespaces+".io-list-paging", params);
	}
	
	//����� ���� ����Ʈ ��ȸ
	public List<InlistVO> in_select(){
		return Session.selectList(namespaces+".io-list-all");
	}
	
	//�԰� �߰�
	public int io_insert(IOVO vo) {
		
		return Session.insert(namespaces+".io_add", vo);
	}
	
	//�԰� �߰��� ���ް�ȹ���� ���� ���޿Ϸ�� ����
	public int in_update_ob(int obtain_no) {
		
		return Session.update(namespaces+".obtain_status", obtain_no);
	}
	// ��� ���޸���Ʈ ���(������)
	public List<ObtainVO> modar_data(){
		
		return Session.selectList(namespaces+".obtain_malist");
	}
	
	//json radio�̰Ŵ� ���� ��
	public ObtainVO radio_value(ObtainVO vo) {
		
		return Session.selectOne(namespaces+".radio_value", vo);
	}
	
	//�˼� �Ϸ� �� �԰� + �ŷ����� ���� 
	public int io_status_change(int io_id) {
		
		return Session.update(namespaces+".io_status_change", io_id);
	}
	// �˼� �� �԰�+���緮
	public int material_io(StatusCheck value) {
		
		return Session.update(namespaces+".materia_io", value);
	}
	
	//�˼� �Ϸ� �� �ŷ����� �����ڿ��� �̸��� �߼�
	public IemailVo email_serch(int obtain_no){
		
		return Session.selectOne(namespaces+".io_OK_email", obtain_no);
	}
	
	//�ŷ����� ������ �ҷ�����
	public transactionVO transaction_statement(int obtain_no){
		return Session.selectOne(namespaces+".transaction_statement", obtain_no);
	}
	
}
