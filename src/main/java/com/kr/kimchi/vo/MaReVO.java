package kr.co.kim.vo;

import lombok.Data;

@Data
public class MaReVO {
	private int returns_id;
	private String return_status;
	private int ReturnQuantity;
	private String ReturnDate;
	private String ReturnReason;
	private int RemainingQuantity;
	private int io_id;
	
	
}
