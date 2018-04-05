package com.anchy.dao;

import java.util.List;
import java.util.Map;

import com.anchy.po.Third;

public interface ThirdDao {
	public Map<String,List<String>> getAllThird();
	public void addThird(String tname,int tsid);
	public void delThird(int tid);
	public List<Third> getSThird(int uid);
	public List<Third> getThird();
	public void chgThird(int tid,String name);
}
