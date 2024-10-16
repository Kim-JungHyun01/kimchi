package com.kr.kimchi.vo;

import lombok.Data;

@Data
public class UserVO {
	
	private String user_id;
	private String user_pw;
	private String user_email;
	private String user_name;
	private String user_number;
	private String user_department;
	private int user_approval;
	
}//end class
