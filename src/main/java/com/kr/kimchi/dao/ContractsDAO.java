package com.kr.kimchi.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class ContractsDAO {
private final static String namespace="com.kr.kimchi.mappers.contractsMapper";
	
	@Inject
	private SqlSession session;

}//end class
