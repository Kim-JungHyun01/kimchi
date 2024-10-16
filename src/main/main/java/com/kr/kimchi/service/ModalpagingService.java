package com.kr.kimchi.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.kr.kimchi.vo.ContractsVO;
import com.kr.kimchi.vo.ItemVO;
import com.kr.kimchi.vo.PaginationVO;
import com.kr.kimchi.vo.PartnerVO;
import com.kr.kimchi.vo.UserVO;

@Service
public class ModalpagingService {
	
	@Inject
	private ItemService itemservice;
	@Inject
	private PartnerService partnerservice;
	@Inject
	private UserService userservice;
	@Inject
	private ContractsService contractservice;
	
	// 담당자 페이징
	public ModelAndView userpaging(int pageNum, String user_name, String user_department) {

		int pageSize = 10; // 한 페이지에 보여줄 갯수
		int pageNavSize = 5; // 페이지 네비 크기
		int startRow = (pageNum - 1) * pageSize; // 시작페이지 계산
		Integer totalCount = userservice.getTotalCount(); // 총 레코드 수 가져옴
		List<UserVO> userlist = userservice.userAll(startRow, pageSize, user_name, user_department);// 조건에 맞는 user정보만
																									// 가져옴
		Integer totalPages = userservice.userSearch(pageSize, user_name, user_department); // 검색 이후 레코드수 계산
		PaginationVO pagination = new PaginationVO(pageNum, totalCount, pageSize, pageNavSize);

		ModelAndView mav = new ModelAndView();
		mav.addObject("user_pagination", pagination);
		mav.addObject("user_currentPage", pageNum);
		mav.addObject("user_totalPages", totalPages);
		mav.addObject("userlist", userlist);
		return mav;
	}// end
	
	//물품페이징
	public ModelAndView itempaging(int pageNum, String item_name) {
		
		int pageSize = 10; // 한 페이지에 보여줄 갯수 
	    int pageNavSize = 5; // 페이지 네비 크기
	    int startRow = (pageNum - 1) * pageSize; //시작페이지 계산
	    Integer totalCount = itemservice.getTotalCount(); // 총 레코드 수 가져옴
	    List<ItemVO> itemlist = itemservice.itemAll(startRow, pageSize, item_name);
		Integer totalPages = itemservice.itemSearch(pageSize, item_name); // 검색 이후 레코드수 계산
		PaginationVO pagination = new PaginationVO(pageNum, totalCount, pageSize, pageNavSize);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("item_pagination", pagination);
	    mav.addObject("item_currentPage", pageNum);
	    mav.addObject("item_totalPages", totalPages);
	    mav.addObject("itemlist", itemlist);
	    return mav;
	    
	}//end
	
	//협력회사 페이징
	public ModelAndView partnerpaging(int pageNum, String partner_companyname) {
		
		int pageSize = 10; // 한 페이지에 보여줄 갯수 
	    int pageNavSize = 5; // 페이지 네비 크기
	    int startRow = (pageNum - 1) * pageSize; //시작페이지 계산
	    Integer totalCount = partnerservice.getTotalCount(); // 총 레코드 수 가져옴
		List<PartnerVO> partnerlist = partnerservice.partnerAll(startRow,pageSize, partner_companyname);
		Integer totalPages = partnerservice.partnerSearch(pageSize, partner_companyname); // 검색 이후 레코드수 계산
		PaginationVO pagination = new PaginationVO(pageNum, totalCount, pageSize, pageNavSize);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("partner_pagination", pagination);
	    mav.addObject("partner_currentPage", pageNum);
	    mav.addObject("partner_totalPages", totalPages);
	    mav.addObject("partnerlist", partnerlist);
	    return mav;
	}//end
	
	//계약 페이징
	public ModelAndView contractspaging(int pageNum) {
		int pageSize = 10; // 한 페이지에 보여줄 갯수 
	    int pageNavSize = 5; // 페이지 네비 크기
	    int startRow = (pageNum - 1) * pageSize; //시작페이지 계산
	    Integer totalCount = contractservice.getTotalCount(); // 총 레코드 수 가져옴
	    List<ContractsVO> conlist = contractservice.contractsAll(startRow, pageSize);
	    Integer totalPages = totalCount;//검색을 하지 않기에 전체페이지와 같음
	    PaginationVO pagination = new PaginationVO(pageNum, totalCount, pageSize, pageNavSize);
		
	    ModelAndView mav = new ModelAndView();
		mav.addObject("contracts_pagination", pagination);
	    mav.addObject("contracts_currentPage", pageNum);
	    mav.addObject("contracts_totalPages", totalPages);
	    mav.addObject("conlist", conlist);
	    return mav;
	}//end
	

}//end class
