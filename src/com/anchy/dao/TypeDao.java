package com.anchy.dao;

import java.util.List;

import com.anchy.po.Type;

public interface TypeDao {
	public List<Type> getTypeByGoods(int gid);
	public Type getTypeById(int tid);
	public int getTypeByKind(int gid,String kind);
	public void delSellerType(int gid,String kname);
	public void changeTNum(int tid,int num);
	public void addType(int gid,String kind,String pname,int number);
}
