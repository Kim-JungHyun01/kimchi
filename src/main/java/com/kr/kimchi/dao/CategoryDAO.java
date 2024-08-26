package com.kr.kimchi.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDAO {
	private final static String namespace = "com.kr.kimchi.mappers.categoryMapper";

	@Inject
	private SqlSession session;

}// end class
