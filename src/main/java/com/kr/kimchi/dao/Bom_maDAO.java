package com.kr.kimchi.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class Bom_maDAO {

	private final static String namespace = "com.kr.kimchi.mappers.bom_maMapper";

	@Inject
	private SqlSession session;

}// end class
