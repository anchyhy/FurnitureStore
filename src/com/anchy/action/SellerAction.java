package com.anchy.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.anchy.biz.SellerBiz;
import com.anchy.biz.impl.SellerBizImpl;
import com.anchy.po.Seller;
import com.anchy.po.User;
import com.opensymphony.xwork2.ActionContext;

public class SellerAction {
	private int uid;
	private int sid;
	private String  message;
	private User user;
	private SellerBiz sellerBiz=new SellerBizImpl();
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public SellerBiz getSellerBiz() {
		return sellerBiz;
	}
	public void setSellerBiz(SellerBiz sellerBiz) {
		this.sellerBiz = sellerBiz;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String sellerFlag(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("sellerflag", sellerBiz.SellerFlag(uid));
		session.put("DisAgrMsg", sellerBiz.getReason(uid));
		return "sellerflag";
	}
	public String checkSeller(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		List<Seller> sellerList=new ArrayList<Seller>();
		sellerList=sellerBiz.getBeingSeller();
		session.put("sellerList", sellerList);
		session.remove("reloadmessage");
		return "checkseller";
	}
	public String agrSeller(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		sellerBiz.agrSeller(uid);
		List<Seller> sellerList=new ArrayList<Seller>();
		sellerList=sellerBiz.getBeingSeller();
		session.put("sellerList", sellerList);
		session.put("reloadmessage", "1");
		return "agrseller";
	}
	public String disAgrSeller(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		sellerBiz.disAgrSeller(sid, message);
		List<Seller> sellerList=new ArrayList<Seller>();
		sellerList=sellerBiz.getBeingSeller();
		session.put("sellerList", sellerList);
		session.put("reloadmessage", "1");
		return "disagrseller";
	}
	public String reUpdate(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		sellerBiz.reUpdate(uid);
		session.put("sellerflag", sellerBiz.SellerFlag(uid));
		return "reupdate";
	}
}
