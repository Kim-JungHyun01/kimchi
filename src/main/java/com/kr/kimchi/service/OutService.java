package com.kr.kimchi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kr.kimchi.dao.OutDAO;
import com.kr.kimchi.vo.IOVO;

@Service
public class OutService {

    @Autowired
    private OutDAO outDAO;

    public List<IOVO> outList(int startRow, int pageSize, Integer io_id) {
        return outDAO.outList(startRow, pageSize, io_id);
    }

    public Integer getTotalCount() {
        return outDAO.getTotalCount();
    }

    public Integer getSearch(int pageSize, Integer io_id) {
        return outDAO.getSearch(pageSize, io_id);
    }

    public IOVO outView(Integer io_id) {
        return outDAO.outView(io_id);
    }

    @Transactional
    public void outAdd(IOVO outAdd) {
        outDAO.outAdd(outAdd); // 출고 정보 추가
        outDAO.updateMa(outAdd); // 자재 정보 업데이트
    }
}
