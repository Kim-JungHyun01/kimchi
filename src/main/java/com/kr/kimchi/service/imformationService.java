package kr.co.kim.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.kim.dao.imformationDAO;
import kr.co.kim.vo.IOVO;
import kr.co.kim.vo.ObtainVO;

@Service
public class imformationService {
	
	@Inject
	private imformationDAO dao;
	
	public int in_add(IOVO vo) {
		
		return dao.io_insert(vo);
	}
	
	public List<ObtainVO> modar_data(){
		
		return dao.modar_data();
	}
	
	public ObtainVO radio_value(ObtainVO vo) {
		
		return dao.radio_value(vo);
	}
	
	
	
	

}