package com.anchy.biz.impl;

import java.util.List;

import com.anchy.biz.SellerBiz;
import com.anchy.dao.SellerDao;
import com.anchy.dao.impl.SellerDaoImpl;
import com.anchy.po.Seller;

public class SellerBizImpl implements SellerBiz {
	SellerDao sellerDao=new SellerDaoImpl();
	@Override
	public void addSeller(int suid, String photo1, String photo2, String photo3) {
		// TODO Auto-generated method stub
		sellerDao.addSeller(suid, photo1, photo2, photo3);
	}
	@Override
	public int SellerFlag(int suid) {
		// TODO Auto-generated method stub
		return sellerDao.SellerFlag(suid);
	}
	@Override
	public int cSeller() {
		// TODO Auto-generated method stub
		return sellerDao.cSeller();
	}
	@Override
	public List<Seller> getBeingSeller() {
		// TODO Auto-generated method stub
		return sellerDao.getBeingSeller();
	}
	@Override
	public void agrSeller(int suid) {
		// TODO Auto-generated method stub
		sellerDao.agrSeller(suid);
	}
	@Override
	public void disAgrSeller(int sid, String message) {
		// TODO Auto-generated method stub
		sellerDao.disAgrSeller(sid, message);
	}
	@Override
	public void reUpdate(int uid) {
		// TODO Auto-generated method stub
		sellerDao.reUpdate(uid);
	}
	@Override
	public String getReason(int uid) {
		// TODO Auto-generated method stub
		return sellerDao.getReason(uid);
	}

}
