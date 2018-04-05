package com.anchy.biz.impl;

import java.util.List;
import java.util.Map;

import com.anchy.biz.ThirdBiz;
import com.anchy.dao.ThirdDao;
import com.anchy.dao.impl.ThirdDaoImpl;
import com.anchy.po.Third;

public class ThirdBizImpl implements ThirdBiz {
	ThirdDao thirdDao=new ThirdDaoImpl();
	@Override
	public Map<String, List<String>> getAllThird() {
		// TODO Auto-generated method stub
		return thirdDao.getAllThird();
	}

	@Override
	public void addThird(String tname, int tsid) {
		// TODO Auto-generated method stub
		thirdDao.addThird(tname, tsid);
	}

	@Override
	public void delThird(int tid) {
		// TODO Auto-generated method stub
		thirdDao.delThird(tid);
	}

	@Override
	public List<Third> getSThird(int uid) {
		// TODO Auto-generated method stub
		return thirdDao.getSThird(uid);
	}

	@Override
	public List<Third> getThird() {
		// TODO Auto-generated method stub
		return thirdDao.getThird();
	}

	@Override
	public void chgThird(int tid, String name) {
		// TODO Auto-generated method stub
		thirdDao.chgThird(tid, name);
	}

}
