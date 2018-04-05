package com.anchy.biz.impl;

import java.util.List;

import com.anchy.biz.ComBiz;
import com.anchy.dao.ComDao;
import com.anchy.dao.impl.ComDaoImpl;
import com.anchy.po.Communicate;

public class ComBizImpl implements ComBiz {
	ComDao comDao=new ComDaoImpl();
	@Override
	public void addCom(int uid, String ask, String subject) {
		// TODO Auto-generated method stub
		comDao.addCom(uid, ask, subject);
	}
	@Override
	public List<Communicate> getComById(int uid) {
		// TODO Auto-generated method stub
		return comDao.getComById(uid);
	}
	@Override
	public void delCom(int comid) {
		// TODO Auto-generated method stub
		comDao.delCom(comid);
	}
	@Override
	public List<Communicate> getCom() {
		// TODO Auto-generated method stub
		return comDao.getCom();
	}
	@Override
	public void answer(int cid,String answer) {
		// TODO Auto-generated method stub
		comDao.answer(cid,answer);
	}

}
