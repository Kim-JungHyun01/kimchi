package com.kr.kimchi.vo;

import java.util.Date;

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
	private Date ma_expiryDate; 
	private String ma_origin; 
	private int ma_stockQuantity; 
	private int ma_availableStock; 
	private int ma_basicStock; 
	private String ma_stockValue; 
	private String ma_storage;
	private Date ma_date; 
	private int attachment_no;

	
	



	
}
