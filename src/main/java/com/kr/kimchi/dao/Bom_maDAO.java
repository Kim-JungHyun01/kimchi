package com.kr.kimchi.dao;

import java.util.List;
import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kr.kimchi.vo.Bom_maVO;

@Repository
public class Bom_maDAO {

	private final static String namespace = "com.kr.kimchi.mappers.bom_maMapper";

	@Inject
	private SqlSession session;

//	bom정보 보기_물품별
	public List<Bom_maVO> bom_maSelect(int item_no) {
		return session.selectList(namespace + ".bom_maSelect", item_no);
	}// end

//	bom정보_자재 추가
	public void bom_maInsert(List<Bom_maVO> bom_malist) {
		session.insert(namespace + ".bom_maInsert", bom_malist);
	}// end

	// bom정도_자재 수정 
	public void bom_maUpdate(List<Bom_maVO> bom_malist) {
	    session.update(namespace + ".bom_maUpdate", bom_malist);
	}// end

//	bom정보_자재 선택적삭제
	public void bom_maDeleteSelect(int item_no, int ma_id) {
		session.selectOne(namespace + ".bom_maDeleteSelect", item_no);
	}// end

//	bom정보_자재 삭제(bom & item 삭제시)
	public void bom_maDeleteAll(int item_no) {
		session.selectOne(namespace + ".bom_maDeleteAll", item_no);
	}// end

}// end class
