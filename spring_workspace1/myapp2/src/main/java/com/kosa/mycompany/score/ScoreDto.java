package com.kosa.mycompany.score;

public class ScoreDto {
	private String	seq ="";
	private String	name ="";
	private String	kor ="";
	private String	eng ="";
	private String	mat ="";
	private String	wdate ="";
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKor() {
		return kor;
	}
	public void setKor(String kor) {
		this.kor = kor;
	}
	public String getEng() {
		return eng;
	}
	public void setEng(String eng) {
		this.eng = eng;
	}
	public String getMat() {
		return mat;
	}
	public void setMat(String mat) {
		this.mat = mat;
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	@Override
	public String toString() {
		return "ScoreDto [seq=" + seq + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ", mat=" + mat + ", wdate="
				+ wdate + "]";
	}
	
	
	
	
}
