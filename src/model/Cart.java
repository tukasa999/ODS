package model;

import java.io.Serializable;

public class Cart implements Serializable {
	private int cartid,s_id;
	private String userid;

	public int getCartid() {
		return cartid;
	}

	public void setCartid(int cartid) {
		this.cartid = cartid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String string) {
		this.userid = string;
	}

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	

}
