package com.anchy.dao.impl;

import com.anchy.dao.SeenDao;
import com.anchy.util.DBHelper;

public class SeenDaoImpl implements SeenDao {
	DBHelper db=new DBHelper(); 
	@Override
	public void addSeen(int uid, int gid) {
		// TODO Auto-generated method stub
		String sql="insert into seen(suid,sgid) values(?,?)";
		db.execOthers(sql, new Object[]{uid,gid});
	}

}
