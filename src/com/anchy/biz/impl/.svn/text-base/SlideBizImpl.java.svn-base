package com.anchy.biz.impl;

import java.util.List;

import com.anchy.biz.SlideBiz;
import com.anchy.dao.SlideDao;
import com.anchy.dao.impl.SlideDaoImpl;
import com.anchy.po.Slide;

public class SlideBizImpl implements SlideBiz {
	SlideDao slideDao=new SlideDaoImpl();
	@Override
	public List<Slide> getSlide() {
		// TODO Auto-generated method stub
		return slideDao.getSlide();
	}
	@Override
	public void delSlide(int sid) {
		// TODO Auto-generated method stub
		slideDao.delSlide(sid);
	}
	@Override
	public void addSlide(String photo, String saying) {
		// TODO Auto-generated method stub
		slideDao.addSlide(photo, saying);
	}

}
