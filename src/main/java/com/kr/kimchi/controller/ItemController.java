package com.kr.kimchi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kr.kimchi.service.*;
import com.kr.kimchi.vo.*;

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
	}// end

//	상품 상세보기 & bom정보_스케줄 보기
	@GetMapping(value = "item/itemSelect")
	public ModelAndView itemSelect(int item_no) {
		ItemVO item = itemservice.itemSelect(item_no);
		BomVO bom = bomservice.bomSelect(item_no);
		List<Bom_maVO> bom_malist = bom_maservice.bom_maSelect(item_no);
		List<MaterialVO> malist = maservice.maList(0, 10);
		ModelAndView mav = new ModelAndView();
		mav.addObject("item", item);
		mav.addObject("bom", bom);// bom 리스트
		mav.addObject("bom_malist", bom_malist);
		mav.addObject("malist", malist);
		mav.setViewName("item/itemSelect");
		return mav;
	}// end

//	상품추가_첨부파일 보기
	@GetMapping(value = "item/itemInsertForm")
	public ModelAndView itemInsertForm() {
		List<AttachmentVO> attlist = attservice.attachmentAll();
		ModelAndView mav = new ModelAndView();
		mav.addObject("attlist", attlist);
		mav.setViewName("item/itemInsertForm");
		return mav;
	}// end

	@PostMapping(value = "item/itemInsert")
	public String itemInsert(ItemVO item) {
		itemservice.itemInsert(item);
		return "redirect:/item/itemAll";
	}// end

//	상품수정
	@GetMapping(value = "item/itemUpdateForm")
	public ModelAndView itemUpdateForm(int item_no) {
		List<AttachmentVO> attlist = attservice.attachmentAll();
		ItemVO item =  itemservice.itemSelect(item_no);
		ModelAndView mav = new ModelAndView();
		mav.addObject("attlist", attlist);
		mav.addObject("item", item);
		mav.setViewName("item/itemUpdateForm");
		return mav;
	}// end

	@PostMapping(value = "item/itemUpdate")
	public String itemUpdate(ItemVO item) {
		itemservice.itemUpdate(item);
		return "redirect:/item/itemSelect?item_no=" + item.getItem_no();
	}// end

//	bom 정보추가
	@PostMapping(value = "item/bomInsert")
	public String bomInsert(BomVO bom) {
		bomservice.bomInsert(bom);
		return "redirect:/item/itemSelect?item_no=" + bom.getItem_no();
	}// end

//	bom 정보수정
	@PostMapping(value = "item/bomUpdate")
	public String bomUpdate(BomVO bom) {
		bomservice.bomUpdate(bom);
		return "redirect:/item/itemSelect?item_no=" + bom.getItem_no();
	}// end

//	bom정보_스케줄 삭제
	@GetMapping(value = "item/bomDelete")
	public String bomDelete(int item_no) {
		bom_maservice.bom_maDeleteAll(item_no);
		bomservice.bomDelete(item_no);
		return "redirect:/item/itemSelect?item_no=" + item_no;
	}// end

//	bom정보_자재 추가
	@PostMapping(value = "item/bom_maInsert")
	public String bom_maInsert(@RequestParam List<Integer> ma_id, @RequestParam List<Integer> bom_ma_amount,
			@RequestParam List<String> bom_ma_process, @RequestParam int item_no) {

		List<Bom_maVO> bom_malist = new ArrayList<Bom_maVO>();
		for (int i = 0; i < ma_id.size(); i++) {
			if (ma_id.get(i) != null) {
				Bom_maVO bom = new Bom_maVO();
				bom.setItem_no(item_no);
				bom.setMa_id(ma_id.get(i));
				bom.setBom_ma_amount(bom_ma_amount.get(i));
				bom.setBom_ma_process(bom_ma_process.get(i));
				bom_malist.add(bom);
			}
		} // end for

		System.out.println(bom_malist);
		bom_maservice.bom_maInsert(bom_malist);

		ItemVO item = new ItemVO();
		item.setItem_no(item_no);
		item.setItem_bomRegistered(1);
		itemservice.bomCheck(item);
		return "redirect:/item/itemSelect?item_no=" + item_no;
	}// end

//	bom정보_자재 수정
	@PostMapping(value = "item/bom_maUpdate")
	public String bom_maUpdate(@RequestParam List<Integer> ma_id, @RequestParam List<Integer> bom_ma_amount,
			@RequestParam List<String> bom_ma_process, @RequestParam int item_no) {
		
		bom_maservice.bom_maDeleteAll(item_no);
		
		List<Bom_maVO> bom_malist = new ArrayList<Bom_maVO>();
		for (int i = 0; i < ma_id.size(); i++) {
			if (ma_id.get(i) != null) {
				Bom_maVO bom = new Bom_maVO();
				bom.setItem_no(item_no);
				bom.setMa_id(ma_id.get(i));
				bom.setBom_ma_amount(bom_ma_amount.get(i));
				bom.setBom_ma_process(bom_ma_process.get(i));
				bom_malist.add(bom);
			}
		} // end for

		System.out.println(bom_malist);
		bom_maservice.bom_maInsert(bom_malist);
		
		
		return "redirect:/item/itemSelect?item_no=" + item_no;
	}//end
	
	
}//end class
