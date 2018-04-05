package com.anchy.biz.impl;

import java.util.List;

import com.anchy.biz.OrderBiz;
import com.anchy.dao.OrderDao;
import com.anchy.dao.impl.OrderDaoImpl;
import com.anchy.po.Order;

public class OrderBizImpl implements OrderBiz {
	OrderDao orderDao=new OrderDaoImpl();
	@Override
	public void addOrder(int tid, int uid, int aid, String message,int quantity) {
		// TODO Auto-generated method stub
		orderDao.addOrder(tid, uid, aid, message,quantity);
	}
	@Override
	public List<Order> getOrder(int ouid) {
		// TODO Auto-generated method stub
		return orderDao.getOrder(ouid);
	}
	@Override
	public List<Order> showSOrder(int uid) {
		// TODO Auto-generated method stub
		return orderDao.showSOrder(uid);
	}
	@Override
	public void sDispatch(int oid) {
		// TODO Auto-generated method stub
		orderDao.sDispatch(oid);
	}
	@Override
	public List<Order> showAOrder() {
		// TODO Auto-generated method stub
		return orderDao.showAOrder();
	}
	@Override
	public void agrOrder(int oid) {
		// TODO Auto-generated method stub
		orderDao.agrOrder(oid);
	}
	@Override
	public void receiveGoods(int oid) {
		// TODO Auto-generated method stub
		orderDao.receiveGoods(oid);
	}
	@Override
	public void evaluate(int oid, int rate) {
		// TODO Auto-generated method stub
		orderDao.evaluate(oid, rate);
	}
	
}
