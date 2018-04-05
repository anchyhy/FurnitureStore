package com.anchy.action;

import java.util.Map;

import com.anchy.biz.FirstBiz;
import com.anchy.biz.impl.FirstBizImpl;
import com.opensymphony.xwork2.ActionContext;

public class FirstAction {
	private int fid;
	private String fname;
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String showFirst(){
		FirstBiz firstBiz=new FirstBizImpl();
		Map<String, Object> session=ActionContext.getContext().getSession();
		session.put("firstList", firstBiz.getAllFirst());
		return "showfirst";
	}
	public String addFirst(){
		FirstBiz firstBiz=new FirstBizImpl();
		Map<String, Object> session=ActionContext.getContext().getSession();
		firstBiz.addFirst(fname);
		session.put("firstList", firstBiz.getAllFirst());
		return "addfirst";
	}
	public String delFirst(){
		FirstBiz firstBiz=new FirstBizImpl();
		Map<String, Object> session=ActionContext.getContext().getSession();
		firstBiz.delFirst(fid);
		session.put("firstList", firstBiz.getAllFirst());
		return "delfirst";
	}
	public String chgFirst(){
		FirstBiz firstBiz=new FirstBizImpl();
		Map<String, Object> session=ActionContext.getContext().getSession();
		firstBiz.chgFirst(fid, fname);
		session.put("firstList", firstBiz.getAllFirst());
		return "chgfirst";
	}
}
