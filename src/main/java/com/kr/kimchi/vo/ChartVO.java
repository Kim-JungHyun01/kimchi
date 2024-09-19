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
    
    //물품별 계약량과 계약금액을 차트로 표시
    private String item_no;//물품코드
    private String item_name;//물품명
    
    private Long totalcon_quantity;//총계약량
    private Long totalcon_price;//총계약금액
    
  //====================
}
