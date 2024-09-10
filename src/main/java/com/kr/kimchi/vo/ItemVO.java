package com.kr.kimchi.vo;

import lombok.Data;

@Data
public class ItemVO {

	private int item_no;
	private String  item_category;
	private String item_name;
	private int item_price;
	private String item_unit;
	private int item_weight;
	private String item_specifications;
	private int item_bomRegistered;
	private int item_stockquantity;
	private int item_availablestock;
	private int item_basicstock;
	private String item_storage;
	private String item_productionDate;
	private Integer attachment_no;
	
	private BomVO bomVO;
	private Bom_maVO bom_maVO;
}
