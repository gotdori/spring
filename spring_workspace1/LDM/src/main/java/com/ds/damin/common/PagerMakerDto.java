package com.ds.damin.common;

public class PagerMakerDto {
	private int startPage = 1;
	private int endPage = 1;
	private boolean prev, next;
	private int total = 0; // 전체 게시물 수
	private Criteria cri; // 현재 페이지, 페이지당 게시물 갯수 정보

	public PagerMakerDto() {
	}

	public PagerMakerDto(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;

		this.endPage = (int) (Math.ceil(cri.getPageNum() / 10.0)) * 10; // 마지막 페이지
		int realEnd = (int) (Math.ceil(total * 1.0 / cri.getAmount())); // 마지막 페이지
		if (realEnd < this.endPage) // 전체 마지막 페이지(realEnd)가 화면에 보이는 마지막 페이지(endPage)보다 작은 경우, 보이는 페이지(endPage) 값 조정
			this.endPage = realEnd;
		int start = this.endPage - 9;
		start = start  < 1 ? 1 :start;
		this.startPage = start; // 시작페이지
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
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

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}

	@Override
	public String toString() {
		return "PagerMakerDto [startPage=" + startPage + ", endPage=" + endPage + ", prev=" + prev + ", next=" + next
				+ ", total=" + total + ", cri=" + cri + "]";
	}
	

}
