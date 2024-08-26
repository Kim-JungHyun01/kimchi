package com.kr.kimchi.vo;

import java.util.Date;

import lombok.Data;

@Data
public class PaVO {

	private int pa_no; 
	private String user_id; 
	private int code_id; 
	private Date pa_issueDate; 
	private int pa_checkStatus; 
	private String pa_notes;
	
	private CodeVO codeVo;
	private ObtainVO obtainVo;
}
