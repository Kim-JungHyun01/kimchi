package com.kr.kimchi.vo;

import lombok.Data;

@Data
public class transactionVO {
	
	//obtain
	private int obtain_no;
	private String user_id;
	private String obtain_deliveryDate;
	private int obtain_quantity;
	
	//material
	
	private String ma_name;
	private long ma_price;
	private String ma_specifications;
	private String ma_unit;
	private String ma_weight;
	private String ma_storage;
	
	//partner
	private String partner_taxid;
	private String partner_companyname;
	private String partner_number;
	private String partner_ownername;
	private String partner_fax;
	private String partner_add;
	

}
