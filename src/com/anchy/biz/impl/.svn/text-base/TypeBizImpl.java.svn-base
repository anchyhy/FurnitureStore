package com.anchy.biz.impl;

import java.util.List;

import com.anchy.biz.TypeBiz;
import com.anchy.dao.TypeDao;
import com.anchy.dao.impl.TypeDaoImpl;
import com.anchy.po.Type;

public class TypeBizImpl implements TypeBiz {
	TypeDao typeDao=new TypeDaoImpl();
	@Override
	public List<Type> getTypeByGoods(int gid) {
		// TODO Auto-generated method stub
		return typeDao.getTypeByGoods(gid);
	}
	@Override
	public Type getTypeById(int tid) {
		// TODO Auto-generated method stub
		return typeDao.getTypeById(tid);
	}
	@Override
	public int getTypeByKind(int gid, String kind) {
		// TODO Auto-generated method stub
		return typeDao.getTypeByKind(gid, kind);
	}
	@Override
	public void delSellerType(int gid, String kname) {
		// TODO Auto-generated method stub
		typeDao.delSellerType(gid, kname);
	}
	@Override
	public void changeTNum(int tid, int num) {
		// TODO Auto-generated method stub
		typeDao.changeTNum(tid, num);
	}
	@Override
	public void addType(int gid, String kind, String pname, int number) {
		// TODO Auto-generated method stub
		typeDao.addType(gid, kind, pname, number);
	}

}
