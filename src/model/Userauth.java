package model;

import java.io.Serializable;
import java.sql.Date;

public class Userauth implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userid,pass,state,auth;
	private int reflg;
	private Date lastlogin,certifytime;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getReflg() {
		return reflg;
	}
	public void setReflg(int reflg) {
		this.reflg = reflg;
	}
	public Date getLastlogin() {
		return lastlogin;
	}
	public void setLastlogin(Date lastlogin) {
		this.lastlogin = lastlogin;
	}
	public Date getCertifytime() {
		return certifytime;
	}
	public void setCertifytime(Date certifytime) {
		this.certifytime = certifytime;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}

}
