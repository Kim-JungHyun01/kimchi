package com.kr.kimchi.vo;

public class PagingVO {
	
	private int nowpage;//���� ������
	private int startpage;//���� ������
	private int endPage;//��������
	private int total;//�Խñ� �� ����
	private int cntPerPage;//�������� �� ����
	private int lastPage;//������ ������
	private int start;//SQL ������ �� start
	private int end;// end
	private int cntPage=5;
	
	
	

	public PagingVO() {
		super();
	}
	
	
	
	
	public PagingVO(int total, int nowPage, int cntPerPage) {
		super();
		this.nowpage = nowpage;
		this.total = total;
		this.cntPerPage = cntPerPage;
	}
	
	public void calcLastPage(int total, int cntPerPage) {
		setLastPage((int)Math.ceil((double)total/(double)cntPerPage));	
	}// ���� ������ ������ ��� ceil-> �ڸ��� �ø�
	
	public void clacStartEndPage(int nowPage, int cntPage) {
		setEndPage(((int)Math.ceil((double)nowPage / (double)cntPage)) * cntPage);
		
		if(getLastPage()<getEndPage()) {
			setEndPage(getLastPage());
		}
		setStartpage(getEndPage()-cntPage+1);
		
		if(getStartpage() < 1) {
			setStartpage(1);
		}
		
	} //����, �� ������ ���
	
	
	public void calcStartEnd(int nowPage, int cntPerPage) {
		
		setEnd(nowPage*cntPerPage);
		setStart(getEnd()-cntPerPage+1);
	}// DB �������� ����� start, end�� ���




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
