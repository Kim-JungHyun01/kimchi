package com.kr.kimchi.vo;

import lombok.Data;

@Data
public class ChartVO {

    private String ma_name; // 자재명
    private Long totalQuantity;   // 총 재고 갯수
    private Long totalValue;      // 총액

    public ChartVO() {
    }

    // 총합계액 계산
    public static Long calculateTotalPrice(ChartVO[] chartData) {
        Long totalPrice = 0L;
        for (ChartVO chart : chartData) {
            totalPrice += chart.getTotalValue();
        }
        return totalPrice;
    }
}
