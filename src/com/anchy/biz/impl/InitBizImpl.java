package com.anchy.biz.impl;

import java.util.List;
import java.util.Map;

import com.anchy.biz.InitBiz;
import com.anchy.dao.InitDao;
import com.anchy.dao.impl.InitDaoImpl;
import com.anchy.po.Classify;

public class InitBizImpl implements InitBiz {
	InitDao initDao=new InitDaoImpl();
	@Override
	public Map<String, Map<String,List<String>>> getClassify() {
		// TODO Auto-generated method stub
		return initDao.getClassify();
	}

}
