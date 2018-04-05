package com.anchy.biz.impl;

import java.util.List;

import com.anchy.biz.CartBiz;
import com.anchy.dao.CartDao;
import com.anchy.dao.impl.CartDaoImpl;
import com.anchy.po.Cart;

public class CartBizImpl implements CartBiz {
	CartDao cartDao=new CartDaoImpl();
	@Override
	public boolean addCart(int uid, int gid,String kind, int n) {
		// TODO Auto-generated method stub
		return cartDao.addCart(uid, gid,kind, n);
	}
	@Override
	public double cSum(int cuid) {
		// TODO Auto-generated method stub
		return cartDao.cSum(cuid);
	}
	@Override
	public int cCount(int cuid) {
		// TODO Auto-generated method stub
		return cartDao.cCount(cuid);
	}
	@Override
	public List<Cart> getCartByUser(int uid) {
		// TODO Auto-generated method stub
		return cartDao.getCartByUser(uid);
	}
	@Override
	public Cart getCartByUserAndType(int uid,int tid){
		return cartDao.getCartByUserAndType(uid, tid);
	}
	@Override
	public void delCart(int cid) {
		// TODO Auto-generated method stub
		cartDao.delCart(cid);
	}
	@Override
	public int reduceQuantity(int uid, int tid) {
		// TODO Auto-generated method stub
		return cartDao.reduceQuantity(uid, tid);
	}
	@Override
	public int countByType(int uid, int tid) {
		// TODO Auto-generated method stub
		return cartDao.countByType(uid, tid);
	}
	@Override
	public int addQuantity(int uid, int tid) {
		// TODO Auto-generated method stub
		return cartDao.addQuantity(uid, tid);
	}

}
