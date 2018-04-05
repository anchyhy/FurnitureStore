package com.anchy.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.anchy.dao.OrderDao;
import com.anchy.po.Address;
import com.anchy.po.Goods;
import com.anchy.po.Order;
import com.anchy.po.Type;
import com.anchy.po.User;
import com.anchy.util.DBHelper;

public class OrderDaoImpl implements OrderDao {
	DBHelper db=new DBHelper();
	@Override
	//下单
	public void addOrder(int tid, int uid, int aid, String message,int quantity) {
		// TODO Auto-generated method stub
		String sql="update type set number=number-? where typeid=?";
		db.execOthers(sql, new Object[]{quantity,tid});
		sql="insert into `order` (otid,oaid,ouid,message,flag,quantity) VALUES(?,?,?,?,?,?)";
		db.execOthers(sql, new Object[]{tid,aid,uid,message,0,quantity});
		
	}
	//获取订单
	@Override
	public List<Order> getOrder(int ouid) {
		// TODO Auto-generated method stub
		String sql="select g.goodsid,g.name,g.preprice,g.transport,a.*,t.kind,t.photo ,t.typeid,o.* from `order` o join address a on o.oaid=a.addressid join type t on t.typeid=o.otid join goods g on g.goodsid=tgid where ouid=?";
		ResultSet rs=db.execQuery(sql, new Object[]{ouid});
		List<Order> orderList=new ArrayList<Order>();
		try {
			while(rs.next()){
				Order order=new Order();
				Goods goods=new Goods();
				goods.setGid(rs.getInt("goodsid"));
				goods.setName(rs.getString("name"));
				goods.setPreprice(rs.getDouble("preprice"));
				goods.setTransport(rs.getDouble("transport"));
				Address address=new Address();
				address.setAid(rs.getInt("addressid"));
				address.setCity(rs.getString("city"));
				address.setDetail(rs.getString("detail"));
				address.setDistrict(rs.getString("district"));
				address.setProvince(rs.getString("province"));
				Type type=new Type();
				type.setKind(rs.getString("kind"));
				type.setPhoto(rs.getString("photo"));
				type.setTid(rs.getInt("typeid"));
				order.setFlag(rs.getInt("flag"));
				order.setMessage(rs.getString("message"));
				order.setOaid(rs.getInt("oaid"));
				order.setOid(rs.getInt("orderid"));
				order.setOtid(rs.getInt("otid"));
				order.setOuid(rs.getInt("ouid"));
				order.setQuantity(rs.getInt("quantity"));
				order.setAddress(address);
				order.setType(type);
				order.setGoods(goods);
				orderList.add(order);
			}
			return orderList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//获取需要发货的订单
	@Override
	public List<Order> showSOrder(int uid) {
		// TODO Auto-generated method stub
		String sql="select a.*,g.goodsid,u.* ,o.* ,t.* from address a join `order` o on o.oaid=a.addressid join type t on t.typeid=o.otid join goods g on g.goodsid=t.tgid join user u on u.userid=o.ouid where o.flag=? and g.guid=?";
		ResultSet rs=db.execQuery(sql, new Object[]{1,uid});
		List<Order> orderList=new ArrayList<Order>();
		try {
			while(rs.next()){
				Address a=new Address();
				a.setCity(rs.getString("city"));
				a.setDetail(rs.getString("detail"));
				a.setDistrict(rs.getString("district"));
				a.setProvince(rs.getString("province"));
				
				Goods g=new Goods();
				g.setGid(rs.getInt("goodsid"));
				
				User u=new User();
				u.setEmail(rs.getString("email"));
				u.setNickname(rs.getString("nickname"));
				u.setPhone(rs.getString("phone"));
				u.setTruename(rs.getString("truename"));
				
				Type t=new Type();
				t.setKind(rs.getString("kind"));
				
				Order o=new Order();
				o.setOid(rs.getInt("orderid"));
				o.setGoods(g);
				o.setAddress(a);
				o.setUser(u);
				o.setType(t);
				o.setMessage(rs.getString("message"));
				o.setOtid(rs.getInt("otid"));
				o.setQuantity(rs.getInt("quantity"));
				
				orderList.add(o);
			}
			return orderList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//卖家进行家具发货
	@Override
	public void sDispatch(int oid) {
		// TODO Auto-generated method stub
		String sql="update `order` set flag=2 where orderid=?";
		db.execOthers(sql, new Object[]{oid});
	}
	@Override
	public List<Order> showAOrder() {
		// TODO Auto-generated method stub
		String sql="select g.goodsid,u.nickname,u.phone,u.truename,u.email,u1.nickname as NICKNAME,u1.phone as PHONE,u1.truename as TRUENAME,u1.email as EMAIL,a.*, o.* ,t.kind from `order` o join address a on a.addressid=o.oaid join user u on u.userid=o.ouid  join type t on t.typeid=o.otid join goods g on t.tgid=g.goodsid join user u1 on u1.userid=g.guid where o.flag=?";
		ResultSet rs=db.execQuery(sql, new Object[]{0});
		List<Order> orderList=new ArrayList<Order>();
		try {
			while(rs.next()){
				Address a=new Address();
				a.setCity(rs.getString("city"));
				a.setDetail(rs.getString("detail"));
				a.setDistrict(rs.getString("district"));
				a.setProvince(rs.getString("province"));
				
				
				
				User u=new User();
				u.setEmail(rs.getString("email"));
				u.setNickname(rs.getString("nickname"));
				u.setPhone(rs.getString("phone"));
				u.setTruename(rs.getString("truename"));
				User u1=new User();
				u1.setEmail(rs.getString("EMAIL"));
				u1.setNickname(rs.getString("NICKNAME"));
				u1.setPhone(rs.getString("PHONE"));
				u1.setTruename(rs.getString("TRUENAME"));
				
				Goods g=new Goods();
				g.setGid(rs.getInt("goodsid"));
				g.setUser(u1);
				
				Type t=new Type();
				t.setKind(rs.getString("kind"));
				t.setGoods(g);
				
				Order o=new Order();
				o.setOid(rs.getInt("orderid"));
				o.setAddress(a);
				o.setUser(u);
				o.setType(t);
				o.setMessage(rs.getString("message"));
				o.setOtid(rs.getInt("otid"));
				o.setQuantity(rs.getInt("quantity"));
				
				orderList.add(o);
			}
			return orderList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//管理员同意订单
	@Override
	public void agrOrder(int oid) {
		// TODO Auto-generated method stub
		String sql="update `order` set flag=1 where orderid=?";
		db.execOthers(sql, new Object[]{oid});
	}
	//确认收货
	@Override
	public void receiveGoods(int oid) {
		// TODO Auto-generated method stub
		String sql="update `order` set flag=3 where orderid=?";
		db.execOthers(sql, new Object[]{oid});
	}
	//评价订单
	@Override
	public void evaluate(int oid, int rate) {
		// TODO Auto-generated method stub
		String sql="update `order` set flag=4 where orderid=?";
		db.execOthers(sql, new Object[]{oid});
		sql="select g1.evaluate from goods g1 where g1.goodsid in (select g.goodsid from goods g join type t on t.tgid=g.goodsid join `order` o on o.otid=t.typeid where o.orderid=? )";
		ResultSet rs1=db.execQuery(sql, new Object[]{oid}); 
		sql="select count(*) as count from `order` o1 join type t1 on t1.typeid=o1.otid join goods g1 on g1.goodsid=t1.tgid where g1.goodsid in (select g.goodsid from goods g join type t on t.tgid=g.goodsid join `order` o on o.otid=t.typeid where o.orderid=? )";
		ResultSet rs2=db.execQuery(sql, new Object[]{oid});
		sql="select g.goodsid from goods g join type t on t.tgid=g.goodsid join `order` o on o.otid=t.typeid where o.orderid=?";
		ResultSet rs3=db.execQuery(sql, new Object[]{oid});
		try {
			if(rs1.next()&&rs2.next()&&rs3.next()){
				db.execOthers("update goods set evaluate=? where goodsid=?", new Object[]{(rs2.getInt("count")*rs1.getInt("evaluate")+rate)/(rs2.getInt("count")+1),rs3.getInt("goodsid")});
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
