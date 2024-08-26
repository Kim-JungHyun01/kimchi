package com.kr.kimchi.vo;

import java.util.Date;

import lombok.Data;

@Data
public class ItemsVO {

	private int items_no;
	private int  items_category;
	private String item_name;
	private int item_price;
	private String item_unit;
	private String items_specifications;
	private int items_bomRegistered;
	private int items_stockquantity;
	private int items_availablestock;
	private int items_basicstock;
	private String items_storage;
	private Date items_productionDate;
	private int attachment_no;
}
