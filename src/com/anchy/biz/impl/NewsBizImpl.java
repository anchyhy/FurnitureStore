package com.anchy.biz.impl;

import java.util.List;

import com.anchy.biz.NewsBiz;
import com.anchy.dao.NewsDao;
import com.anchy.dao.impl.NewsDaoImpl;
import com.anchy.po.News;

public class NewsBizImpl implements NewsBiz {
	NewsDao newsDao=new NewsDaoImpl();
	@Override
	public List<News> getNews() {
		// TODO Auto-generated method stub
		return newsDao.getNews();
	}

	@Override
	public void addNews(String title, String time, String content) {
		// TODO Auto-generated method stub
		newsDao.addNews(title, time, content);
	}

	@Override
	public void delNews(int nid) {
		// TODO Auto-generated method stub
		newsDao.delNews(nid);
	}

}
