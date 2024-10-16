package com.kr.kimchi.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kr.kimchi.vo.MaterialVO;

@Repository
public class invenDAO {
	
	@Inject
	private SqlSession Session;
	
	private final static String namespaces="kr.co.kim.mappers.matrial_invenMapper";
	
	public List<MaterialVO> ma_list(){//��ü ����˻�
		
		return Session.selectList(namespaces+".material_all");
	}
	
	public MaterialVO ma_serch(String value) {//�� ����˻�
		
		return Session.selectOne(namespaces+".material_serch", value);
	}
	
	
	
	public Map<String, Object> detail(String id){//���� �󼼺���
		
		return Session.selectOne(namespaces+".material_detail", id);
	}
	
	public int ma_insert(MaterialVO vo) {//�����߰�
		
		return Session.insert(namespaces+".material_add", vo);
	}
	
	
	


}
