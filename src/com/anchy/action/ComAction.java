package com.anchy.action;

import java.util.Map;

import com.anchy.biz.ComBiz;
import com.anchy.biz.impl.ComBizImpl;
import com.opensymphony.xwork2.ActionContext;



public class ComAction {
	private int cid;
	private String ask;
	private String answer;
	private int flag;
	private String subject;
	private int uid;
	
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
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

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}
	public String contact(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		ComBiz comBiz=new ComBizImpl();
		session.put("comList", comBiz.getComById(uid));
		return "contact";
	}
	public String addCom(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		ComBiz comBiz=new ComBizImpl();
		comBiz.addCom(uid, ask, subject);
		session.put("comList", comBiz.getComById(uid));
		return "addcom";
	}
	public String delCom(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		ComBiz comBiz=new ComBizImpl();
		comBiz.delCom(cid);
		session.put("comList", comBiz.getComById(uid));
		return "delcom";
	}
	public String adminCom(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.remove("reloadmessage");
		ComBiz comBiz=new ComBizImpl();
		session.put("acomList", comBiz.getCom());
		session.put("acsum", comBiz.getCom().size());
		return "admincom";
	}
	public String answer(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		ComBiz comBiz=new ComBizImpl();
		comBiz.answer(cid, answer);
		session.put("acomList", comBiz.getCom());
		session.put("acsum", comBiz.getCom().size());
		session.put("reloadmessage", "4");
		return "answer";
	}
}
