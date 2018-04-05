package com.anchy.dao;

import java.util.List;

import com.anchy.po.Cart;

public interface CartDao {
	public boolean addCart(int uid,int gid,String kind,int n);
	public double cSum(int cuid);
	public int cCount(int cuid);
	public List<Cart> getCartByUser(int uid);
	public Cart getCartByUserAndType(int uid,int tid);
	public void delCart(int cid);
	public int reduceQuantity(int uid,int tid);
	public int addQuantity(int uid,int tid);
	public int countByType(int uid,int tid);
}
