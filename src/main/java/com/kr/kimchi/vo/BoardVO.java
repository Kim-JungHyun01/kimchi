package com.kr.kimchi.vo;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
    
	private int board_no;
	private String board_title;
	private String board_content;
	private String board_comment;
	private Date board_createdDate;
	private Date board_modifiedDate;
	
	private AttachmentVO attachment_no;
	private UserVO user_id;
	
	
}
