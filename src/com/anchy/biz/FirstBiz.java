package com.anchy.biz;

import java.util.List;

import com.anchy.po.First;

public interface FirstBiz {
	public List<First> getAllFirst();
	public void addFirst(String fname);
	public void delFirst(int fid);
	public void chgFirst(int fid,String name);
}
