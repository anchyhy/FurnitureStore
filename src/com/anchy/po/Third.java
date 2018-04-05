package com.anchy.po;

import java.io.Serializable;

public class Third implements Serializable {
	private int tid;
	private String name;
	private Second second;
	public Third() {
		super();
	}
	public Third(int tid, String name, Second second) {
		super();
		this.tid = tid;
		this.name = name;
		this.second = second;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Second getSecond() {
		return second;
	}
	public void setSecond(Second second) {
		this.second = second;
	}
	
}
