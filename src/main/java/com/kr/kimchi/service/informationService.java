package com.kr.kimchi.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kr.kimchi.dao.informationDAO;
import com.kr.kimchi.vo.IOVO;
import com.kr.kimchi.vo.IemailVo;
import com.kr.kimchi.vo.InlistVO;
import com.kr.kimchi.vo.ObtainVO;
import com.kr.kimchi.vo.StatusCheck;
import com.kr.kimchi.vo.transactionVO;

@Service
public class informationService {

	@Inject
	private informationDAO dao;

	// ����¡�ϱ�
	public List<InlistVO> pa_select(Map<String, Object> params) {
		return dao.pa_select(params);
	}

	public List<InlistVO> in_select() {
		return dao.in_select();
	}

	public int in_add(IOVO vo) {

		return dao.io_insert(vo);
	}

	public List<ObtainVO> modar_data() {

		return dao.modar_data();
	}

	public ObtainVO radio_value(ObtainVO vo) {

		return dao.radio_value(vo);
	}

	public int in_update_ob(int obtain_no) {

		return dao.in_update_ob(obtain_no);
	}

	// �˼� �Ϸ� �� �԰� + �ŷ����� ����
	public int io_status_change(int io_id) {

		return dao.io_status_change(io_id);
	}

	// �˼� �� �԰�+���緮
	public int material_io(StatusCheck value) {

		return dao.material_io(value);
	}

		// �ŷ����� ������ �ҷ�����
		public transactionVO transaction_statement(int obtain_no) {
			return dao.transaction_statement(obtain_no);
		}
	
		public IemailVo email_serch(int value) {
	
			return dao.email_serch(value);
		}

}