package kr.co.kim.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.kim.vo.MaterialVO;

@Repository
public class invenDAO {
	
	@Inject
	private SqlSession Session;
	
	private final static String namespaces="kr.co.kim.mappers.matrial_invenMapper";
	
	public List<MaterialVO> ma_list(){//전체 자재검색
		
		return Session.selectList(namespaces+".material_all");
	}
	
	public MaterialVO ma_serch(String value) {//상세 자재검색
		
		return Session.selectOne(namespaces+".material_serch", value);
	}
	
	
	
	public Map<String, Object> detail(String id){//자재 상세보기
		
		return Session.selectOne(namespaces+".material_detail", id);
	}
	
	public int ma_insert(MaterialVO vo) {//자재추가
		
		return Session.insert(namespaces+".material_add", vo);
	}
	
	
	


}
