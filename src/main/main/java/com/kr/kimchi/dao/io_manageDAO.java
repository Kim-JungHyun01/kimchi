package com.kr.kimchi.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class io_manageDAO {

	private final static String namespace="kr.co.kim.mappers.material_io_manageMapper";
	
	@Inject
	private SqlSession Session;
	
	
	
}
