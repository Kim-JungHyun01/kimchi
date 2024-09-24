package com.kr.kimchi.vo;

import lombok.Data;

@Data
public class MaterialVO {
	
	private int ma_id;
	private String ma_name;
	private String ma_category;
	private int ma_price;
	private String ma_unit;
	private int ma_weight;
	private String ma_specifications;
	private String ma_expiryDate;
	private String ma_origin;	
	private int ma_stockQuantity; 
	private Integer ma_availableStock; 
	private int ma_basicStock; 
	private Long ma_stockValue; 
	private String ma_storage;
	private String ma_date; 
	private String ma_update;
	private int attachment_no;
	private String io_date;

	// 첨부파일 경로
	private String attachmentLocation; 	

	// ma_stockValue 계산
	public void calStockValue() {
	    this.ma_stockValue = (long) (this.ma_price * this.ma_stockQuantity);
	}
	
	//금액현황표
	private Long totalQuantity; // 총수량
	private Long totalValue; // 항목별 총액
	private Long totalPrice; // 전체 재고 총합계액
	
	
}
