package com.kr.kimchi.controller;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kr.kimchi.service.*;
import com.kr.kimchi.vo.*;

@Controller
public class ContractsController {

	@Inject
	private ContractsService conservice;
	@Inject
	private ItemService itemservice;
	@Inject
	private CodeService codeservice;
	@Inject
	private PaService paservice;
	@Inject
	private UserService userservice;
	@Inject
	private PartnerService partservice;
	@Inject
	private PdfService pdfService;
	@Inject
	private ModalpagingService pageservice;

//	계약 보기_전체
	@GetMapping(value = "contracts/contractsAll")
	public ModelAndView contractsAll(@RequestParam(defaultValue = "1") int pageNum) {

		int pageSize = 5; // 한 페이지에 보여줄 갯수 
	    int pageNavSize = 5; // 페이지 네비 크기
	    int startRow = (pageNum - 1) * pageSize; //시작페이지 계산
	    
	    List<ContractsVO> conlist = conservice.contractsAll(startRow, pageSize);
	    List<UserVO> userlist = userservice.userAll(0, 100, null, "생산부서");
	    List<ItemVO> itemlist =itemservice.itemAll(0, 100, null);
	    
	    Integer totalCount = conservice.getTotalCount(); // 총 레코드 수 가져옴
	    Integer totalPages = (int) Math.ceil((double) totalCount / pageSize);//검색이 없기에 따로 계산
	    
	    PaginationVO pagination = new PaginationVO(pageNum, totalCount, pageSize, pageNavSize);
		ModelAndView mav = new ModelAndView();
		mav.addObject("pagination", pagination);
	    mav.addObject("currentPage", pageNum);
	    mav.addObject("totalPages", totalPages);
	    
		mav.addObject("conlist", conlist);
		mav.addObject("userlist", userlist);
		mav.addObject("itemlist", itemlist);
		mav.setViewName("contracts/contractsAll");
		return mav;
	}// end

//	계약 보기_상세
	@GetMapping(value = "contracts/contractsSelect")
	public ModelAndView contractsSelect(int contracts_no) {
		ContractsVO con = conservice.contractsSelect(contracts_no);
		ItemVO item = itemservice.itemSelect(con.getItem_no());
		UserVO user = userservice.userSelect(con.getUser_id());
		PartnerVO partner = partservice.partnerSelect(con.getPartner_taxid());
		ModelAndView mav = new ModelAndView();
		mav.addObject("con", con);
		mav.addObject("item", item);
		mav.addObject("user", user);
		mav.addObject("partner", partner);
		mav.setViewName("contracts/contractsSelect");
		return mav;
	}// end	

//	계약 추가
	@GetMapping(value = "contracts/contractsInsertForm")
	public ModelAndView contractsInsertForm(@RequestParam(defaultValue = "1") int pageNum,
											@RequestParam(required = false) String item_name,
											@RequestParam(required = false) String user_name,
											@RequestParam(required = false) String user_department,
											@RequestParam(required = false) String partner_companyname) {
		ModelAndView mav = new ModelAndView();
		// item 페이징
	    ModelAndView itemMav = pageservice.itempaging(pageNum, item_name);
	    mav.addAllObjects(itemMav.getModel());

	    // partner 페이징
	    ModelAndView partnerMav = pageservice.partnerpaging(pageNum, partner_companyname);
	    mav.addAllObjects(partnerMav.getModel());
		
//		user 페이징
	    ModelAndView userMav = pageservice.userpaging(pageNum, user_name, user_department);
	    mav.addAllObjects(userMav.getModel());
	    
		mav.setViewName("contracts/contractsInsertForm");
		return mav;
	}// end

	@PostMapping(value = "contracts/contractsInsert")
	public String contractsInsert(ContractsVO con) {
		conservice.contractsInsert(con);
		return "redirect:/contracts/contractsAll";
	}// end

//	계약 수정_계약갯수, 계약가격, 납기일, 상새내역
	@GetMapping(value = "contracts/contractsUpdateForm")
	public ModelAndView contractsUpdateForm(int contracts_no) {
		ModelAndView mav = contractsSelect(contracts_no);
		mav.setViewName("contracts/contractsUpdateForm");
		return mav;
	}// end

	@PostMapping(value = "contracts/contractsUpdate")
	public String contractsUpdate(ContractsVO con) {
		conservice.contractsUpdate(con);
		return "redirect:/contracts/contractsSelect?contracts_no=" + con.getContracts_no();
	}// end

//	계약 승인 & 취소 체크
	@PostMapping(value = "contracts/contractsCheck")
	public String contractsCheck(ContractsVO con) throws ParseException {
		conservice.contractsCheck(con); // 계약서 승인/취소 수정
		// 계약 승인 시 서류 발급
		if (con.getContracts_status().equals("계약승인")) {
			ContractsVO incon = conservice.contractsSelect(con.getContracts_no());
			CodeVO code = codeservice.contractsCode(incon);

			// 여기서 codeInsert 메서드의 반환 값을 사용하여 code_id를 가져옵니다.
			CodeVO insertedCode = codeservice.codeInsert(code);
			int code_id = insertedCode.getCode_id(); // 올바르게 설정된 code_id 사용
			int result = pdfService.createContract(con.getContracts_no(), insertedCode.getCode_name());

			if (result == 1) {
				// pa 추가
				PaVO pa = new PaVO();
				pa.setUser_id(incon.getUser_id());
				pa.setCode_id(code_id);
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date pa_issueDate = formatter.parse(incon.getContracts_registrationDate());
				pa.setPa_issueDate(pa_issueDate);
				pa.setPa_referenceNo(incon.getContracts_no());
				paservice.paInsert(pa);
			} else if (result == 0) {
				codeservice.codeDelete(code_id);
			} // end

		} // end if

		return "redirect:/contracts/contractsSelect?contracts_no=" + con.getContracts_no();
	}// end

//	계약서 작성

// 계약서 보기
	@GetMapping(value = "contracts/documentView")
	public ResponseEntity<FileSystemResource> documentView(int ca_id, int pa_referenceNo) {
		// params 맵 생성
		Map<String, Object> params = new HashMap<>();
		params.put("ca_id", ca_id);
		params.put("pa_referenceNo", pa_referenceNo);

		// paSelect 메서드 호출
		PaVO pa = paservice.paSelect(params);
		paservice.paCheck(pa.getPa_no());

		String filename = pa.getCodeVo().getCode_name() + ".PDF";
		System.out.println(filename);
//	    String filePath = "C:/KJH/springworkspaces/practive/src/main/webapp/resources/pdf/" + filename;
		String filePath = "C:/Users/A9/Desktop/pdf/" + filename;//절대경로
		File file = new File(filePath);
		if (!file.exists()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		FileSystemResource resource = new FileSystemResource(file);
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=" + filename);
		headers.add(HttpHeaders.CONTENT_TYPE, "application/pdf");
		return new ResponseEntity<>(resource, headers, HttpStatus.OK);
	}// end

}// end class
