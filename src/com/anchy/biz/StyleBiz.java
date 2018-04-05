package com.anchy.biz;

import java.util.List;

import com.anchy.po.Style;

public interface StyleBiz {
	public List<Style> getByKeyword(String keyword);
	public List<Style> getAllStyle();

}
