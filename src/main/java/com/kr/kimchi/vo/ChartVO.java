package com.kr.kimchi.vo;

import lombok.Data;

@Data
public class ChartVO {

    private String ma_name; // 자재명
    
    private int ma_price; // 단가
    private int ma_stockQuantity; // 재고량
    
    private Long totalQuantity; // 총 재고 갯수
    private Long totalValue; // 총액

 	//====================
}
