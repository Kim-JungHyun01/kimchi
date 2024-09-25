package com.kr.kimchi.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kr.kimchi.service.AttachmentService;
import com.kr.kimchi.vo.AttachmentVO;

@Controller
public class AttachmentController {

	@Inject
	private AttachmentService attservice;

	@PostMapping(value = "fileInsert")
	public ResponseEntity<Integer> fileInsert(@RequestParam(value = "file", required = false) MultipartFile file) {
	    String uploadDir = "../../../../springworkspaces/kimchi/src/main/webapp/resources/images/kimchi/attachment";
	    String originalFileName = file.getOriginalFilename();
	    System.out.println("originalFileName: " + originalFileName);
	    
	    File dir = new File(uploadDir);
	    
	    // 디렉토리 존재 여부 확인 및 생성
	    if (!dir.exists()) {
	        if (dir.mkdirs()) {
	            System.out.println("디렉토리 생성 성공: " + uploadDir);
	        } else {
	            System.out.println("디렉토리 생성 실패: " + uploadDir);
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(0);
	        }
	    }

	    String currentDir = System.getProperty("user.dir");
	    System.out.println("현재 작업 디렉토리: " + currentDir);

	    // 파일 이름과 확장자 분리
	    String fileName = originalFileName;
	    File uploadedFile = new File(uploadDir, fileName);
	    int counter = 1;
	    System.out.println("시작_counter : " + counter);
	    
	    // 파일 이름과 확장자 분리
	    int dotIndex = originalFileName.lastIndexOf(".");
	    String fileExtension = originalFileName.substring(dotIndex); // 파일 확장자 저장
	    System.out.println("fileExtension : "+fileExtension);

	    // 파일이 이미 존재하는 경우, 이름 변경
	    while (uploadedFile.exists()) {
	        String newFileName = originalFileName.substring(0, dotIndex) + "_" + counter + fileExtension; // 새로운 파일 이름 생성
	        uploadedFile = new File(uploadDir, newFileName); // 변경된 파일 이름으로 업데이트
	        counter++;
	        System.out.println("newFileName : " + newFileName);
	    }//end
	    System.out.println("끝_counter : " + counter);
	    System.out.println("파일이 저장될 경로: " + uploadedFile.getAbsolutePath());
	    
	    try {
	        file.transferTo(uploadedFile);
	        System.out.println("업로드 성공");
	        System.out.println("파일이 저장된 경로: " + uploadedFile.getAbsolutePath());
	    } catch (IOException e) {
	        System.err.println("파일 업로드 중 오류 발생: " + e.getMessage());
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(0);
	    } catch (Exception e) {
	        System.err.println("알 수 없는 오류 발생: " + e.getMessage());
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(0);
	    }
	
	    return ResponseEntity.ok(1);
	}//END


	 // AttachmentVO 객체 생성 및 정보 설정 (주석 처리된 부분)
    // AttachmentVO att = new AttachmentVO();
    // att.setAttachment_name(fileName);
    // att.setAttachment_location("../../../kimchi/src/main/webapp/resources/images/kimchi/attachment" + "/" + fileName);
    // attservice.attachmentInsert(att);
	
	
	

//	파일 이름 증복시 이름 생성
	public static String getRandomString() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}// end

//	첨부파일 추가
//	@GetMapping(value = "attachment/attachmentInsertForm")
//	public String attachmentInsertForm() {
//		return "attachment/attachmentInsertForm";
//	}// end

	@PostMapping(value = "attachmentInsert")
	public ModelAndView attachmentInsert(AttachmentVO att) {
		attservice.attachmentInsert(att);
		ModelAndView mav = new ModelAndView();
		mav.addObject("att", att);
		return mav;
	}// end

//	첨부파일 수정
//	@GetMapping(value = "attachment/attachmentUpdateForm")
//	public ModelAndView attachmentUpdateForm(int attachment_no) {
//		AttachmentVO att = attservice.attachmentSelect(attachment_no);
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("att", att);
//		mav.setViewName("attachment/attachmentUpdateForm");
//		return mav;
//	}// end
//
//	@PostMapping(value = "attachmentUpdate")
//	public ModelAndView attachmentUpdate(AttachmentVO att) {
//		attservice.attachmentUpdate(att);
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("att", att);
//		return mav;
//	}// end

}// end class
