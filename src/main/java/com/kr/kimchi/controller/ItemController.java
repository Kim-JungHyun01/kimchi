package com.kr.kimchi.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kr.kimchi.service.AttachmentService;
import com.kr.kimchi.service.BomService;
import com.kr.kimchi.service.Bom_maService;
import com.kr.kimchi.service.ItemService;
import com.kr.kimchi.service.MaterialService;
import com.kr.kimchi.vo.AttachmentVO;
import com.kr.kimchi.vo.BomVO;
import com.kr.kimchi.vo.Bom_maVO;
import com.kr.kimchi.vo.ItemVO;
import com.kr.kimchi.vo.MaterialVO;


@Controller
public class ItemController {
	
	@Inject
	private ItemService itemservice;
	@Inject
	private BomService bomservice;
	@Inject
	private Bom_maService bom_maservice;
	@Inject
	private AttachmentService attservice;
	@Inject
	private MaterialService maservice;
	
//	상품 전체보기
	@GetMapping(value = "item/itemAll")
	public ModelAndView itemAll() {
		List<ItemVO> itemlist = itemservice.itemAll();
		ModelAndView mav = new ModelAndView();
		mav.addObject("itemlist", itemlist);
		mav.setViewName("item/itemAll");
		return mav;
	}//end
	
//	상품 상세보기 & bom정보_스케줄 보기
	@GetMapping(value ="item/itemSelect")
	public ModelAndView itemSelect(int item_no) {
		ItemVO item = itemservice.itemSelect(item_no);
		BomVO bom = bomservice.bomSelect(item_no);
		List<Bom_maVO> bom_malist = bom_maservice.bom_maSelect(item_no);
		List<MaterialVO> malist = maservice.maList(0, 10);
		ModelAndView mav = new ModelAndView();
		mav.addObject("item", item);
		mav.addObject("bom", bom);//bom 리스트
		mav.addObject("bom_malist", bom_malist);
		mav.addObject("malist", malist);
		mav.setViewName("item/itemSelect");
		return mav;
	}//end
	
//	상품추가_첨부파일 보기
	@GetMapping(value = "item/itemInsertForm")
	public ModelAndView itemInsertForm() {
		List<AttachmentVO> attlist = attservice.attachmentAll();
		ModelAndView mav = new ModelAndView();
		mav.addObject("attlist", attlist);
		mav.setViewName("item/itemInsertForm");
		return mav;
	}//end
	
	@PostMapping(value="item/itemInsert")
	public String itemInsert(ItemVO item) {
		itemservice.itemInsert(item);
		return "redirect:/item/itemAll";
	}//end
	
//	상품수정
	@GetMapping(value = "item/itemUpdateForm")
	public ModelAndView itemUpdateForm(int item_no) {
		ModelAndView mav = itemSelect(item_no);
		mav.setViewName("item/itemUpdateForm");
		return mav;
	}//end
	
	@PostMapping(value="item/itemUpdate")
	public String itemUpdate(ItemVO item) {
		itemservice.itemUpdate(item);
		return "redirect:/item/itemSelect?item_no="+item.getItem_no();
	}//end
	
	
	
	

}//end class
