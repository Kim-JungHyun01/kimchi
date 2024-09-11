package com.kr.kimchi.vo;

public class PaPageVO {
	private int startPage;	// ����������
	private int endPage;	// ������ ������
	private boolean prev, next;
	private int pageNum; // ���� ������
	private int total; // �� ������
	
	private int start = 1; //����¡ ����
	private int end = 2; //�ѹ��� ������ ����¡ ��ȣ ���� basic : 5
	private int listcnt = 2; //���������� ������ ����Ʈ �� basic : 10
	
	
	public PaPageVO(int pageNum, int list) {
		this.pageNum = pageNum;
		this.total = (int)Math.ceil(list/(this.listcnt*1.0));
		
		this.endPage = (int)Math.ceil(pageNum/(end*1.0))*end;
		this.startPage = this.endPage - (this.end-1);
		
		if(total < this.endPage) {
			this.endPage = total;
		}
		this.prev = this.startPage > 1;
		this.next = this.endPage < total;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
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

	public int getListcnt() {
		return listcnt;
	}

	public void setListcnt(int listcnt) {
		this.listcnt = listcnt;
	}

	@Override
	public String toString() {
		return "POPageVO [startPage=" + startPage + ", endPage=" + endPage + ", prev=" + prev + ", next=" + next
				+ ", total=" + total + ", pageNum=" + pageNum + ", start=" + start + ", end=" + end + ", listcnt="
				+ listcnt + "]";
	}
	
	
	
}