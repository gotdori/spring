package com.kosa.mycompany;

import com.kosa.mycompany.common.BaseDto;

public class HomeDto extends BaseDto{
	private String seq="";
	private String name="";
	private String image="";
	
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	
}
