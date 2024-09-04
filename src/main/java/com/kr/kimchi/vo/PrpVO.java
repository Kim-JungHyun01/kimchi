package com.kr.kimchi.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class PrpVO {
	
	private int prp_no;
	private String user_id;
	private int pa_no;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String prp_issueDate;
	private String PRP_revisionDate;
	private int prp_progress;
	private String prp_notes;
}
