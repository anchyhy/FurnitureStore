package com.anchy.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.anchy.dao.BrandDao;
import com.anchy.po.Brand;
import com.anchy.util.DBHelper;

public class BrandDaoImpl implements BrandDao {
	DBHelper db=new DBHelper();
	@Override
	public List<Brand> getByKeyword(String keyword) {
		// TODO Auto-generated method stub
		String sql="select count(*),b.* from brand b join goods g on g.gbid=b.brandid where (g.`name` like ? or g.info like ?) and g.flag=1 group by b.brandid order by count(*) DESC limit 0,5";
		ResultSet rs=db.execQuery(sql, new Object[]{"%"+keyword+"%","%"+keyword+"%"});
		List<Brand> bList=new ArrayList<Brand>();
		try {
			while(rs.next()){
				Brand b=new Brand();
				b.setBid(rs.getInt("brandid"));
				b.setName(rs.getString("name"));
				bList.add(b);
			}
			return bList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Brand> getAllBrand() {
		// TODO Auto-generated method stub
		String sql="select * from brand";
		ResultSet rs=db.execQuery(sql, new Object[]{});
		List<Brand> brandList=new ArrayList<Brand>();
		try {
			while(rs.next()){
				Brand b=new Brand();
				b.setBid(rs.getInt("brandid"));
				b.setName(rs.getString("name"));
				brandList.add(b);
			}
			return brandList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
