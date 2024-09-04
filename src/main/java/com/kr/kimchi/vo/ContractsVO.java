package com.kr.kimchi.vo;

import java.util.Date;

import lombok.Data;

@Data
public class ContractsVO {
	
	private int contracts_no; 
	private int contracts_quantity; 
	private int contracts_price; 
	private Date contracts_deliveryDate; 
	private String contracts_status; 
	private String contracts_details; 
	private Date contracts_registrationDate; 
	private int contracts_document; 
	private int item_no; 
	private String partner_taxid; 
	private String user_id;
	
	private PartnerVO partnerVO; 
	private ItemVO itemVO;
}
