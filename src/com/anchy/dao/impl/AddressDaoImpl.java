package com.anchy.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.anchy.dao.AddressDao;
import com.anchy.po.Address;
import com.anchy.util.DBHelper;
import com.sun.xml.internal.ws.api.pipe.NextAction;

public class AddressDaoImpl implements AddressDao {
	DBHelper db=new DBHelper();
	//显示用户地址
	@Override
	public List<Address> getAddressByUser(int auid) {
		// TODO Auto-generated method stub
		String sql="select * from address where auid=?";
		ResultSet rs=db.execQuery(sql, new Object[]{auid});
		try {
			List<Address> addressList=new ArrayList<Address>();
			
			while(rs.next()){
				Address address=new Address();
				address.setAid(rs.getInt("addressid"));
				address.setCity(rs.getString("city"));
				address.setDetail(rs.getString("detail"));
				address.setDistrict(rs.getString("district"));
				address.setProvince(rs.getString("province"));
				addressList.add(address);
			}
			return addressList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//删除用户地址
	@Override
	public void delAddress(int aid) {
		// TODO Auto-generated method stub
		String sql="delete from address where addressid=?";
		db.execOthers(sql, new Object[]{aid});
		
	}
	//添加新的地址
	@Override
	public void addAddress(String p, String c, String d, String dt, int auid) {
		// TODO Auto-generated method stub
		String sql="insert into address (province,city,district,detail,auid) values(?,?,?,?,?)";
		db.execOthers(sql, new Object[]{p,c,d,dt,auid});
	}
	

}
