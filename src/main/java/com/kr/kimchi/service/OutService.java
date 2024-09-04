package com.kr.kimchi.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kr.kimchi.dao.OutDAO;
import com.kr.kimchi.vo.IOVO;

@Service
public class OutService {

    @Inject
    private OutDAO outdao;

//    @Inject
//    private MaterialService maService; // 추가

    // 전체 + 페이징
    public List<IOVO> outList(int startRow, int pageSize) {
        return outdao.outList(startRow, pageSize);
    }

    // 전체 레코드 수
    public Integer getTotalCount() {
        return outdao.getTotalCount();
    }

    // 상세
    public IOVO outView(int io_id) {
        return outdao.outView(io_id);
    }

    // 출고 정보 삽입 및 자재 정보 업데이트
    @Transactional
    public void outAdd(IOVO out) {
        // 출고 정보 삽입
        outdao.outAdd(out);

        // 자재 정보 업데이트 (재고 수량 감소)
        outdao.updateMa(out);
    }
    //=================
}
