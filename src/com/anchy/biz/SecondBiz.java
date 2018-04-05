package com.anchy.biz;

import java.util.List;
import java.util.Map;

import com.anchy.po.Second;

public interface SecondBiz {
	public Map<String,List<String>> getAllSecond();
	public void addSecond(String sname,int sfid);
	public void delSecond(int sid);
	public void chgSecond(int sid,String name);
}
