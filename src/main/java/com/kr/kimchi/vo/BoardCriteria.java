package com.kr.kimchi.vo;

public class BoardCriteria {
    
	private int page;
	private int perPageNum;

	
	public BoardCriteria() {
		this.page = 1;
		this.perPageNum = 10;
	}

	public void setPage(int page) {
		
		if (page <= 0) {
			this.page = 1;
			return;
		}
		
		this.page = page;
	}
	
	public void setPerPageNum(int perPageNum) {
		
		if (perPageNum <= 0 || perPageNum > 100) {
			this.perPageNum = 10;
			return;
		}
		
		this.perPageNum = perPageNum;
	}
	
	
	public int getPage() {
		return page;
	}

    // method for MyBatis SQL Mapper -
	public int getPageStart() {
		
		return (this.page - 1) * perPageNum;
	}
	
	
	public int getPerPageNum() {
		return this.perPageNum;
	}

	@Override
	public String toString() {
		return "BoardCriteria [page=" + page + ", perPageNum=" + perPageNum + "]";
	}

  
	
	
	
	
}
