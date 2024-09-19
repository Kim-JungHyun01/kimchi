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

    // 상품별 재고 갯수 정보
    public List<Map<String, Object>> chartData() throws SQLException {
        return session.selectList(namespace + ".chartData");
    }

    // 전체 재고 총액 정보 (날짜별 총액)
    public List<Map<String, Object>> totalStockChart() throws SQLException {
        return session.selectList(namespace + ".totalStockChart");
    }
    //===============
}
