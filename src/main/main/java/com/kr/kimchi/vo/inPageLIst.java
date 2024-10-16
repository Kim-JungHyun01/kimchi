package com.kr.kimchi.vo;

import java.util.List;

public class inPageLIst {
	private List<InlistVO> inList;
	private PaPageVO pageVO;

	public List<InlistVO> getInList() {
		return inList;
	}

	public void setInList(List<InlistVO> inList) {
		this.inList = inList;
	}

	public PaPageVO getPageVO() {
		return pageVO;
	}

	public void setPageVO(PaPageVO pageVO) {
		this.pageVO = pageVO;
	}

	public inPageLIst(List<InlistVO> inList, PaPageVO pageVO) {
		this.inList = inList;
		this.pageVO = pageVO;
	}

	public inPageLIst() {
	}

	@Override
	public String toString() {
		return "inPageLIst [inList=" + inList + ", pageVO=" + pageVO + "]";
	}

}
