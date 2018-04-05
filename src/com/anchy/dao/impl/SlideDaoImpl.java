package com.anchy.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.anchy.dao.SlideDao;
import com.anchy.po.Slide;
import com.anchy.util.DBHelper;

public class SlideDaoImpl implements SlideDao {
	DBHelper db=new DBHelper();
	//获取网站轮播图
	@Override
	public List<Slide> getSlide() {
		// TODO Auto-generated method stub
		String sql="select * from slide";
		ResultSet rs= db.execQuery(sql, new Object[]{});
		List<Slide> slideList =new ArrayList<Slide>();
		try {
			
			while(rs.next()){
				Slide slide=new Slide();
				slide.setPhoto(rs.getString("photo"));
				slide.setSaying(rs.getString("saying"));
				slide.setSid(rs.getInt("slideid"));
				slideList.add(slide);
			}
			return slideList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public void delSlide(int sid) {
		// TODO Auto-generated method stub
		String sql="delete from slide where slided=?";
		db.execOthers(sql, new Object[]{sid});
	}
	@Override
	public void addSlide(String photo, String saying) {
		// TODO Auto-generated method stub
		String sql="insert into slide(photo,saying) values(?,?)";
		db.execOthers(sql, new Object[]{photo,saying});
	}

}
