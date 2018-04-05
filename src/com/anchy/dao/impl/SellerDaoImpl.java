package com.anchy.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.anchy.dao.SellerDao;
import com.anchy.po.Seller;
import com.anchy.po.User;
import com.anchy.util.DBHelper;

public class SellerDaoImpl implements SellerDao {
	DBHelper db=new DBHelper();
	@Override
	public void addSeller(int suid,String photo1, String photo2, String photo3) {
		// TODO Auto-generated method stub
		String sql="insert into seller(suid,photo1,photo2,photo3,times,flag) values(?,?,?,?,?,?)";
		db.execOthers(sql, new Object[]{suid,photo1,photo2,photo3,0,1});
	}
	@Override
	public int SellerFlag(int suid) {
		// TODO Auto-generated method stub
		String sql="select * from seller where suid=?";
		ResultSet rs=db.execQuery(sql, new Object[]{suid});
		try {
			if(rs.next()){
				if(rs.getInt("flag")==1&&rs.getString("message")!=null) 
					return 1;
				if(rs.getInt("flag")==1&&rs.getString("message")==null) 
					return 0;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	@Override
	public int cSeller() {
		// TODO Auto-generated method stub
		String sql="select count(*) as cseller from seller where flag=?";
		ResultSet rs=db.execQuery(sql, new Object[]{1});
		try {
			if(rs.next()){
				return rs.getInt("cseller");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public List<Seller> getBeingSeller(){
		String sql="select s.*,u.userid,u.truename,u.nickname,u.gender,u.email,u.phone from seller s join user u on u.userid=s.suid where s.flag=1 and s.message is null";
		ResultSet rs=db.execQuery(sql, new Object[]{});
		List<Seller> sellerList=new ArrayList<Seller>();
		try {
			while(rs.next()){
				Seller seller=new Seller();
				seller.setPhoto1(rs.getString("photo1"));
				seller.setPhoto2(rs.getString("photo2"));
				seller.setPhoto3(rs.getString("photo3"));
				seller.setSid(rs.getInt("sellerid"));
				User user=new User();
				user.setuid(rs.getInt("userid"));
				user.setTruename(rs.getString("truename"));
				user.setNickname(rs.getString("nickname"));
				user.setGender(rs.getInt("gender"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				seller.setSid(rs.getInt("sellerid"));
				seller.setUser(user);
				sellerList.add(seller);
			}
			return sellerList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public void agrSeller(int suid) {
		// TODO Auto-generated method stub
		String sql="update seller set flag=2 where suid=?";
		db.execOthers(sql, new Object[]{suid});
		sql="update user set flag=2 where userid=?";
		db.execOthers(sql, new Object[]{suid});
	}
	@Override
	public void disAgrSeller(int sid,String message) {
		// TODO Auto-generated method stub
		String sql="update seller set message=? where sellerid=?";
		db.execOthers(sql, new Object[]{message,sid});
	}
	@Override
	public void reUpdate(int uid) {
		// TODO Auto-generated method stub
		String sql="delete from seller where suid=?";
		db.execOthers(sql, new Object[]{uid});
	}
	@Override
	public String getReason(int uid) {
		// TODO Auto-generated method stub
		String sql="select message from seller where suid=?";
		ResultSet rs=db.execQuery(sql, new Object[]{uid});
		try {
			if(rs.next()){
				return rs.getString("message");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
