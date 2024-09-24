package com.kr.kimchi.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class ChartDAO {

    private final static String namespace = "com.kr.kimchi.mappers.ChartMapper";

    @Inject
    private SqlSession session;

    // 전체 재고 정보 조회
    public List<Map<String, Object>> chartData() throws SQLException {
        return session.selectList(namespace + ".chartData");
    }

    // 전체 재고 총액 정보 조회
    public List<Map<String, Object>> totalStockChart() throws SQLException {
        return session.selectList(namespace + ".totalStockChart");
    }
    
    // 입고 수량 정보
    public List<Map<String, Object>> inChart() throws SQLException {
    	return session.selectList(namespace + ".inChart");
    }

    // 출고 수량 정보
    public List<Map<String, Object>> outChart() throws SQLException {
        return session.selectList(namespace + ".outChart");
    }
    //===========================
}

    // 전체 재고 총액 정보 (날짜별 총액)
    public List<Map<String, Object>> totalStockChart() throws SQLException {
        return session.selectList(namespace + ".totalStockChart");
    }
    
//    물품별 계약수량, 계약금액_누적
    public List<Map<String, Object>> totalitemChart() throws SQLException{
    	return session.selectList(namespace+".totalitemChart");
    }//end
    
}//end class
