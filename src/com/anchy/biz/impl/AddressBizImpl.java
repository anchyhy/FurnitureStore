package com.anchy.biz.impl;

import java.util.List;

import com.anchy.biz.AddressBiz;
import com.anchy.dao.AddressDao;
import com.anchy.dao.impl.AddressDaoImpl;
import com.anchy.po.Address;

public class AddressBizImpl implements AddressBiz {
	AddressDao addressDao=new AddressDaoImpl();
	@Override
	public List<Address> getAddressByUser(int uid) {
		// TODO Auto-generated method stub
		return addressDao.getAddressByUser(uid);
	}
	@Override
	public void delAddress(int aid) {
		// TODO Auto-generated method stub
		addressDao.delAddress(aid);
	}
	@Override
	public void addAddress(String p, String c, String d, String dt, int auid) {
		// TODO Auto-generated method stub
		addressDao.addAddress(p, c, d, dt, auid);
	}

}
