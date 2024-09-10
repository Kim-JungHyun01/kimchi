package com.kr.kimchi.controller;

import javax.inject.Inject;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import java.io.File;
import java.util.List;

import com.kr.kimchi.service.ContractsService;
import com.kr.kimchi.service.PdfService;
import com.kr.kimchi.vo.ContractsVO;

@Controller
public class PdfController {

	@Inject
	PdfService pdfService;
	@Inject
	private ContractsService conservice;
	
//	@GetMapping("pdf/createPdf")
//	public ModelAndView list(int contants_no) throws Exception{
//        //pdf 파일 생성
//		ContractsVO con = conservice.contractsSelect(contants_no);
//        int result = pdfService.createContract(con);
//        return new ModelAndView("pdf/result", "message", result);
//    }

	@GetMapping("/viewPdf")
	public ResponseEntity<FileSystemResource> viewPdf() {
	    String filename = "Sample2.PDF";
	    String filePath = "C:/KJH/springworkspaces/practive/src/main/webapp/resources/pdf/" + filename;
	    File file = new File(filePath);
	    
	    if (!file.exists()) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }

	    FileSystemResource resource = new FileSystemResource(file);
	    HttpHeaders headers = new HttpHeaders();
	    headers.add(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=" + filename);
	    headers.add(HttpHeaders.CONTENT_TYPE, "application/pdf");
	    
	    return new ResponseEntity<>(resource, headers, HttpStatus.OK);
	}//end
	
}//end class
