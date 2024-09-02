package com.kr.kimchi.vo;


import lombok.Data;

@Data
public class ProductionVO {

	private int production_no; 
	private int production_quantity; 
	private String production_deliveryDate; 
	private String production_status; 
	private String production_registrationDate; 
	private String user_id; 
	private int contracts_no;
	
	private ContractsVO contractsVO; 
	
}
