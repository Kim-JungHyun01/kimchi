package com.kr.kimchi.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kr.kimchi.dao.CategoryDAO;
import com.kr.kimchi.vo.CategoryVO;

@Service
public class CategoryService {
	
	@Inject
	private CategoryDAO catedao;

	public List<CategoryVO> cateAll(){
		return catedao.cateAll();
	}//end
	
}//end class
