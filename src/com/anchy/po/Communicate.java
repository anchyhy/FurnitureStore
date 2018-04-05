package com.anchy.po;

import java.io.Serializable;

public class Communicate implements Serializable {
	private int cid;
	private String ask;
	private String answer;
	private int flag;
	private String subject;
	private User user;
	public Communicate() {
		super();
	}
	public Communicate(int cid, String ask, String answer, int flag,
			String subject, User user) {
		super();
		this.cid = cid;
		this.ask = ask;
		this.answer = answer;
		this.flag = flag;
		this.subject = subject;
		this.user = user;
	}
	public int getcid() {
		return cid;
	}
	public void setcid(int cid) {
		this.cid = cid;
	}
	public String getAsk() {
		return ask;
	}
	public void setAsk(String ask) {
		this.ask = ask;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
