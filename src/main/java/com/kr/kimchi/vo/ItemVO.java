package com.kr.kimchi.vo;

import java.util.Date;

import lombok.Data;

@Data
public class ItemVO {

	private int item_no;
	private int  item_category;
	private String item_name;
	private int item_price;
	private String item_unit;
	private String item_specifications;
	private int item_bomRegistered;
	private int item_stockquantity;
	private int item_availablestock;
	private int item_basicstock;
	private String item_storage;
	private Date item_productionDate;
	private int attachment_no;
}
