package com.anchy.po;

import java.io.Serializable;

public class Slide implements Serializable {
	private int sid;
	private String photo;
	private String saying;
	public Slide() {
		super();
	}
	public Slide(int sid, String photo, String saying) {
		super();
		this.sid = sid;
		this.photo = photo;
		this.saying = saying;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getSaying() {
		return saying;
	}
	public void setSaying(String saying) {
		this.saying = saying;
	}
	
}
