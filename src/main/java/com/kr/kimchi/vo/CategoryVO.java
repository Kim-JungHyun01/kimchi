package kr.co.kim.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CategoryVO {

	private int ca_id; 
	private String ca_name;
	public CategoryVO(int ca_id, String ca_name) {
		this.ca_id = ca_id;
		this.ca_name = ca_name;
	}
	
	
}
