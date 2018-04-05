package com.anchy.biz.impl;

import java.util.List;

import com.anchy.biz.StyleBiz;
import com.anchy.dao.StyleDao;
import com.anchy.dao.impl.StyleDaoImpl;
import com.anchy.po.Style;

public class StyleBizImpl implements StyleBiz {
	StyleDao styleDao=new StyleDaoImpl();
	@Override
	public List<Style> getByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return styleDao.getByKeyword(keyword);
	}
	@Override
	public List<Style> getAllStyle() {
		// TODO Auto-generated method stub
		return styleDao.getAllStyle();
	}

}
