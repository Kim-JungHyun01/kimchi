package com.kr.kimchi.controller;

import java.io.File;
import java.io.IOException;

import javax.inject.Inject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kr.kimchi.service.AttachmentService;
import com.kr.kimchi.vo.AttachmentVO;

@Controller
public class AttachmentController {

	@Inject
	private AttachmentService attservice;

	@PostMapping(value = "fileInsert")
	public ResponseEntity<Integer> fileInsert(@RequestParam(value = "file", required = false) MultipartFile file) {
		String uploadDir ="../../../../springworkspaces/kimchi/src/main/webapp/resources/images/kimchi/attachment";//파일업로드 위치_디렉토리
		String originalFileName=file.getOriginalFilename();//업로드할 파일 이름
		String FileName=originalFileName;
		
//		디렉토리 생성과정_파일업로드경로 확인용 : 평소때는 주석처리
//		File dir = new File(uploadDir,FileName);
//		if(!dir.exists()) {//해당저장위치의 디렉토리 확인
//			if(dir.mkdirs()) {//디렉토리 생성
//				System.out.println("디렉토리 생성완료 :"+uploadDir);
//			}else {
//				System.out.println("디렉토리 생성실패 :"+uploadDir);
//				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(0);
//			}
//		}else{
//			System.out.println("디렉토리존재 : "+ uploadDir);
//		}//end
//		System.out.println("dir : "+dir);
//		String currentDir = System.getProperty("user.dir");
//	    System.out.println("현재 작업 디렉토리: " + currentDir);
//	    String absolutePath = dir.getAbsolutePath();
//	    System.out.println("디렉토리의 절대 경로: " + absolutePath);
		
//		파일 중복여부 확인
	    File updateFile = new File(uploadDir,FileName);//해당폴더위치에 해당 파일이름이 있는지
	    int counter = 1;//중복수 체크
//	    System.out.println("시작_counter : "+counter);
	    String newfileName="";//새로운 이름 초기화진행
	    
	    
	    while(updateFile.exists()) {
//	    	System.out.println("while_counter : "+counter);
	    	 //파일이름 확장자 분리
		    if(counter > 0) {
		    	int index = originalFileName.lastIndexOf(".");//.전까지의 숫자
		    	String fileExtension = originalFileName.substring(index);//확장자저장
//		    	System.out.println("파일 확장자 : "+fileExtension);
		    	
		    	newfileName = originalFileName.substring(0, index) + "_" + counter + fileExtension;
//		    	System.out.println("newfileName : "+newfileName);
		    }//end
		    updateFile = new File(uploadDir, newfileName);//파일 업데이트
		    counter++;
	    }//end while
//	    System.out.println("끝_counter : "+counter);
	    
	    
	    
	    //파일 업로드
	    if(newfileName!="") {
	    	FileName=newfileName;
	    }
	    updateFile = new File(FileName);//파일 업데이트
//	    실제 이미지 업로드 경로 : 파일업로드를 위한 org.~경로 + web.xml의 muti-partLocation + FileName
//	    System.out.println("파일이 저장될 경로 : "+updateFile.getAbsolutePath());//<=디렉토리경로의미로 muti-part경로와는 다름
	    
	    try {
			file.transferTo(updateFile);
//			System.out.println("파일이 저장된 경로: " + updateFile.getAbsolutePath());
		} catch (IllegalStateException e) {
			System.err.println("호출된 메서드를 수행 오류발생: " + e.getMessage());
			e.printStackTrace();
			return ResponseEntity.ok(0);
		} catch (IOException e) {
			System.err.println("파일 업로드 중 오류 발생: " + e.getMessage());
			e.printStackTrace();
			return ResponseEntity.ok(0);
		}catch(Exception e) {
			System.err.println("알수업는 오류 발생: " + e.getMessage());
			e.printStackTrace();
			return ResponseEntity.ok(0);
		}//end try
	    
	    // AttachmentVO 객체 생성 및 정보 설정
		AttachmentVO att = new AttachmentVO();
		att.setAttachment_name(FileName);
		att.setAttachment_location("../../../kimchi/src/main/webapp/resources/images/kimchi/attachment" + "/" + FileName);
		attservice.attachmentInsert(att);
	    
		return ResponseEntity.ok(1);
	}//end

//	파일 이름 증복시 이름 생성
//	public static String getRandomString() {
//		return UUID.randomUUID().toString().replaceAll("-", "");
//	}// end

//	첨부파일 추가
//	@GetMapping(value = "attachment/attachmentInsertForm")
//	public String attachmentInsertForm() {
//		return "attachment/attachmentInsertForm";
//	}// end

//	@PostMapping(value = "attachmentInsert")
//	public ModelAndView attachmentInsert(AttachmentVO att) {
//		attservice.attachmentInsert(att);
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("att", att);
//		return mav;
//	}// end

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
