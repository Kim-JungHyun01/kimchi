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
	private String ma_specifications;
	private int ma_StockQuantity; 
	private int ma_AvailableStock; 
	private int ma_BasicStock; 
	private String ma_stock_value; 
	private String ma_storage;
	private Date ma_updateDate; 
	private int attachment_no;

}
