package com.anchy.po;

public class News {
	private int nid;
	private String title;
	private String time;
	private String content;
	public News() {
		super();
	}
	public News(int nid, String title, String time, String content) {
		super();
		this.nid = nid;
		this.title = title;
		this.time = time;
		this.content = content;
	}
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
