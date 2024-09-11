package com.kr.kimchi.vo;



import lombok.Data;

@Data
public class InlistVO {

	private int io_id;
	private String io_status;
	private int io_quantity;
	private String io_date;
	private String io_information;
	private String io_retrun_date;
	private String invoice_issuance_status;
	private int ma_id;
	private int obtain_no;
	private String partner_companyname;
	
}
