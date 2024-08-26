package com.kr.kimchi.vo;

import lombok.Data;

@Data
public class Bom_maVO {

	private int items_no;
	private int ma_id;
	private int bom_ma_amount;
	private int bom_ma_process; // 1:조리, 2:조립등등


}// end class
