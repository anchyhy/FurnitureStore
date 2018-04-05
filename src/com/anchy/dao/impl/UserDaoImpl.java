package com.anchy.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.anchy.dao.UserDao;
import com.anchy.po.User;
import com.anchy.util.DBHelper;

public class UserDaoImpl implements UserDao {
	private DBHelper db=new DBHelper();
	@Override
	//根据有nickname查询uid
	public int getUIdbynickname(String nickname) {
		// TODO Auto-generated method stub
		int uid=-1;
		String sql="select * from user where nickname=?";
		ResultSet rs=db.execQuery(sql, new Object[]{nickname});
		try {
			if(rs.next()){
				uid=rs.getInt("userid");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return uid;
	}
	//根据phone得到uid
	public int getUIdByPhone(String phone){
		// TODO Auto-generated method stub
		int uid=-1;
		String sql="select * from user where phone=?";
		ResultSet rs=db.execQuery(sql, new Object[]{phone});
		try {
			if(rs.next()){
				uid=rs.getInt("userid");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return uid;

	}
	//根据Email得到uid
	public int getUIdByEmail(String email){
		// TODO Auto-generated method stub
		int uid=-1;
		String sql="select * from user where email=?";
		ResultSet rs=db.execQuery(sql, new Object[]{email});
		try {
			if(rs.next()){
				uid=rs.getInt("userid");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return uid;
		
	}
	//根据uid得到user
	@Override
	public User getUserById(int uid) {
		// TODO Auto-generated method stub
		String sql="select * from user where userid=?";
		ResultSet rs=db.execQuery(sql, new Object[]{uid});
		try {
			if(rs.next()){
				User user=new User();
				user.setuid(rs.getInt("userid"));
				user.setTruename(rs.getString("truename"));
				user.setNickname(rs.getString("nickname"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setFlag(rs.getInt("flag"));
				user.setGender(rs.getInt("gender"));
				Date d=new Date(rs.getString("registerTime"));
				user.setRegisterTime(d);
				user.setStatus(rs.getInt("status"));
				user.setValidateCode(rs.getString("validateCode"));
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//添加user
	@Override
	public void addUser(String truename, String nickname, String email,
			String password, String phone, int flag, int gender,int status,String validateCode,String  registerTime) {
		// TODO Auto-generated method stub
		String sql="insert into user (truename,nickname,email,password,phone,flag,gender,status,validateCode,registerTime) values (?,?,?,?,?,?,?,?,?,?)";
		db.execOthers(sql, new Object[]{truename,nickname,email,password,phone,flag,gender,status,validateCode,registerTime});

	}
	//修改user信息
	@Override
	public void changeUserInfo(int uid,String truename,String nickname, String email,
			String phone, int gender) {
		// TODO Auto-generated method stub
		String sql="update user set truename=?,email=?,phone=?, nickname=?,gender=? where userid=?";
		db.execOthers(sql, new Object[]{truename,email,phone,nickname,gender,uid});

	}
	//获得全部user
	@Override
	public List<User> getAllUser(int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		String sql="select * from user where flag<3 limit ?,?";
		ResultSet rs=db.execQuery(sql, new Object[]{(pageNum - 1) * pageSize,pageSize});
		List<User> userList=new ArrayList<User>();
		try {
			while(rs.next()){
				User user=new User();
				user.setuid(rs.getInt("userid"));
				user.setTruename(rs.getString("truename"));
				user.setNickname(rs.getString("nickname"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setFlag(rs.getInt("flag"));
				user.setGender(rs.getInt("gender"));
				user.setStatus(rs.getInt("status"));
				Date d=new Date(rs.getString("registerTime"));
				user.setRegisterTime(d);
				userList.add(user);
			}
			return userList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public User getUserByGoods(int goodsid) {
		// TODO Auto-generated method stub
		String sql="select * from user where userid in (select guid from goods where goodsid=?)";
		ResultSet rs=db.execQuery(sql, new Object[]{goodsid});
		try {
			if(rs.next()){
				User user=new User();
				user.setEmail(rs.getString("email"));
				user.setFlag(rs.getInt("flag"));
				user.setGender(rs.getInt("gender"));
				user.setNickname(rs.getString("nickname"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getString("phone"));
				user.setTruename(rs.getString("truename"));
				user.setuid(rs.getInt("userid"));
				return user;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public void changPassword(int uid, String new1, String new2) {
		// TODO Auto-generated method stub
		String sql="update user set password=? where userid=?";
		db.execOthers(sql, new Object[]{new1,uid});
	}
	@Override
	public void chgStatus(int uid, int status) {
		// TODO Auto-generated method stub
		String sql="update user set status=? where userid=?";
		db.execOthers(sql, new Object[]{status,uid});
		
	}
	@Override
	public int cUser() {
		// TODO Auto-generated method stub
		String sql="select count(*) as COUNT from user";
		ResultSet rs=db.execQuery(sql, new Object[]{});
		try {
			if(rs.next()){
				return rs.getInt("COUNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
