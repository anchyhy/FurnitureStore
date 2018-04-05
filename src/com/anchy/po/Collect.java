package com.anchy.po;

public class Collect {
	private int cid;
	private Goods goods;
	private User user;
	public Collect() {
		super();
	}
	public Collect(int cid, Goods goods, User user) {
		super();
		this.cid = cid;
		this.goods = goods;
		this.user = user;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
