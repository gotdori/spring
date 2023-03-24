package com.kosa.myapp1.인터페이스;

public class BoardDto {
	private String title="";
	private String writer="";
	private String contents="";
	
	public BoardDto() {
		super();
		//기본 생성자의 경우에는 사용자가 만들지 않으면 시스템이 만들어서라도 호출, 사용자가 디폴트 생성자(매개변수없는 생성자)를
		//만들지 않고 매개변수 있는 다른 생성자를 만들면 시스템이 만들던 디폴트 생성자조차 안만든다.
		//그래서 객체 생성시 기본생성이 안된다.
		//다른 생성자 만들 때 꼭 디폴트 생성자도 꼭 만들자.
	}

	public BoardDto(String title, String writer, String contents) {
		super();
		this.title = title;
		this.writer = writer;
		this.contents = contents;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	@Override
	public String toString() {
		return String.format("%s %s %s", title, writer, contents);
	}
	

	
}
