package com.anchy.biz.impl;

import java.util.List;

import com.anchy.biz.FirstBiz;
import com.anchy.dao.FirstDao;
import com.anchy.dao.impl.FirstDaoImpl;
import com.anchy.po.First;

public class FirstBizImpl implements FirstBiz {
	FirstDao firstDao=new FirstDaoImpl();
	@Override
	public List<First> getAllFirst() {
		// TODO Auto-generated method stub
		return firstDao.getAllFirst();
	}

	@Override
	public void addFirst(String fname) {
		// TODO Auto-generated method stub
		firstDao.addFirst(fname);
	}

	@Override
	public void delFirst(int fid) {
		// TODO Auto-generated method stub
		firstDao.delFirst(fid);
	}

	@Override
	public void chgFirst(int fid, String name) {
		// TODO Auto-generated method stub
		firstDao.chgFirst(fid, name);
	}

}
