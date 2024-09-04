package com.kr.kimchi.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data

public class BoardVO {
    
	private int board_no;
	private String board_title;
	private String board_content;
	private String board_comment;
	@DateTimeFormat(pattern = "yyyy-MM-dd")	
	private Date board_createdDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")	
	private Date board_modifiedDate;
	private int attachment_no;
	private String user_id;
	
	
	
	
}
