package com.anchy.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.anchy.dao.NewsDao;
import com.anchy.po.News;
import com.anchy.util.DBHelper;

public class NewsDaoImpl implements NewsDao {
	DBHelper db=new DBHelper();
	ResultSet rs;
	String sql="";
	@Override
	public List<News> getNews() {
		// TODO Auto-generated method stub
		sql="select * from News";
		rs=db.execQuery(sql, new Object[]{});
		List<News> newsList=new ArrayList<News>();
		try {
			while(rs.next()){
				News n=new News();
				n.setContent(rs.getString("content"));
				n.setNid(rs.getInt("newsid"));
				n.setTime(rs.getString("time"));
				n.setTitle(rs.getString("title"));
				newsList.add(n);
			}
			return newsList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addNews(String title, String time, String content) {
		// TODO Auto-generated method stub
		sql="insert into News(title,time,content) values(?,?,?)";
		db.execOthers(sql, new Object[]{title,time,content});
	}

	@Override
	public void delNews(int nid) {
		// TODO Auto-generated method stub
		sql="delete from News where newsid=?";
		db.execOthers(sql, new Object[]{nid});
	}

}
