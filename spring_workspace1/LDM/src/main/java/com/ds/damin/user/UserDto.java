package com.ds.damin.user;

public class UserDto {

	private int u_seq = 0;
	private String u_manage = "";
	private String u_name = "";
	private String u_phone = "";
	private String u_zipcode = "";
	private String u_address1 = "";
	private String u_address2 = "";
	private int u_money = 0;
	private String u_password = "";
	private String u_password2 = "";
	private String u_email = "";
	private String u_delyn = "";
	
	

	public String getU_password2() {
		return u_password2;
	}

	public void setU_password2(String u_password2) {
		this.u_password2 = u_password2;
	}

	public String getU_delyn() {
		return u_delyn;
	}

	public void setU_delyn(String u_delyn) {
		this.u_delyn = u_delyn;
	}

	public String getU_email() {
		return u_email;
	}

	public void setU_email(String u_email) {
		this.u_email = u_email;
	}

	public int getU_seq() {
		return u_seq;
	}

	public void setU_seq(int u_seq) {
		this.u_seq = u_seq;
	}

	public String getU_manage() {
		return u_manage;
	}

	public void setU_manage(String u_manage) {
		this.u_manage = u_manage;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getU_phone() {
		return u_phone;
	}

	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}

	public String getU_zipcode() {
		return u_zipcode;
	}

	public void setU_zipcode(String u_zipcode) {
		this.u_zipcode = u_zipcode;
	}

	public String getU_address1() {
		return u_address1;
	}

	public void setU_address1(String u_address1) {
		this.u_address1 = u_address1;
	}

	public String getU_address2() {
		return u_address2;
	}

	public void setU_address2(String u_address2) {
		this.u_address2 = u_address2;
	}

	public int getU_money() {
		return u_money;
	}

	public void setU_money(int u_money) {
		this.u_money = u_money;
	}

	public String getU_password() {
		return u_password;
	}

	public void setU_password(String u_password) {
		this.u_password = u_password;
	}

	@Override
	public String toString() {
		return "UserDto [u_seq=" + u_seq + ", u_manage=" + u_manage + ", u_name=" + u_name + ", u_phone=" + u_phone
				+ ", u_zipcode=" + u_zipcode + ", u_address1=" + u_address1 + ", u_address2=" + u_address2
				+ ", u_money=" + u_money + ", u_password=" + u_password + "]";
	}

}
