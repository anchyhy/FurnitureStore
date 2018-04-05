package com.anchy.dao;

import java.util.List;

import com.anchy.po.Collect;

public interface CollectDao {
	public void addCollect(int uid,int gid);
	public List<Collect> getCollect(int uid);
	public void delCollect(int cid);
}
