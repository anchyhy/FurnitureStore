package com.anchy.po;

public class Brand {
	private int bid;
	private String name;
	public Brand() {
		super();
	}
	public Brand(int bid, String name) {
		super();
		this.bid = bid;
		this.name = name;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
