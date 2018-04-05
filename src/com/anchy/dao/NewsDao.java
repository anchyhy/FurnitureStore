package com.anchy.dao;

import java.util.List;

import com.anchy.po.News;

public interface NewsDao {
	public List<News> getNews();
	public void addNews(String title,String time,String content);
	public void delNews(int nid);
}
