package com.anchy.action;

import java.util.Map;

import com.anchy.biz.CollectBiz;
import com.anchy.biz.impl.CollectBizImpl;
import com.opensymphony.xwork2.ActionContext;

public class CollectAction {
	private int cid;
	private int uid;
	private int gid;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String addCollect(){
		Map<String, Object> session=ActionContext.getContext().getSession();
		CollectBiz cBiz=new CollectBizImpl();
		cBiz.addCollect(uid, gid);
		session.put("collectList", cBiz.getCollect(uid));
		return "addcollect";
	}
	public String delCollect(){
		Map<String, Object> session=ActionContext.getContext().getSession();
		CollectBiz cBiz=new CollectBizImpl();
		cBiz.delCollect(cid);
		session.put("collectList", cBiz.getCollect(uid));
		return "delcollect";
	}
	public String getCollect(){
		Map<String, Object> session=ActionContext.getContext().getSession();
		CollectBiz cBiz=new CollectBizImpl();
		session.put("collectList", cBiz.getCollect(uid));
		return "getcollect";
	}
}
