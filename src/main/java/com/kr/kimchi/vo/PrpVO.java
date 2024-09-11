package com.kr.kimchi.vo;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class PrpVO {
	
	
	private int prp_no;
	private String user_id;
	private int pa_no;
	private String prp_issueDate;
	private String PRP_revisionDate;
	private int prp_progress;
	private String prp_notes;
	
	public PrpVO() {}
	
	public PrpVO(String user_id, int pa_no, String prp_issueDate, int prp_progress, String prp_notes) {
		this.user_id = user_id;
		this.pa_no = pa_no;
		this.prp_issueDate = prp_issueDate;
		this.prp_progress = prp_progress;
		this.prp_notes = prp_notes;
	}

	private UserVO userVO;
	
}
