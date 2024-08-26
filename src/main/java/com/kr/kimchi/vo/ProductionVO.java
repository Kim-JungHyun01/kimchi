package com.kr.kimchi.vo;

import java.util.Date;

import lombok.Data;

@Data
public class ProductionVO {

	private int production_no; 
	private int production_quantity; 
	private Date production_deliveryDate; 
	private String production_status; 
	private Date production_registrationDate; 
	private String user_id; 
	private int contracts_no;
	
	private ContractsVO contractsVO; 
	
}
