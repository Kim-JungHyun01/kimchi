package com.kr.kimchi.vo;

import lombok.Data;

@Data
public class MaterialVO {
	
	private int ma_id;
	private String ma_name;
	private String ma_category;
	private int ma_price;
	private String ma_unit;
	private String ma_weight;
	private String ma_specifications;
	private String ma_expiryDate;
	private String ma_origin;	
	private int ma_stockQuantity; 
	private Integer ma_availableStock; 
	private int ma_basicStock; 
	private Integer ma_stockValue; 
	private String ma_storage;
	private String ma_date; 	
	private int attachment_no;
	

	// ma_stockValue 계산
	public void calStockValue() {
	    this.ma_stockValue = this.ma_price * this.ma_stockQuantity;
	}
	
	//금액현황표
	private Integer totalQuantity; // 총수량
	private Integer totalValue; // 항목별 총액
	private Integer totalPrice; // 전체 재고 총합계액
	
	
}
