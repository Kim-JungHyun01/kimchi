package com.kr.kimchi.vo;

import lombok.Data;

@Data
public class StatusCheck {
	
	private int io_id;
    private int obtain_no;
    private String io_status;
    private int io_quantity;
    private int ma_id;

}
