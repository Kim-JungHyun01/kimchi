package com.kr.kimchi.vo;

import java.util.Date;

import lombok.Data;

@Data
public class ObtainVO {

	private int obtain_no; 
	private int ma_id; 
	private int obtain_quantity; 
	private int obtain_price;
	private String obtain_deliveryDate; 
	private String obtain_status; 
	private Date obtain_registrationDate; 
	private int obtain_document; 
	private String user_id; 
	private int production_no; 
	private String partner_taxid;
	
	private ProductionVO productionVO; 
	private MaterialVO materialVO;
}