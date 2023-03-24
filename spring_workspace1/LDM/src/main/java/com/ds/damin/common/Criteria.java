package com.ds.damin.common;

public class Criteria {

	private int pageNum=0; //현재 페이지
	private int amount=0; //한 페이지 당 보여질 게시물 갯수
	private String num="1"; //신상, 높은가격, 낮은가격 구분
	private String cate="('SH','CL')"; // 전체, 신발, 옷 카테고리 보기
	
	public Criteria() {
		this(1,9);
	}
	
	@Override
	public String toString() {
		return "Criteria [pageNum=" + pageNum + ", amount=" + amount + ", num=" + num + ", cate=" + cate + "]";
	}

	public Criteria(int pageNum, int amount) {
		super();
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	public String getCate() {
		return cate;
	}

	public void setCate(String cate) {
		this.cate = cate;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}
