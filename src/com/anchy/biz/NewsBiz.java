package com.anchy.biz;

import java.util.List;

import com.anchy.po.News;

public interface NewsBiz {
	public List<News> getNews();
	public void addNews(String title,String time,String content);
	public void delNews(int nid);
}
