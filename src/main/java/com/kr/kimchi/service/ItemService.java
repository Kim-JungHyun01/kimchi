package com.kr.kimchi.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kr.kimchi.dao.ItemDAO;
import com.kr.kimchi.vo.ItemVO;

@Service
public class ItemService {
	
	@Inject
	private ItemDAO itemdao;
	
//	제품정보(전체)
	public List<ItemVO> itemAll() {
		return itemdao.itemAll();
	}//end
	
//	제품정보(상세)
	public ItemVO itemSelect(int item_no){
		return itemdao.itemSelect(item_no);
	}//end
	
//	제품정보추가
	public void itemInsert(ItemVO item) {
		itemdao.itemInsert(item);
	}//end
	
//	제품정보 수정
	public void itemUpdate(ItemVO item) {
		itemdao.itemUpdate(item);
	}//end
	
//	제품 bom등록여부수정
	public void bomCheck(ItemVO item) {
		itemdao.bomCheck(item);
	}//end
	
//	제품삭제
	public void itemDelete(int item_no) {
		itemdao.itemDelete(item_no);
	}//end

}//end class
