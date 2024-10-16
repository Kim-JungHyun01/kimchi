package com.kr.kimchi.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kr.kimchi.vo.AttachmentVO;

@Repository
public class AttachmentDAO {
	
	private final static String namespace = "com.kr.kimchi.mappers.attachmentMapper";

	@Inject
	private SqlSession session;
	
//	첨부파일 보기
	public List<AttachmentVO> attachmentAll() {
		return session.selectList(namespace+".attachmentAll");
	}//end
	public AttachmentVO attachmentSelect(int attachment_no) {
		return session.selectOne(namespace+".attachmentSelect", attachment_no);
	}//end
	
//	첨부파일 추가
	public void attachmentInsert(AttachmentVO att) {
		session.selectOne(namespace+".attachmentInsert", att);
	}//end
	
//	첨부파일 수정
	public void attachmentUpdate(AttachmentVO att) {
		session.selectOne(namespace+".attachmentUpdate", att);
	}//end
	
//	첨부파일 삭제
	public void attachmentDelete(int item_no) {
		session.selectOne(namespace+".attachmentDelete", item_no);
	}//end

}// end class
