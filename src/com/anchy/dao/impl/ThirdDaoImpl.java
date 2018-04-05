package com.anchy.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.anchy.dao.ThirdDao;
import com.anchy.po.Third;
import com.anchy.util.DBHelper;

public class ThirdDaoImpl implements ThirdDao {
	DBHelper db=new DBHelper();
	@Override
	public Map<String, List<String>> getAllThird() {
		// TODO Auto-generated method stub
		String sql="select concat(s.secondid,'.',s.`name`) as second, concat(t.thirdid,'.',t.`name`) as third from third t join second s on t.tsid=s.secondid";
		ResultSet rs=db.execQuery(sql, new Object[]{});
		Map<String,List<String>> data=new TreeMap<String,List<String>>();
		try {
			while(rs.next()){
				String second=rs.getString("second");
				String third=rs.getString("third");
				
				//*************↓Main Body↓**************************
				if(data.containsKey(second)){
					data.get(second).add(third);
				}else{
					data.put(second, new ArrayList<String>());
					data.get(second).add(third);
				}
				//*************↑Main Body↑**************************
			}
			return data;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addThird(String tname, int tsid) {
		// TODO Auto-generated method stub
		String sql="insert into third (name,tsid) values(?,?)";
		db.execOthers(sql, new Object[]{tname,tsid});
		

	}

	@Override
	public void delThird(int tid) {
		// TODO Auto-generated method stub
		String sql="delete from third where thirdid=?";
		db.execOthers(sql, new Object[]{tid});
	}

	@Override
	public List<Third> getSThird(int uid) {
		// TODO Auto-generated method stub
		String sql="select t.* from goods g join third t on t.thirdid=g.gtid where g.guid=? and g.flag=1 group by t.thirdid";
		ResultSet rs=db.execQuery(sql, new Object[]{uid});
		List<Third> thirdList=new ArrayList<Third>();
		try {
			while(rs.next()){
				Third third=new Third();
				third.setName(rs.getString("name"));
				third.setTid(rs.getInt("thirdid"));
				thirdList.add(third);
			}
			return thirdList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Third> getThird() {
		// TODO Auto-generated method stub
		String sql="select * from third";
		ResultSet rs=db.execQuery(sql, new Object[]{});
		List<Third> thirdList=new ArrayList<Third>();
		try {
			while(rs.next()){
				Third third=new Third();
				third.setTid(rs.getInt("thirdid"));
				third.setName(rs.getString("name"));
				thirdList.add(third);
			}
			return thirdList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void chgThird(int tid, String name) {
		// TODO Auto-generated method stub
		String sql="update third set name=? where thirdid=?";
		db.execOthers(sql, new Object[]{name,tid});
	}

}
