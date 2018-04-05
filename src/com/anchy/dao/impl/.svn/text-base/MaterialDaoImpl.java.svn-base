package com.anchy.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.anchy.dao.MaterialDao;
import com.anchy.po.Material;
import com.anchy.util.DBHelper;

public class MaterialDaoImpl implements MaterialDao {
	DBHelper db=new DBHelper();
	@Override
	public List<Material> getMaterialByKeyword(String keyword1) {
		// TODO Auto-generated method stub
		String sql="select count(*),m.* from material m join goods g on g.gmid=m.materialid where (g.`name` like ? or g.info like ?) and g.flag=1 group by m.materialid order by count(*) DESC limit 0,5";
		ResultSet rs=db.execQuery(sql, new Object[]{"%"+keyword1+"%","%"+keyword1+"%"});
		List<Material> materialList =new ArrayList<Material>();
		try {
			while(rs.next()){
				Material m=new Material();
				m.setMid(rs.getInt("materialid"));
				m.setName(rs.getString("name"));
				materialList.add(m);
			}
			return materialList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Material> getAllMaterial() {
		// TODO Auto-generated method stub
		String sql="select * from material";
		ResultSet rs=db.execQuery(sql,new Object[]{});
		List<Material> materialList =new ArrayList<Material>();
		try {
			while(rs.next()){
				Material m=new Material();
				m.setMid(rs.getInt("materialid"));
				m.setName(rs.getString("name"));
				materialList.add(m);
			}
			return materialList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
