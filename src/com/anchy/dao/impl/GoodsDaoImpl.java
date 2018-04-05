package com.anchy.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.anchy.dao.GoodsDao;
import com.anchy.po.Brand;
import com.anchy.po.Goods;
import com.anchy.po.Material;
import com.anchy.po.Style;
import com.anchy.po.Third;
import com.anchy.po.User;
import com.anchy.util.DBHelper;

public class GoodsDaoImpl implements GoodsDao {
	private DBHelper db=new DBHelper();
	@Override
	//一级查询带分页
	public List<Goods> firstSearch(String keyword1, int pageNum, int pageSize) {
		String sql="select * from goods where (name like ? or info like ?) and flag=? limit ?,?";
		ResultSet rs=db.execQuery(sql, new Object[]{"%"+keyword1+"%","%"+keyword1+"%",1,(pageNum - 1) * pageSize,pageSize});
		List<Goods> goodsList=new ArrayList<Goods>();
		try {
			while(rs.next()){
				
				Goods goods=new Goods();
				goods.setGid(rs.getInt("goodsid"));
				goods.setName(rs.getString("name"));
				goods.setInfo(rs.getString("info"));
				goods.setDetail(rs.getString("detail"));
				goods.setBrand(rs.getString("brand"));
				goods.setColor(rs.getString("color"));
				goods.setMaterial(rs.getString("material"));
				goods.setStyle(rs.getString("style"));
				goods.setTransport(rs.getDouble("transport"));
				goods.setOriprice(rs.getDouble("oriprice"));
				goods.setPreprice(rs.getDouble("preprice"));
				goods.setPhoto(rs.getString("photo"));
				goodsList.add(goods);
			}
			return goodsList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//product.jsp的discount分类
	@Override
	public int[] getDiscount(String keyword1) {
		// TODO Auto-generated method stub
		String sql0="select count(*) from goods where (name like ? and preprice/oriprice <= ? or info like ? and preprice/oriprice <= ? ) and flag=?";
		ResultSet rs0=db.execQuery(sql0, new Object[]{"%"+keyword1+"%",0.1,"%"+keyword1+"%",0.1,1});
		String sql1="select count(*) from goods where( name like ? and preprice/oriprice >? and preprice/oriprice <= ? or info like ? and preprice/oriprice >? and preprice/oriprice <=? ) and flag=? ";
		ResultSet rs1=db.execQuery(sql1, new Object[]{"%"+keyword1+"%",0.1,0.2,"%"+keyword1+"%",0.1,0.2,1});
		String sql2="select count(*) from goods where (name like ? and preprice/oriprice >? and preprice/oriprice <= ? or info like ? and preprice/oriprice >? and preprice/oriprice <= ?) and flag=? ";
		ResultSet rs2=db.execQuery(sql2, new Object[]{"%"+keyword1+"%",0.2,0.3,"%"+keyword1+"%",0.2,0.3,1});
		String sql3="select count(*) from goods where (name like ? and preprice/oriprice >? and preprice/oriprice <= ? or info like ? and preprice/oriprice >? and preprice/oriprice <= ?) and flag=? ";
		ResultSet rs3=db.execQuery(sql3, new Object[]{"%"+keyword1+"%",0.3,0.4,"%"+keyword1+"%",0.3,0.4,1});
		String sql4="select count(*) from goods where( name like ? and preprice/oriprice >? and preprice/oriprice <= ? or info like ? and preprice/oriprice >? and preprice/oriprice <= ?) and flag=? ";
		ResultSet rs4=db.execQuery(sql4, new Object[]{"%"+keyword1+"%",0.4,0.5,"%"+keyword1+"%",0.4,0.5,1});
		String sql5="select count(*) from goods where (name like ? and preprice/oriprice > ? or info like ? and preprice/oriprice > ?) and flag=? ";
		ResultSet rs5=db.execQuery(sql5, new Object[]{"%"+keyword1+"%",0.5,"%"+keyword1+"%",0.5,1});
		List<Goods> goodsList=new ArrayList<Goods>();
		try {
			int d[]={0,0,0,0,0,0};
			if(rs0.next()){
				d[0]=rs0.getInt("count(*)");
			}
			if(rs1.next()){
				d[1]=rs1.getInt("count(*)");
			}
			if(rs2.next()){
				d[2]=rs2.getInt("count(*)");
			}
			if(rs3.next()){
				d[3]=rs3.getInt("count(*)");
			}
			if(rs4.next()){
				d[4]=rs4.getInt("count(*)");
			}
			if(rs5.next()){
				d[5]=rs5.getInt("count(*)");
			}
			return d;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//由id获得goods
	@Override
	public Goods getGoodsById(int gid) {
		// TODO Auto-generated method stub
		String sql="select g.*,m.name as mname,m.materialid,s.name as sname,s.styleid,b.brandid,b.name as bname from goods g join material m  on g.gmid=m.materialid join brand b on b.brandid=g.gbid join style s on s.styleid=g.gsid where g.goodsid=?";
		ResultSet rs=db.execQuery(sql, new Object[]{gid});
		try {
			if(rs.next()){
				Goods goods=new Goods();
				
				Material m=new Material();
				m.setMid(rs.getInt("materialid"));
				m.setName(rs.getString("mname"));
				Brand b=new Brand();
				b.setBid(rs.getInt("brandid"));
				b.setName(rs.getString("bname"));
				Style s=new Style();
				s.setName(rs.getString("sname"));
				s.setSid(rs.getInt("styleid"));
				goods.setGid(rs.getInt("goodsid"));
				goods.setName(rs.getString("name"));
				goods.setInfo(rs.getString("info"));
				goods.setDetail(rs.getString("detail"));
				goods.setBrand(rs.getString("brand"));
				goods.setColor(rs.getString("color"));
				goods.setMaterial(rs.getString("material"));
				goods.setStyle(rs.getString("style"));
				goods.setTransport(rs.getDouble("transport"));
				goods.setOriprice(rs.getDouble("oriprice"));
				goods.setPreprice(rs.getDouble("preprice"));
				goods.setPhoto(rs.getString("photo"));
				goods.setGmaterial(m);
				goods.setGbrand(b);
				goods.setGstyle(s);
				goods.setEvaluate(rs.getInt("evaluate"));
				
				return goods;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//由seller得到商户所有商品
	@Override
	public List<Goods> getSellerGoods(int uid,int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		String sql="select g.* from goods g join user u on g.guid=userid where u.userid=? and g.flag=1 limit ?,? ";
		ResultSet rs=db.execQuery(sql, new Object[]{uid,(pageNum - 1) * pageSize,pageSize});
		List<Goods> goodsList=new ArrayList<Goods>();
		try {
			while(rs.next()){
				Goods goods=new Goods();
				goods.setGid(rs.getInt("goodsid"));
				goods.setName(rs.getString("name"));
				goods.setInfo(rs.getString("info"));
				goods.setDetail(rs.getString("detail"));
				goods.setBrand(rs.getString("brand"));
				goods.setColor(rs.getString("color"));
				goods.setMaterial(rs.getString("material"));
				goods.setStyle(rs.getString("style"));
				goods.setTransport(rs.getDouble("transport"));
				goods.setOriprice(rs.getDouble("oriprice"));
				goods.setPreprice(rs.getDouble("preprice"));
				goods.setPhoto(rs.getString("photo"));
				goods.setFlag(rs.getInt("flag"));
				goodsList.add(goods);
			}
			return goodsList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//seller_index 按照type分类
	@Override
	public List<Goods> getSellerThird(int uid, int gtid, int pageNum,
			int pageSize) {
		// TODO Auto-generated method stub
		String sql="select g.* from goods g join user u on g.guid=userid join third t on t.thirdid=g.gtid where u.userid=? and t.thirdid=? and g.flag=1 limit ?,? ";
		ResultSet rs=db.execQuery(sql, new Object[]{uid,gtid,(pageNum - 1) * pageSize,pageSize});
		List<Goods> goodsList=new ArrayList<Goods>();
		try {
			while(rs.next()){
				Goods goods=new Goods();
				goods.setGid(rs.getInt("goodsid"));
				goods.setName(rs.getString("name"));
				goods.setInfo(rs.getString("info"));
				goods.setDetail(rs.getString("detail"));
				goods.setBrand(rs.getString("brand"));
				goods.setColor(rs.getString("color"));
				goods.setMaterial(rs.getString("material"));
				goods.setStyle(rs.getString("style"));
				goods.setTransport(rs.getDouble("transport"));
				goods.setOriprice(rs.getDouble("oriprice"));
				goods.setPreprice(rs.getDouble("preprice"));
				goods.setPhoto(rs.getString("photo"));
				goodsList.add(goods);
			}
			return goodsList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//seller添加商品
	@Override
	public void addGoods(String name, String info, String detail,
			int mid,String material, String color,int sid, String style,int bid, String brand, int uid,
			int thirdid, double preprice, String photo, double transport) {
		// TODO Auto-generated method stub
		String sql="insert into goods (name,info,detail,gmid,material,color,gsid,style,gbid,brand,guid,gtid,preprice,photo,transport,flag) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		db.execOthers(sql, new Object[]{name,info,detail,mid,material,color,sid,style,bid,brand,uid,thirdid,preprice,photo,transport,0});
		
	}
	//seller删除图片
	@Override
	public void delPhoto(int gid, String pname) {
		// TODO Auto-generated method stub
		String sql="select photo from goods where goodsid=?";
		ResultSet rs=db.execQuery(sql, new Object[]{gid});
		String photo="";
		try {
			if(rs.next()){
			 photo=rs.getString("photo");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String []p=photo.split(";");
		photo="";
		for(int i=0;i<p.length;i++){
			if(!p[i].equals(pname))
				photo+=p[i]+";";
		}
		sql="update goods set photo=? where goodsid=?";
		db.execOthers(sql, new Object[]{photo,gid});
	}
	//seller编辑商品
	@Override
	public void chgGoods(int gid,String info, String detail, String material,
			String color, String style, String brand, double preprice,
			double transport) {
		// TODO Auto-generated method stub
		String sql="select preprice from goods where goodsid=?";
		ResultSet rs=db.execQuery(sql, new Object[]{gid});
		double price=0;
		try {
			if(rs.next()){
				price=rs.getDouble("preprice");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sql="update goods set info=?,detail=?,material=?,color=?,style=?,brand=?,preprice=?,oriprice=?,transport=? where goodsid=?";
		db.execOthers(sql, new Object[]{info, detail, material,color, style, brand, preprice,price, transport,gid});
	}
	//seller添加图片
	@Override
	public void addPhoto(int gid, String pname) {
		// TODO Auto-generated method stub
		String sql="update goods set photo=concat(photo,?) where goodsid=?";
		db.execOthers(sql, new Object[]{pname,gid});
		
	}
	//seller删除商品
	@Override
	public boolean delGoods(int gid) {
		// TODO Auto-generated method stub
		String sql="select o.* from `order` o join type t on t.typeid=o.otid join goods g on g.goodsid=tgid where g.goodsid=?";
		ResultSet rs=db.execQuery(sql, new Object[]{gid});
		try {
			if(rs.next()){
				return false;
			}else{
				sql="delete from type where tgid=?";
				db.execOthers(sql, new Object[]{gid});
				sql="delete from goods where goodsid=?";
				db.execOthers(sql, new Object[]{gid});
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	//product.jsp按照价格查询商品
	@Override
	public List<Goods> getGoodsByPrice(double pricefrom, double priceto,
			String keyword, int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		String sql="select * from goods where (name like ? or info like ?) and flag=? and preprice >= ? and preprice <= ? limit ?,?";
		ResultSet rs=db.execQuery(sql, new Object[]{"%"+keyword+"%","%"+keyword+"%",1,pricefrom,priceto,(pageNum - 1) * pageSize,pageSize});
		List<Goods> goodsList=new ArrayList<Goods>();
		try {
			while(rs.next()){
				
				Goods goods=new Goods();
				goods.setGid(rs.getInt("goodsid"));
				goods.setName(rs.getString("name"));
				goods.setInfo(rs.getString("info"));
				goods.setDetail(rs.getString("detail"));
				goods.setBrand(rs.getString("brand"));
				goods.setColor(rs.getString("color"));
				goods.setMaterial(rs.getString("material"));
				goods.setStyle(rs.getString("style"));
				goods.setTransport(rs.getDouble("transport"));
				goods.setOriprice(rs.getDouble("oriprice"));
				goods.setPreprice(rs.getDouble("preprice"));
				goods.setPhoto(rs.getString("photo"));
				goodsList.add(goods);
			}
			return goodsList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//product.jsp免邮商品
	@Override
	public List<Goods> noTransport(String keyword, int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		String sql="select * from goods where (name like ? or info like ?)and flag=? and transport= ? limit ?,?";
		ResultSet rs=db.execQuery(sql, new Object[]{"%"+keyword+"%","%"+keyword+"%",1,0,(pageNum - 1) * pageSize,pageSize});
		List<Goods> goodsList=new ArrayList<Goods>();
		try {
			while(rs.next()){
				
				Goods goods=new Goods();
				goods.setGid(rs.getInt("goodsid"));
				goods.setName(rs.getString("name"));
				goods.setInfo(rs.getString("info"));
				goods.setDetail(rs.getString("detail"));
				goods.setBrand(rs.getString("brand"));
				goods.setColor(rs.getString("color"));
				goods.setMaterial(rs.getString("material"));
				goods.setStyle(rs.getString("style"));
				goods.setTransport(rs.getDouble("transport"));
				goods.setOriprice(rs.getDouble("oriprice"));
				goods.setPreprice(rs.getDouble("preprice"));
				goods.setPhoto(rs.getString("photo"));
				goodsList.add(goods);
			}
			return goodsList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//主页 top商品
	@Override
	public List<Goods> getTop() {
		// TODO Auto-generated method stub
		String sql="select goodsid from  goods  order by times DESC limit ?,? ";
		ResultSet rs=db.execQuery(sql, new Object[]{0,4});
		List<Goods> goodsList=new ArrayList<Goods>();
		try {
			while(rs.next()){
				goodsList.add(getGoodsById(rs.getInt("goodsid")));
			}
			return goodsList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//主页 new 商品
	@Override
	public List<Goods> getNew() {
		// TODO Auto-generated method stub
		String sql="select goodsid from goods where flag=? order by goodsid DESC limit ?,?";
		ResultSet rs=db.execQuery(sql, new Object[]{1,0,8});
		List<Goods> goodsList=new ArrayList<Goods>();
		try {
			while(rs.next()){
				goodsList.add(getGoodsById(rs.getInt("goodsid")));
			}
			return goodsList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//主页 特价 商品
	@Override
	public List<Goods> getSpecial() {
		// TODO Auto-generated method stub
		String sql="select goodsid from goods where flag=? order by oriprice-preprice DESC limit ?,?";
		ResultSet rs=db.execQuery(sql, new Object[]{1,0,6});
		List<Goods> goodsList=new ArrayList<Goods>();
		try {
			while(rs.next()){
				goodsList.add(getGoodsById(rs.getInt("goodsid")));
			}
			return goodsList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//single 最近 商品
	@Override
	public List<Goods> getRecent(int uid) {
		// TODO Auto-generated method stub
		String sql="select distinct(sgid) from seen where suid=? order by seenid DESC limit ?,?";
		ResultSet rs=db.execQuery(sql, new Object[]{uid,0,8});
		List<Goods> goodsList=new ArrayList<Goods>();
		try {
			while(rs.next()){
				goodsList.add(getGoodsById(rs.getInt("sgid")));
			}
			return goodsList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//管理员审核待商家商品
	@Override
	public List<Goods> checkGoods() {
		// TODO Auto-generated method stub
		String sql="select g.*,u.*,t.name as tname,t.thirdid from goods g join user u on u.userid=g.guid join third t on t.thirdid=g.gtid where g.flag=? and g.message is null";
		ResultSet rs=db.execQuery(sql, new Object[]{0});
		List<Goods> goodsList=new ArrayList<Goods>();
		try {
			while(rs.next()){
				User u=new User();
				u.setEmail(rs.getString("email"));
				u.setNickname(rs.getString("nickname"));
				u.setPhone(rs.getString("phone"));
				u.setTruename(rs.getString("truename"));
				u.setuid(rs.getInt("userid"));
				
				Third t=new Third();
				t.setName(rs.getString("tname"));
				t.setTid(rs.getInt("thirdid"));
				
				Goods goods=new Goods();
				goods.setGid(rs.getInt("goodsid"));
				goods.setName(rs.getString("name"));
				goods.setInfo(rs.getString("info"));
				goods.setDetail(rs.getString("detail"));
				goods.setBrand(rs.getString("brand"));
				goods.setColor(rs.getString("color"));
				goods.setMaterial(rs.getString("material"));
				goods.setStyle(rs.getString("style"));
				goods.setTransport(rs.getDouble("transport"));
				goods.setOriprice(rs.getDouble("oriprice"));
				goods.setPreprice(rs.getDouble("preprice"));
				goods.setPhoto(rs.getString("photo"));
				goods.setUser(u);
				goods.setThird(t);
				goodsList.add(goods);
				
			}
			return goodsList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public void agrGoods(int gid) {
		// TODO Auto-generated method stub
		String sql="update goods set flag=? where goodsid=?";
		db.execOthers(sql, new Object[]{1,gid});
	}
	@Override
	public void disagrGoods(int gid, String message) {
		// TODO Auto-generated method stub
		String sql="update goods set message=? where goodsid=?";
		db.execOthers(sql, new Object[]{message,gid});
	}
	@Override
	public List<Goods> getDisAgrGoods(int uid) {
		// TODO Auto-generated method stub
		String sql="select g.* from goods g join user u on g.guid=userid where u.userid=? and g.flag=0 and message is NULL";
		ResultSet rs=db.execQuery(sql, new Object[]{uid});
		List<Goods> goodsList=new ArrayList<Goods>();
		try {
			while(rs.next()){
				Goods goods=new Goods();
				goods.setGid(rs.getInt("goodsid"));
				goods.setName(rs.getString("name"));
				goods.setInfo(rs.getString("info"));
				goods.setDetail(rs.getString("detail"));
				goods.setBrand(rs.getString("brand"));
				goods.setColor(rs.getString("color"));
				goods.setMaterial(rs.getString("material"));
				goods.setStyle(rs.getString("style"));
				goods.setTransport(rs.getDouble("transport"));
				goods.setOriprice(rs.getDouble("oriprice"));
				goods.setPreprice(rs.getDouble("preprice"));
				goods.setPhoto(rs.getString("photo"));
				goods.setFlag(rs.getInt("flag"));
				goodsList.add(goods);
			}
			return goodsList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Goods> getSRGoods(int uid){
		String sql="select g.* from goods g join user u on g.guid=userid where u.userid=? and g.message is not NULL";
		ResultSet rs=db.execQuery(sql, new Object[]{uid});
		List<Goods> goodsList=new ArrayList<Goods>();
		try {
			while(rs.next()){
				Goods goods=new Goods();
				goods.setGid(rs.getInt("goodsid"));
				goods.setName(rs.getString("name"));
				goods.setInfo(rs.getString("info"));
				goods.setDetail(rs.getString("detail"));
				goods.setBrand(rs.getString("brand"));
				goods.setColor(rs.getString("color"));
				goods.setMaterial(rs.getString("material"));
				goods.setStyle(rs.getString("style"));
				goods.setTransport(rs.getDouble("transport"));
				goods.setOriprice(rs.getDouble("oriprice"));
				goods.setPreprice(rs.getDouble("preprice"));
				goods.setPhoto(rs.getString("photo"));
				goods.setFlag(rs.getInt("flag"));
				goods.setMessage(rs.getString("message"));
				goodsList.add(goods);
			}
			return goodsList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//根据折扣进行二级查询
	@Override
	public List<Goods> searchByDiscount(String keyword, int pageNum,
			int pageSize, int d) {
		// TODO Auto-generated method stub
		String sql="";
		if(d==0)
			sql="select * from goods where (name like ? or info like ?) and flag=? and preprice/oriprice <= 0.1 limit ?,?";
		if(d==1)
			sql="select * from goods where (name like ? or info like ?) and flag=? and preprice/oriprice > 0.1 and preprice/oriprice <= 0.2 limit ?,?";
		if(d==2)
			sql="select * from goods where (name like ? or info like ?) and flag=? and preprice/oriprice > 0.2 and preprice/oriprice <= 0.3 limit ?,?";
		if(d==3)
			sql="select * from goods where (name like ? or info like ?) and flag=? and preprice/oriprice > 0.3 and preprice/oriprice <= 0.4 limit ?,?";
		if(d==4)
			sql="select * from goods where (name like ? or info like ?) and flag=? and preprice/oriprice > 0.4 and preprice/oriprice <= 0.5 limit ?,?";
		if(d==5)
			sql="select * from goods where (name like ? or info like ?) and flag=? and preprice/oriprice > 0.5 limit ?,?";
		ResultSet rs=db.execQuery(sql, new Object[]{"%"+keyword+"%","%"+keyword+"%",1,(pageNum - 1) * pageSize,pageSize});
		List<Goods> goodsList=new ArrayList<Goods>();
		try {
			while(rs.next()){
				
				Goods goods=new Goods();
				goods.setGid(rs.getInt("goodsid"));
				goods.setName(rs.getString("name"));
				goods.setInfo(rs.getString("info"));
				goods.setDetail(rs.getString("detail"));
				goods.setBrand(rs.getString("brand"));
				goods.setColor(rs.getString("color"));
				goods.setMaterial(rs.getString("material"));
				goods.setStyle(rs.getString("style"));
				goods.setTransport(rs.getDouble("transport"));
				goods.setOriprice(rs.getDouble("oriprice"));
				goods.setPreprice(rs.getDouble("preprice"));
				goods.setPhoto(rs.getString("photo"));
				goodsList.add(goods);
			}
			return goodsList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Goods> searchByBrand(String keyword, int pageNum, int pageSize,
			int bid) {
		// TODO Auto-generated method stub
		String sql="select * from goods where (name like ? or info like ?) and flag=? and gbid=? limit ?,?";
		ResultSet rs=db.execQuery(sql, new Object[]{"%"+keyword+"%","%"+keyword+"%",1,bid,(pageNum - 1) * pageSize,pageSize});
		List<Goods> goodsList=new ArrayList<Goods>();
		try {
			while(rs.next()){
				
				Goods goods=new Goods();
				goods.setGid(rs.getInt("goodsid"));
				goods.setName(rs.getString("name"));
				goods.setInfo(rs.getString("info"));
				goods.setDetail(rs.getString("detail"));
				goods.setBrand(rs.getString("brand"));
				goods.setColor(rs.getString("color"));
				goods.setMaterial(rs.getString("material"));
				goods.setStyle(rs.getString("style"));
				goods.setTransport(rs.getDouble("transport"));
				goods.setOriprice(rs.getDouble("oriprice"));
				goods.setPreprice(rs.getDouble("preprice"));
				goods.setPhoto(rs.getString("photo"));
				goodsList.add(goods);
			}
			return goodsList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Goods> searchByMaterial(String keyword, int pageNum,
			int pageSize, int mid) {
		// TODO Auto-generated method stub
		String sql="select * from goods where (name like ? or info like ?) and flag=? and gmid=? limit ?,?";
		ResultSet rs=db.execQuery(sql, new Object[]{"%"+keyword+"%","%"+keyword+"%",1,mid,(pageNum - 1) * pageSize,pageSize});
		List<Goods> goodsList=new ArrayList<Goods>();
		try {
			while(rs.next()){
				
				Goods goods=new Goods();
				goods.setGid(rs.getInt("goodsid"));
				goods.setName(rs.getString("name"));
				goods.setInfo(rs.getString("info"));
				goods.setDetail(rs.getString("detail"));
				goods.setBrand(rs.getString("brand"));
				goods.setColor(rs.getString("color"));
				goods.setMaterial(rs.getString("material"));
				goods.setStyle(rs.getString("style"));
				goods.setTransport(rs.getDouble("transport"));
				goods.setOriprice(rs.getDouble("oriprice"));
				goods.setPreprice(rs.getDouble("preprice"));
				goods.setPhoto(rs.getString("photo"));
				goodsList.add(goods);
			}
			return goodsList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Goods> searchByStyle(String keyword, int pageNum, int pageSize,
			int sid) {
		// TODO Auto-generated method stub
		String sql="select * from goods where (name like ? or info like ?) and flag=? and gsid=? limit ?,?";
		ResultSet rs=db.execQuery(sql, new Object[]{"%"+keyword+"%","%"+keyword+"%",1,sid,(pageNum - 1) * pageSize,pageSize});
		List<Goods> goodsList=new ArrayList<Goods>();
		try {
			while(rs.next()){
				
				Goods goods=new Goods();
				goods.setGid(rs.getInt("goodsid"));
				goods.setName(rs.getString("name"));
				goods.setInfo(rs.getString("info"));
				goods.setDetail(rs.getString("detail"));
				goods.setBrand(rs.getString("brand"));
				goods.setColor(rs.getString("color"));
				goods.setMaterial(rs.getString("material"));
				goods.setStyle(rs.getString("style"));
				goods.setTransport(rs.getDouble("transport"));
				goods.setOriprice(rs.getDouble("oriprice"));
				goods.setPreprice(rs.getDouble("preprice"));
				goods.setPhoto(rs.getString("photo"));
				goodsList.add(goods);
			}
			return goodsList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public Goods getGoodsByType(int tid) {
		// TODO Auto-generated method stub
		String sql="select * from goods where goodsid in (select tgid from type where typeid=?) ";
		ResultSet rs=db.execQuery(sql, new Object[]{tid});
		try {
			if(rs.next()){
				
				Goods goods=new Goods();
				goods.setGid(rs.getInt("goodsid"));
				goods.setName(rs.getString("name"));
				goods.setInfo(rs.getString("info"));
				goods.setDetail(rs.getString("detail"));
				goods.setBrand(rs.getString("brand"));
				goods.setColor(rs.getString("color"));
				goods.setMaterial(rs.getString("material"));
				goods.setStyle(rs.getString("style"));
				goods.setTransport(rs.getDouble("transport"));
				goods.setOriprice(rs.getDouble("oriprice"));
				goods.setPreprice(rs.getDouble("preprice"));
				goods.setPhoto(rs.getString("photo"));
				return goods;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public int getFirstSearchCount(String keyword) {
		// TODO Auto-generated method stub
		String sql="select count(*) as COUNT from goods where (name like ? or info like ?) and flag=?";
		ResultSet rs=db.execQuery(sql, new Object[]{"%"+keyword+"%","%"+keyword+"%",1});
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
	@Override
	public int getDiscountCount(String keyword, int d) {
		// TODO Auto-generated method stub
		String sql="";
		if(d==0)
			sql="select count(*) as COUNT from goods where (name like ? or info like ?) and flag=? and preprice/oriprice <= 0.1 ";
		if(d==1)
			sql="select count(*) as COUNT from goods where (name like ? or info like ?) and flag=? and preprice/oriprice > 0.1 and preprice/oriprice <= 0.2 ";
		if(d==2)
			sql="select count(*) as COUNT from goods where (name like ? or info like ?) and flag=? and preprice/oriprice > 0.2 and preprice/oriprice <= 0.3";
		if(d==3)
			sql="select count(*) as COUNT from goods where (name like ? or info like ?) and flag=? and preprice/oriprice > 0.3 and preprice/oriprice <= 0.4";
		if(d==4)
			sql="select count(*) as COUNT from goods where (name like ? or info like ?) and flag=? and preprice/oriprice > 0.4 and preprice/oriprice <= 0.5 ";
		if(d==5)
			sql="select count(*) as COUNT from goods where (name like ? or info like ?) and flag=? and preprice/oriprice > 0.5";
		ResultSet rs=db.execQuery(sql, new Object[]{"%"+keyword+"%","%"+keyword+"%",1});
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
	@Override
	public int getStyleCount(String keyword, int s) {
		// TODO Auto-generated method stub
		String sql="select count(*) as COUNT from goods where (name like ? or info like ?) and flag=? and gsid=?";
		ResultSet rs=db.execQuery(sql, new Object[]{"%"+keyword+"%","%"+keyword+"%",1,s});
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
	@Override
	public int getBrandCount(String keyword, int b) {
		// TODO Auto-generated method stub
		String sql="select count(*) as COUNT from goods where (name like ? or info like ?) and flag=? and gbid=?";
		ResultSet rs=db.execQuery(sql, new Object[]{"%"+keyword+"%","%"+keyword+"%",1,b});
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
	@Override
	public int getMaterialCount(String keyword, int m) {
		// TODO Auto-generated method stub
		String sql="select count(*) as COUNT from goods where (name like ? or info like ?) and flag=? and gmid=?";
		ResultSet rs=db.execQuery(sql, new Object[]{"%"+keyword+"%","%"+keyword+"%",1,m});
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
	@Override
	public int getTransportCount(String keyword) {
		// TODO Auto-generated method stub
		String sql="select count(*) as COUNT from goods where (name like ? or info like ?) and flag=? and transport=0";
		ResultSet rs=db.execQuery(sql, new Object[]{"%"+keyword+"%","%"+keyword+"%",1});
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
	@Override
	public int getPriceCount(String keyword, double pricefrom, double priceto) {
		// TODO Auto-generated method stub
		String sql="select count(*) as COUNT from goods where (name like ? or info like ?) and flag=? and preprice>=? and preprice <=?";
		ResultSet rs=db.execQuery(sql, new Object[]{"%"+keyword+"%","%"+keyword+"%",1,pricefrom,priceto});
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
