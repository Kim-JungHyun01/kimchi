package kr.co.kim.vo;

import lombok.Data;

@Data
public class CodeVO {
	
	private int code_id; 
	private int ca_id; 
	private String code_name;
	
	private CategoryVO categoryVO;

}
