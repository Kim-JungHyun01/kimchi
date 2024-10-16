package com.kr.kimchi.vo;


import lombok.Data;

@Data
public class ContractsVO {
	
	private int contracts_no; 
	private int contracts_quantity; 
	private int contracts_price; 
	private String contracts_deliveryDate; 
	private String contracts_status; 
	private String contracts_details; 
	private String contracts_registrationDate; 
	private int contracts_document; 
	private int item_no; 
	private String partner_taxid; 
	private String user_id;
	
	private PartnerVO partnerVO; 
	private ItemVO itemVO;
}
