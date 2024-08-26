package com.kr.kimchi.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kr.kimchi.dao.AttachmentDAO;
import com.kr.kimchi.vo.AttachmentVO;

@Service
public class AttachmentService {
	
	@Inject
	private AttachmentDAO attdao;
	
//	첨부파일 보기
	public List<AttachmentVO> attachmentAll(Map<String, Object> attmap) {
		return attdao.attachmentAll(attmap);
	}//end
	public AttachmentVO attachmentSelect(int item_no) {
		return attdao.attachmentSelect(item_no);
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
