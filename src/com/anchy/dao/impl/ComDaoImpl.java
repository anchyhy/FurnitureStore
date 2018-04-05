package com.anchy.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.anchy.dao.ComDao;
import com.anchy.po.Communicate;
import com.anchy.po.User;
import com.anchy.util.DBHelper;

public class ComDaoImpl implements ComDao {
	DBHelper db=new DBHelper();
	@Override
	//提交短信
	public void addCom(int uid, String ask, String subject) {
		// TODO Auto-generated method stub
		String sql="insert into communicate (cuid,ask,subject,flag) values(?,?,?,?)";
		db.execOthers(sql, new Object[]{uid,ask,subject,1});
	}
	//获取所有短信
	@Override
	public List<Communicate> getComById(int uid) {
		// TODO Auto-generated method stub
		String sql="select * from communicate where cuid=?";
		ResultSet rs=db.execQuery(sql, new Object[]{uid});
		List<Communicate> comList=new ArrayList<Communicate>();
		try {
			while(rs.next()){
				Communicate com=new Communicate();
				com.setAnswer(rs.getString("answer"));
				com.setAsk(rs.getString("ask"));
				com.setcid(rs.getInt("communicateid"));
				com.setFlag(rs.getInt("flag"));
				com.setSubject(rs.getString("subject"));
				comList.add(com);
			}
			return comList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//删除短信
	@Override
	public void delCom(int comid) {
		// TODO Auto-generated method stub
		String sql="delete from communicate where communicateid=?";
		db.execOthers(sql, new Object[]{comid});
	}
	@Override
	public List<Communicate> getCom() {
		// TODO Auto-generated method stub
		String sql="select u.nickname ,c.* from user u  join communicate c on c.cuid=u.userid where c.flag=?";
		ResultSet rs=db.execQuery(sql, new Object[]{1});
		List<Communicate> comList=new ArrayList<Communicate>();
		try {
			while(rs.next()){
				User u=new User();
				u.setNickname(rs.getString("nickname"));
				Communicate com=new Communicate();
				com.setUser(u);
				com.setAnswer(rs.getString("answer"));
				com.setAsk(rs.getString("ask"));
				com.setcid(rs.getInt("communicateid"));
				com.setFlag(rs.getInt("flag"));
				com.setSubject(rs.getString("subject"));
				comList.add(com);
			}
			return comList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public void answer(int cid,String answer) {
		// TODO Auto-generated method stub
		String sql="update communicate set answer=? , flag=? where communicateid=?";
		db.execOthers(sql, new Object[]{answer,2,cid});
	}

}
