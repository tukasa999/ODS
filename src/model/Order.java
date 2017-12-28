package model;

import java.io.Serializable;
import java.sql.Date;

public class Order implements Serializable{
	private int chunum,gprice;
	private Date buydate;
	private String uid;
	public int getChunum() {
		return chunum;
	}
	public void setChunum(int chunum) {
		this.chunum = chunum;
	}
	public int getGprice() {
		return gprice;
	}
	public void setGprice(int gprice) {
		this.gprice = gprice;
	}
	public Date getBuydate() {
		return buydate;
	}
	public void setBuydate(Date buydate) {
		this.buydate = buydate;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	

}
