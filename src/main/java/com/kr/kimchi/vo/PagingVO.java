package kr.co.kim.vo;

public class PagingVO {
	
	private int nowpage;//현재 페이지
	private int startpage;//시작 페이지
	private int endPage;//끝페이지
	private int total;//게시글 총 갯수
	private int cntPerPage;//페이지당 글 갯수
	private int lastPage;//마지막 페이지
	private int start;//SQL 쿼리에 쓸 start
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
	}// 제일 마지막 페이지 계산 ceil-> 자릿수 올림
	
	public void clacStartEndPage(int nowPage, int cntPage) {
		setEndPage(((int)Math.ceil((double)nowPage / (double)cntPage)) * cntPage);
		
		if(getLastPage()<getEndPage()) {
			setEndPage(getLastPage());
		}
		setStartpage(getEndPage()-cntPage+1);
		
		if(getStartpage() < 1) {
			setStartpage(1);
		}
		
	} //시작, 끝 페이지 계산
	
	
	public void calcStartEnd(int nowPage, int cntPerPage) {
		
		setEnd(nowPage*cntPerPage);
		setStart(getEnd()-cntPerPage+1);
	}// DB 쿼리에서 사용할 start, end값 계산




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
