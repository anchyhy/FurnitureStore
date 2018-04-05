package com.anchy.biz;

import java.util.List;

import com.anchy.po.Slide;

public interface SlideBiz {
	public List<Slide> getSlide();
	public void delSlide(int sid);
	public void addSlide(String photo,String saying);
}
