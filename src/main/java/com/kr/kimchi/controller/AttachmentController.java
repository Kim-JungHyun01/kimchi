package com.kr.kimchi.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
	public ModelAndView fileInsert(@RequestParam(value = "file", required = false) MultipartFile file,
			@RequestParam(value = "item_category", required = false) String item_category,
			@RequestParam(value ="item_name",  required = false) String item_name, 
			@RequestParam(value ="item_price", required = false) Double item_price,
			@RequestParam(value ="item_unit",required = false) String item_unit, 
			@RequestParam(value ="item_weight",required = false) Double item_weight,
			@RequestParam(value ="item_specifications",required = false) String item_specifications,
			@RequestParam(value ="item_basicstock",required = false) Double item_basicstock,
			@RequestParam(value ="item_storage",required = false) String item_storage,
			@RequestParam(value ="item_productionDate",required = false) String item_productionDate) {
// Your existing logic
		String uploadDir = "C:\\Users\\user\\OneDrive\\바탕 화면\\연습용\\";
		String originalFileName = file.getOriginalFilename();
		String fileName = originalFileName;
		File dir = new File(uploadDir);

		if (!dir.exists()) {
			dir.mkdir(); // 디렉토리 생성
		}

		// 파일이 이미 존재하는지 확인
		File uploadedFile = new File(uploadDir + fileName);

		// 파일 이름이 중복될 경우 랜덤 문자열 추가
		while (uploadedFile.exists()) {
			String fileExtension = "";
			int dotIndex = originalFileName.lastIndexOf(".");
			if (dotIndex > 0) {
				fileExtension = originalFileName.substring(dotIndex); // 파일 확장자 저장
				fileName = originalFileName.substring(0, dotIndex) + "_" + getRandomString() + fileExtension;
			} else {
				fileName = originalFileName + "_" + getRandomString();
			}
			uploadedFile = new File(uploadDir + fileName);
		}

		try {
			file.transferTo(uploadedFile);

			// AttachmentVO 객체 생성 및 정보 설정
			AttachmentVO att = new AttachmentVO();
			att.setAttachment_name(originalFileName);
			att.setAttachment_location(uploadDir + fileName);
			attservice.attachmentInsert(att);

			// 입력된 데이터와 메시지를 모델에 추가
			 return new ModelAndView("redirect:/item/itemInsertForm","message", originalFileName+"업로드 선공")
					.addObject("item_category", item_category).addObject("item_name", item_name)
					.addObject("item_price", item_price).addObject("item_weight", item_weight)
					.addObject("item_unit", item_unit).addObject("item_specifications", item_specifications)
					.addObject("item_basicstock", item_basicstock).addObject("item_storage", item_storage)
					.addObject("item_productionDate", item_productionDate);
		} catch (IOException e) {
			 return new ModelAndView("redirect:/item/itemInsertForm","message" , e.getMessage()+"업로드 실패")
					.addObject("item_category", item_category).addObject("item_name", item_name)
					.addObject("item_price", item_price).addObject("item_weight", item_weight)
					.addObject("item_unit", item_unit).addObject("item_specifications", item_specifications)
					.addObject("item_basicstock", item_basicstock).addObject("item_storage", item_storage)
					.addObject("item_productionDate", item_productionDate);
		}
	}// end

//	파일 이름 증복시 이름 생성
	public static String getRandomString() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}// end

//	첨부파일 추가
	@GetMapping(value = "attachment/attachmentInsertForm")
	public String attachmentInsertForm() {
		return "attachment/attachmentInsertForm";
	}// end

	@PostMapping(value = "attachmentInsert")
	public ModelAndView attachmentInsert(AttachmentVO att) {
		attservice.attachmentInsert(att);
		ModelAndView mav = new ModelAndView();
		mav.addObject("att", att);
		return mav;
	}// end

//	첨부파일 수정
	@GetMapping(value = "attachment/attachmentUpdateForm")
	public ModelAndView attachmentUpdateForm(int attachment_no) {
		AttachmentVO att = attservice.attachmentSelect(attachment_no);
		ModelAndView mav = new ModelAndView();
		mav.addObject("att", att);
		mav.setViewName("attachment/attachmentUpdateForm");
		return mav;
	}// end

	@PostMapping(value = "attachmentUpdate")
	public ModelAndView attachmentUpdate(AttachmentVO att) {
		attservice.attachmentUpdate(att);
		ModelAndView mav = new ModelAndView();
		mav.addObject("att", att);
		return mav;
	}// end

}// end class
