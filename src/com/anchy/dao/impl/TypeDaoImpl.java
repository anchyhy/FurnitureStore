package com.anchy.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.anchy.dao.TypeDao;
import com.anchy.po.Type;
import com.anchy.util.DBHelper;

public class TypeDaoImpl implements TypeDao {
	DBHelper db=new DBHelper();
	@Override
	public List<Type> getTypeByGoods(int gid) {
		// TODO Auto-generated method stub
		String sql="select * from type where tgid=?";
		ResultSet rs=db.execQuery(sql, new Object[]{gid});
		List<Type> typeList=new ArrayList<Type>();
		try {
			while(rs.next()){
				Type type=new Type();
				type.setTid(rs.getInt("typeid"));
				type.setKind(rs.getString("kind"));
				type.setNumber(rs.getInt("number"));
				type.setPhoto(rs.getString("photo"));
				typeList.add(type);
			}
			return typeList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public Type getTypeById(int tid) {
		// TODO Auto-generated method stub
		String sql="select * from type where typeid=?";
		ResultSet rs=db.execQuery(sql, new Object[]{tid});
		try {
			if(rs.next()){
				Type type=new Type();
				type.setTid(rs.getInt("typeid"));
				type.setKind(rs.getString("kind"));
				type.setNumber(rs.getInt("number"));
				type.setPhoto(rs.getString("photo"));
				return type;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public int getTypeByKind(int gid, String kind) {
		// TODO Auto-generated method stub
		String sql="select typeid from type where tgid=? and kind=?";
		ResultSet rs=db.execQuery(sql, new Object[]{gid,kind});
		try {
			if(rs.next()){
				return rs.getInt("typeid");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public void delSellerType(int gid, String kname) {
		// TODO Auto-generated method stub
		String sql="select typeid from type where tgid=? and kind=?";
		ResultSet rs=db.execQuery(sql, new Object[]{gid,kname});
		int i=0;
		int []t={};
		try {
			
			while(rs.next()){
				t[i]=rs.getInt("typeid");
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sql="delete * from cart where ctid=?";
		for(int j=0;j<t.length;j++){
			db.execOthers(sql, new Object[]{t[j]});
		}
		sql="delete * from type where tgid=? and kind=?";
		db.execOthers(sql, new Object[]{gid,kname});
		
		
	}
	@Override
	public void changeTNum(int tid,int num) {
		// TODO Auto-generated method stub
		String sql="update type set number=? where typeid=?";
		db.execOthers(sql, new Object[]{num,tid});
	}
	@Override
	public void addType(int gid, String kind, String pname, int number) {
		// TODO Auto-generated method stub
		String sql="insert into type (tgid,kind,photo,number) values(?,?,?,?)";
		db.execOthers(sql, new Object[]{gid,kind,pname,number});
	}

}
