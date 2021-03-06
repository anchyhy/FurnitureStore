package com.anchy.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.anchy.dao.SecondDao;
import com.anchy.po.First;
import com.anchy.po.Second;
import com.anchy.util.DBHelper;

public class SecondDaoImpl implements SecondDao {
	DBHelper db=new DBHelper();
	@Override
	public Map<String,List<String>> getAllSecond() {
		// TODO Auto-generated method stub
		String sql="select concat(f.firstid,'.',f.`name`) as first, concat(s.secondid,'.',s.`name`) as second from first f join second s on f.firstid=s.sfid";
		ResultSet rs=db.execQuery(sql, new Object[]{});
		Map<String,List<String>> data=new TreeMap<String,List<String>>();
		try {
			while(rs.next()){
				String first=rs.getString("first");
				String second=rs.getString("second");
				
				//*************↓Main Body↓**************************
				if(data.containsKey(first)){
					data.get(first).add(second);
				}else{
					data.put(first, new ArrayList<String>());
					data.get(first).add(second);
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
	public void addSecond(String sname, int sfid) {
		// TODO Auto-generated method stub
		String sql="insert into second (name,sfid) values(?,?)";
		db.execOthers(sql, new Object[]{sname,sfid});
	}

	@Override
	public void delSecond(int sid) {
		// TODO Auto-generated method stub
		String sql="delete from second where secondid=?";
		db.execOthers(sql, new Object[]{sid});
	}

	@Override
	public void chgSecond(int sid, String name) {
		// TODO Auto-generated method stub
		String sql="update second set name=? where secondid=?";
		db.execOthers(sql, new Object[]{name,sid});
	}

}
