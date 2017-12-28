package model;

import java.io.Serializable;

public class Orderm implements Serializable {
	private int  sid,price,chunum,chumnum;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getChunum() {
		return chunum;
	}

	public void setChunum(int chunum) {
		this.chunum = chunum;
	}

	public int getChumnum() {
		return chumnum;
	}

	public void setChumnum(int chumnum) {
		this.chumnum = chumnum;
	}
	

}
