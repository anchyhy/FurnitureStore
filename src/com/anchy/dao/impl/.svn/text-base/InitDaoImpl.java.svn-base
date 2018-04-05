package com.anchy.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.anchy.dao.InitDao;
import com.anchy.po.Classify;
import com.anchy.util.DBHelper;

public class InitDaoImpl implements InitDao {
	private DBHelper db=new DBHelper();
	//显示三级分类
	@Override
	public Map<String, Map<String,List<String>>> getClassify() {
		// TODO Auto-generated method stub
		String sql="select f.firstid,f.name as fname,s.secondid,s.name as sname,t.thirdid,t.name as tname from `first` f join `second` s on f.firstid=s.sfid join third t on s.secondid=t.tsid order by f.name";
		ResultSet rs=db.execQuery(sql, new Object[]{});
		Map<String, Map<String,List<String>>> data=new TreeMap<String, Map<String,List<String>>>();
		try {
			while(rs.next()){
				String fname=rs.getString("fname");
				String sname=rs.getString("sname");
				String tname=rs.getString("tname");
				
				//*************↓Main Body↓**************************
				if(data.containsKey(fname)){
					if(data.get(fname).containsKey(sname)){
						data.get(fname).get(sname).add(tname);
					}else{
						data.get(fname).put(sname, new ArrayList<String>());
						data.get(fname).get(sname).add(tname);
					}
				}else{
					data.put(fname, new TreeMap<String, List<String>>());
					data.get(fname).put(sname, new ArrayList<String>());
					data.get(fname).get(sname).add(tname);
				}
				//*************↑Main Body↑**************************
			}
			return data;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
