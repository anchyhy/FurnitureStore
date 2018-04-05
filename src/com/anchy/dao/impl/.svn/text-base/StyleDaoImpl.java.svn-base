package com.anchy.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.anchy.dao.StyleDao;
import com.anchy.po.Style;
import com.anchy.util.DBHelper;

public class StyleDaoImpl implements StyleDao {
	DBHelper db=new DBHelper();
	@Override
	public List<Style> getByKeyword(String keyword) {
		// TODO Auto-generated method stub
		String sql="select count(*),s.* from style s join goods g on g.gsid=s.styleid where (g.`name` like ? or g.info like ?) and g.flag=1 group by s.styleid order by count(*) DESC limit 0,5";
		ResultSet rs=db.execQuery(sql, new Object[]{"%"+keyword+"%","%"+keyword+"%"});
		List<Style> sList=new ArrayList<Style>();
		try {
			while(rs.next()){
				Style s=new Style();
				s.setName(rs.getString("name"));
				s.setSid(rs.getInt("styleid"));
				sList.add(s);
			}
			return sList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Style> getAllStyle() {
		// TODO Auto-generated method stub
		String sql="select * from style";
		ResultSet rs=db.execQuery(sql, new Object[]{});
		List<Style> sList=new ArrayList<Style>();
		try {
			while(rs.next()){
				Style s=new Style();
				s.setName(rs.getString("name"));
				s.setSid(rs.getInt("styleid"));
				sList.add(s);
			}
			return sList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
