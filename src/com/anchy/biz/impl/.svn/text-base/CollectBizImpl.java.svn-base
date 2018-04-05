package com.anchy.biz.impl;

import java.util.List;

import com.anchy.biz.CollectBiz;
import com.anchy.dao.CollectDao;
import com.anchy.dao.impl.CollectDaoImpl;
import com.anchy.po.Collect;

public class CollectBizImpl implements CollectBiz {
	CollectDao collectDao=new CollectDaoImpl();
	@Override
	public void addCollect(int uid, int gid) {
		// TODO Auto-generated method stub
		collectDao.addCollect(uid, gid);
	}

	@Override
	public List<Collect> getCollect(int uid) {
		// TODO Auto-generated method stub
		return collectDao.getCollect(uid);
	}

	@Override
	public void delCollect(int cid) {
		// TODO Auto-generated method stub
		collectDao.delCollect(cid);
	}

}
