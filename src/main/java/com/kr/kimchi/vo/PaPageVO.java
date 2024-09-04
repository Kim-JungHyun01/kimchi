package kr.co.kim.vo;

public class PaPageVO {
	private int startPage;	// 시작페이지
	private int endPage;	// 마지막 페이지
	private boolean prev, next;
	private int pageNum; // 현재 페이지
	private int total; // 총 페이지
	
	private int start = 1; //페이징 시작
	private int end = 2; //한번에 보여줄 페이징 번호 갯수 basic : 5
	private int listcnt = 2; //한페이지에 보여줄 리스트 수 basic : 10
	
	
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