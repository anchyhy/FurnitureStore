package com.anchy.action;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.anchy.biz.AddressBiz;
import com.anchy.biz.NewsBiz;
import com.anchy.biz.impl.AddressBizImpl;
import com.anchy.biz.impl.NewsBizImpl;
import com.anchy.po.News;
import com.opensymphony.xwork2.ActionContext;

public class NewsAction {
	private int nid;
	private String title;
	private String time;
	private String content;
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
	public String about(){
		Map<String, Object> session=ActionContext.getContext().getSession();
		NewsBiz newsBiz=new NewsBizImpl();
		List<News> newsList=new ArrayList<News>();
		newsList=newsBiz.getNews();
		session.put("newsList", newsList);
		return "about";
	}
	public String showNews(){
		Map<String, Object> session=ActionContext.getContext().getSession();
		NewsBiz newsBiz=new NewsBizImpl();
		List<News> newsList=new ArrayList<News>();
		newsList=newsBiz.getNews();
		session.put("newsList", newsList);
		return "shownews";
	}
	public String allNews(){
		Map<String, Object> session=ActionContext.getContext().getSession();
		NewsBiz newsBiz=new NewsBizImpl();
		List<News> newsList=new ArrayList<News>();
		newsList=newsBiz.getNews();
		session.put("newsList", newsList);
		return "allnews";
	}
	public String addNews () throws UnsupportedEncodingException{
		Map<String, Object> session=ActionContext.getContext().getSession();
		NewsBiz newsBiz=new NewsBizImpl();
		this.title = new String(title.getBytes("ISO-8859-1"), "UTF-8");
		this.content = new String(content.getBytes("ISO-8859-1"), "UTF-8");
		newsBiz.addNews(title, new SimpleDateFormat("YYYY-MM-dd").format(new Date()).toString(), content);
		List<News> newsList=new ArrayList<News>();
		newsList=newsBiz.getNews();
		session.put("newsList", newsList);
		return "addnews";
	}
	public String delNews(){
		Map<String, Object> session=ActionContext.getContext().getSession();
		NewsBiz newsBiz=new NewsBizImpl();
		System.out.println("nid="+nid);
		newsBiz.delNews(nid);
		List<News> newsList=new ArrayList<News>();
		newsList=newsBiz.getNews();
		session.put("newsList", newsList);
		return "delnews";
	}
}
