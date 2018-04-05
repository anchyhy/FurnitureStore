package com.anchy.biz;

import java.util.List;

import com.anchy.po.Communicate;

public interface ComBiz {
	public void addCom(int uid,String ask,String subject);
	public List<Communicate> getComById(int uid);
	public void delCom(int comid);
	public List<Communicate> getCom();
	public void answer(int cid,String answer);

}
