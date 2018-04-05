package com.anchy.action;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import com.anchy.biz.CartBiz;
import com.anchy.biz.impl.CartBizImpl;
import com.anchy.po.Type;
import com.anchy.po.User;
import com.opensymphony.xwork2.ActionContext;

public class CartAction {
	private int cid;
	private User user;
	private int uid;
	private Type type;
	private int gid;
	private String kind;
	private int ctid;
	private int quantity;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public int getCtid() {
		return ctid;
	}
	public void setCtid(int ctid) {
		this.ctid = ctid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String addCart()throws UnsupportedEncodingException{
		Map<String, Object> session=ActionContext.getContext().getSession();
		this.kind = new String(kind.getBytes("ISO-8859-1"), "UTF-8");
		CartBiz cartBiz=new CartBizImpl();
		cartBiz.addCart(uid, gid,kind,quantity);
		session.put("ccount",cartBiz.cCount(uid));
		session.put("csum", cartBiz.cSum(uid));
		session.put("showMessage", "<script type='text/javascript'> alert('加入购物车成功')</script>");
		return "addcart";
	}
	public String getCart(){
		Map<String, Object> session=ActionContext.getContext().getSession();
		CartBiz cartBiz=new CartBizImpl();
		session.put("cartList", cartBiz.getCartByUser(uid));
		return "getcart";
	}
	public String reduceQuantity(){
		Map<String, Object> session=ActionContext.getContext().getSession();
		CartBiz cartBiz=new CartBizImpl();
		cartBiz.reduceQuantity(uid, ctid);
		session.put("cartList", cartBiz.getCartByUser(uid));
		return "reducequantity";
	}
	public String addQuantity(){
		Map<String, Object> session=ActionContext.getContext().getSession();
		CartBiz cartBiz=new CartBizImpl();
		System.out.println(uid+"[[["+ctid);
		cartBiz.addQuantity(uid, ctid);
		session.put("cartList", cartBiz.getCartByUser(uid));
		return "addquantity";
	}
	public String delCart(){
		Map<String, Object> session=ActionContext.getContext().getSession();
		CartBiz cartBiz=new CartBizImpl();
		cartBiz.delCart(cid);
		session.put("cartList", cartBiz.getCartByUser(uid));
		session.put("ccount",cartBiz.cCount(uid));
		session.put("csum", cartBiz.cSum(uid));
		return "delcart";
	}
}
