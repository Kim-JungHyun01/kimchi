package com.kr.kimchi.vo;

import lombok.Data;

@Data
public class ChartVO {
	
    private String ma_date; // 자재등록일
    
    // 데이터베이스에 없는 값
    private Long totalQuantity; // 전체 체고 수량
    private Long totalValue; // 항목별 재고 총액
    private Long totalPrice; // 전체 재고 총합계액
}
