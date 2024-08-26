package com.kr.kimchi.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class AttachmentDAO {
	
	private final static String namespace = "com.kr.kimchi.mappers.attachmentMapper";

	@Inject
	private SqlSession session;

}// end class
