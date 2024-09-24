package com.kr.kimchi.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kr.kimchi.dao.AttachmentDAO;
import com.kr.kimchi.vo.AttachmentVO;

@Service
public class AttachmentService {
	
	@Inject
	private AttachmentDAO attdao;
	
//	첨부파일 보기
	public List<AttachmentVO> attachmentAll() {
		return attdao.attachmentAll();
	}//end
	public AttachmentVO attachmentSelect(int attachment_no) {
		return attdao.attachmentSelect(attachment_no);
	}//end
	
//	첨부파일 추가
	public void attachmentInsert(AttachmentVO att) {
		attdao.attachmentInsert(att);
	}//end
	
//	첨부파일 수정
	public void attachmentUpdate(AttachmentVO att) {
		attdao.attachmentUpdate(att);
	}//end
	
//	첨부파일 삭제
	public void attachmentDelete(int item_no) {
		attdao.attachmentDelete(item_no);
	}//end
	

}//end class
