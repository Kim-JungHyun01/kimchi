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
		String uploadDir = "C:\\Users\\A9\\Desktop\\연습용";//저장 위치 변경_servlet-context도 변경해야함
		String originalFileName = file.getOriginalFilename();
		String fileName = originalFileName;
		File dir = new File(uploadDir);

		if (!dir.exists()) {
			dir.mkdir(); // 디렉토리 생성
		}

		// 파일이 이미 존재하는지 확인
		File uploadedFile = new File(uploadDir, fileName);
		int counter = 1; // 카운트 변수 초기화

		// 파일 이름이 중복될 경우 카운트 추가
		while (uploadedFile.exists()) {
			String fileExtension = "";//첨부파일 확장자 초기화
			int dotIndex = originalFileName.lastIndexOf(".");//마지막에 . 넣기
			if (dotIndex > 0) {
				fileExtension = originalFileName.substring(dotIndex); // 파일 확장자 저장
				fileName = originalFileName.substring(0, dotIndex) + "_" + counter + fileExtension;
			} else {
				fileName = originalFileName + "_" + counter;
			}
			uploadedFile = new File(fileName);
			counter++; // 카운트 증가
		} // end while

		//파일 업로드
		 try {
		        file.transferTo(uploadedFile);
		    } catch (IOException e) {
		        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(0);
		    }

		// AttachmentVO 객체 생성 및 정보 설정
		AttachmentVO att = new AttachmentVO();
		att.setAttachment_name(fileName);
		att.setAttachment_location(uploadDir + "￦" + fileName);
		attservice.attachmentInsert(att);
		
		return ResponseEntity.ok(1);
	}// end

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
