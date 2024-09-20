package com.kr.kimchi.vo;

import lombok.Data;

@Data
public class ChartVO {

	//========자재수량 / 총액 / 전체총액=========
    private String ma_name; // 자재명
    
    private int ma_price; // 단가
    private int ma_stockQuantity; // 재고량
    
    private Long totalQuantity; // 총 재고 갯수
    private Long totalValue; // 총액
    
    //========입고 / 출고=========
    private Integer io_id;  
    private String io_status;  
    private Integer io_quantity;    
    private String io_date; 
    private int ma_id;
    private long outValue; // 출고 총액
    private long inValue; // 출고 총액
    //====================
}