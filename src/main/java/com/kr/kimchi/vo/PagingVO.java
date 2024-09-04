package com.kr.kimchi.vo;

public class PagingVO {
	
	private int nowpage; // 현재 페이지 번호
	private int startpage; // 현재 페이지 그룹의 시작 페이지 번호
	private int endPage; // 현재 페이지 그룹의 끝 페이지 번호
	private int total; // 전체 데이터 개수
	private int cntPerPage; // 한 페이지당 보여줄 데이터 개수
	private int lastPage; // 총 페이지 수
	private int start; // SQL 쿼리에서 데이터 조회를 시작할 인덱스
	private int end; // SQL 쿼리에서 데이터 조회를 종료할 인덱스
	private int cntPage = 5; // 페이지 그룹의 크기 (기본값 5)
	
	// 기본 생성자
	public PagingVO() {
		super();
	}
	
	// 전체 데이터 수, 현재 페이지, 페이지당 데이터 수를 매개변수로 받는 생성자
	public PagingVO(int total, int nowPage, int cntPerPage) {
		super();
		this.nowpage = nowPage; // 현재 페이지 설정
		this.total = total; // 전체 데이터 수 설정
		this.cntPerPage = cntPerPage; // 페이지당 데이터 수 설정
	}
	
	// 마지막 페이지를 계산하는 메서드
	public void calcLastPage(int total, int cntPerPage) {
		setLastPage((int)Math.ceil((double)total / (double)cntPerPage)); // 올림으로 마지막 페이지 계산
	}

	// 시작 페이지와 끝 페이지를 계산하는 메서드
	public void clacStartEndPage(int nowPage, int cntPage) {
		setEndPage(((int)Math.ceil((double)nowPage / (double)cntPage)) * cntPage); // 끝 페이지 계산
		
		// 마지막 페이지를 초과하지 않도록 조정
		if(getLastPage() < getEndPage()) {
			setEndPage(getLastPage());
		}
		setStartpage(getEndPage() - cntPage + 1); // 시작 페이지 계산
		
		// 시작 페이지가 1보다 작지 않도록 조정
		if(getStartpage() < 1) {
			setStartpage(1);
		}	
	}
	
	// SQL 쿼리에서 사용할 시작 인덱스와 종료 인덱스를 계산하는 메서드
	public void calcStartEnd(int nowPage, int cntPerPage) {
		setEnd(nowPage * cntPerPage); // 종료 인덱스 계산
		setStart(getEnd() - cntPerPage + 1); // 시작 인덱스 계산
	}

	// Getter 및 Setter 메서드
	public int getNowpage() {
		return nowpage;
	}
	public void setNowpage(int nowpage) {
		this.nowpage = nowpage;
	}
	public int getStartpage() {
		return startpage;
	}
	public void setStartpage(int startpage) {
		this.startpage = startpage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getCntPerPage() {
		return cntPerPage;
	}
	public void setCntPerPage(int cntPerPage) {
		this.cntPerPage = cntPerPage;
	}
	public int getLastPage() {
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getCntPage() {
		return cntPage;
	}
	public void setCntPage(int cntpage) {
		this.cntPage = cntpage;
	}
}
