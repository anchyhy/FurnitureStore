package com.anchy.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.anchy.dao.FirstDao;
import com.anchy.po.First;
import com.anchy.util.DBHelper;

public class FirstDaoImpl implements FirstDao {
	DBHelper db=new DBHelper();
	@Override
	public List<First> getAllFirst() {
		// TODO Auto-generated method stub
		String sql="select * from first";
		ResultSet rs=db.execQuery(sql, new Object[]{});
		List<First> firstList=new ArrayList<First>();
		try {
			while(rs.next()){
				First first=new First();
				first.setfid(rs.getInt("firstid"));
				first.setName(rs.getString("name"));
				firstList.add(first);
			}
			return firstList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addFirst(String fname) {
		// TODO Auto-generated method stub
		String sql="insert into first (name) values(?)";
		db.execOthers(sql, new Object[]{fname});
	}

	@Override
	public void delFirst(int fid) {
		// TODO Auto-generated method stub
		String sql="delete from first where firstid=?";
		db.execOthers(sql, new Object[]{fid});
	}

	@Override
	public void chgFirst(int fid, String name) {
		// TODO Auto-generated method stub
		String sql="update first set name=? where firstid=?";
		db.execOthers(sql, new Object[]{name,fid});
	}

}
