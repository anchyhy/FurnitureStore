package com.anchy.dao;

import java.util.List;

import com.anchy.po.First;

public interface FirstDao {
	public List<First> getAllFirst();
	public void addFirst(String fname);
	public void delFirst(int fid);
	public void chgFirst(int fid,String name);
}
