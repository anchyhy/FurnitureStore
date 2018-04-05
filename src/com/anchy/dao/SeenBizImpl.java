package com.anchy.dao;

import com.anchy.biz.SeenBiz;
import com.anchy.dao.impl.SeenDaoImpl;

public class SeenBizImpl implements SeenBiz {
	SeenDao seenDao=new SeenDaoImpl();
	@Override
	public void addSeen(int uid, int gid) {
		// TODO Auto-generated method stub
		seenDao.addSeen(uid, gid);
	}

}
