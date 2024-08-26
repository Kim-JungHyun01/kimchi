package com.kr.kimchi.vo;

import java.util.List;

public class PaPageLIst {
	private List<PaVO> povoList;
	private PaPageVO pageVO;
	
	// 기타 요소들
	
	public List<PaVO> getPovoList() {
		return povoList;
	}
	public void setPovoList(List<PaVO> povoList) {
		this.povoList = povoList;
	}
	public PaPageVO getPageVO() {
		return pageVO;
	}
	public void setPageVO(PaPageVO pageVO) {
		this.pageVO = pageVO;
	}
	
	
	
	public PaPageLIst() {

	}
	public PaPageLIst(List<PaVO> povoList, PaPageVO pageVO) {
		this.povoList = povoList;
		this.pageVO = pageVO;
	}
	
	@Override
	public String toString() {
		return "POPageList [povoList=" + povoList + ", pageVO=" + pageVO + "]";
	}
	
	
}
