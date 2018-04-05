package com.anchy.biz.impl;

import java.util.List;
import java.util.Map;

import com.anchy.biz.SecondBiz;
import com.anchy.dao.SecondDao;
import com.anchy.dao.impl.SecondDaoImpl;
import com.anchy.po.Second;

public class SecondBizImpl implements SecondBiz {
	SecondDao secondDao=new SecondDaoImpl();
	@Override
	public Map<String,List<String>> getAllSecond() {
		// TODO Auto-generated method stub
		return secondDao.getAllSecond();
	}

	@Override
	public void addSecond(String sname, int sfid) {
		// TODO Auto-generated method stub
		secondDao.addSecond(sname, sfid);
	}

	@Override
	public void delSecond(int sid) {
		// TODO Auto-generated method stub
		secondDao.delSecond(sid);
	}

	@Override
	public void chgSecond(int sid, String name) {
		// TODO Auto-generated method stub
		secondDao.chgSecond(sid, name);
	}

}
