package model;

import java.io.Serializable;

public class Userinfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userid,address,mail;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

}
