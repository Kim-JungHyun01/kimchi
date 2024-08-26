package com.kr.kimchi.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class ProductionDAO {

	private final static String namespace="com.kr.kimchi.mappers.productionMapper";
	
	@Inject
	private SqlSession session;
	
	
	
	
}//end class
