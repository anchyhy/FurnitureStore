package com.anchy.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.anchy.biz.AddressBiz;
import com.anchy.biz.CartBiz;
import com.anchy.biz.GoodsBiz;
import com.anchy.biz.OrderBiz;
import com.anchy.biz.ThirdBiz;
import com.anchy.biz.TypeBiz;
import com.anchy.biz.UserBiz;
import com.anchy.biz.impl.AddressBizImpl;
import com.anchy.biz.impl.CartBizImpl;
import com.anchy.biz.impl.GoodsBizImpl;
import com.anchy.biz.impl.OrderBizImpl;
import com.anchy.biz.impl.ThirdBizImpl;
import com.anchy.biz.impl.TypeBizImpl;
import com.anchy.biz.impl.UserBizImpl;
import com.anchy.po.Address;
import com.anchy.po.Cart;
import com.anchy.po.Goods;
import com.anchy.po.Order;
import com.anchy.po.Type;
import com.anchy.po.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.opensymphony.xwork2.ActionContext;

public class OrderAction {
	private int oid;
	private int tid;
	private int uid;
	private int flag;
	private int aid;
	private int gid;
	private int rate;
	public String message;
	public String kind;
	public int quantity;
	public String typeid;
	public String cartList;
	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

	public String getTypeid() {
		return typeid;
	}

	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}

	

	public String getCartList() {
		return cartList;
	}

	public void setCartList(String cartList) {
		this.cartList = cartList;
	}

	public String goOrder()throws UnsupportedEncodingException {
		Map<String, Object> session = ActionContext.getContext().getSession();
		this.kind = new String(kind.getBytes("ISO-8859-1"), "UTF-8");
		TypeBiz typeBiz = new TypeBizImpl();
		Type type = typeBiz.getTypeById(typeBiz.getTypeByKind(gid, kind));
		if (type.getNumber() < quantity){
			session.put("showMessage", "<script type='text/javascript'> alert('您购买的属性库存不够了。。。')</script>");
			return "false";
		}
		else {
			GoodsBiz goodsBiz = new GoodsBizImpl();
			Goods goods = goodsBiz.getGoodsById(gid);
			AddressBiz addressBiz = new AddressBizImpl();
			List<Address> addressList = addressBiz.getAddressByUser(uid);
			UserBiz userBiz=new UserBizImpl();
			User seller=userBiz.getUserByGoods(gid);
			session.put("uid", uid);
			session.put("gid", gid);
			session.put("kind", kind);
			session.put("quantity", quantity);
			session.put("goods", goods);
			session.put("addressList", addressList);
			session.put("type", type);
			session.put("seller", seller);
			return "goorder";
		}
	}
	public String addOrder(){
		OrderBiz orderBiz=new OrderBizImpl();
		if(message==null)
		 orderBiz.addOrder(tid, uid, aid, "无", quantity);
		else orderBiz.addOrder(tid, uid, aid, message, quantity);
		return "addorder";
	}
	public String addMoreOrder(){
		OrderBiz orderBiz=new OrderBizImpl();
		CartBiz cartBiz=new CartBizImpl();
		String Msg[]=message.split(", ");
		String[] tid = typeid.split(", "); 
		if(Msg.length==0){
			for(int i=0;i<tid.length;i++){
				orderBiz.addOrder(Integer.parseInt(tid[i]), uid, aid, "无",cartBiz.countByType(uid, Integer.parseInt(tid[i])) );
				for(int j=1;j<=cartBiz.countByType(uid, Integer.parseInt(tid[i]));j++){
					cartBiz.reduceQuantity(uid, Integer.parseInt(tid[i]));
				}
			}
		}else{
			for(int i=0;i<tid.length;i++){
				orderBiz.addOrder(Integer.parseInt(tid[i]), uid, aid, Msg[i],cartBiz.countByType(uid, Integer.parseInt(tid[i])) );
				for(int j=1;j<=Integer.parseInt(tid[i]);j++){
					cartBiz.reduceQuantity(uid, Integer.parseInt(tid[i]));
				}
			}
		}
		
		return "addmoreorder";
	}
	public String getOrder(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		OrderBiz orderBiz=new OrderBizImpl();
		List<Order> orderList=orderBiz.getOrder(uid);
		session.put("orderList", orderList);
		return "getorder";
	}
	
	public String getSOrder(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		OrderBiz orderBiz=new OrderBizImpl();
		List<Order> sorderList=new ArrayList<Order>();
		sorderList=orderBiz.showSOrder(uid);
		session.put("sorderList", sorderList);
		session.put("osum", sorderList.size());
		return "getsorder";
	}
	public String sDispatch(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		OrderBiz orderBiz=new OrderBizImpl();
		orderBiz.sDispatch(oid);
		List<Order> sorderList=new ArrayList<Order>();
		sorderList=orderBiz.showSOrder(uid);
		session.put("sorderList", sorderList);
		session.put("osum", sorderList.size());
		ThirdBiz thirdBiz=new ThirdBizImpl();
		session.put("sthird", thirdBiz.getSThird(uid));
		GoodsBiz goodsBiz=new GoodsBizImpl();
		session.put("sdgsum", goodsBiz.getDisAgrGoods(uid).size());
		session.put("srgsum", goodsBiz.getSRGoods(uid).size());
		return "sdispatch";
	}
	public String checkOrder(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		OrderBiz orderBiz=new OrderBizImpl();
		List<Order> aorderList=new ArrayList<Order>();
		aorderList=orderBiz.showAOrder();
		session.put("aorderList", aorderList);
		session.put("aosum", orderBiz.showAOrder().size());
		session.remove("reloadmessage");
		return "checkorder";
	}
	public String agrOrder(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		OrderBiz orderBiz=new OrderBizImpl();
		orderBiz.agrOrder(oid);
		session.put("aorderList", orderBiz.showAOrder());
		session.put("reloadmessage", "2");
		return "agrorder";
	}
	public String cartToOrder(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		TypeBiz typeBiz=new TypeBizImpl();
		CartBiz cartBiz=new CartBizImpl();
		AddressBiz addressBiz=new AddressBizImpl();
		String[] tid = this.typeid.split(", ");  
		for(int i=0;i<tid.length;i++){
			if((typeBiz.getTypeById(Integer.parseInt(tid[i])).getNumber())<(cartBiz.countByType(uid, Integer.parseInt(tid[i]))))
				return "false";
		}
		List<Cart> cartList=new ArrayList<Cart> ();
		for(int i=0;i<tid.length;i++){
			Cart cart=new Cart();
			cart=cartBiz.getCartByUserAndType(uid, Integer.parseInt(tid[i]));
			cartList.add(cart);
		}
		session.put("typeid", typeid);
		session.put("cartList", cartList);
		session.put("addressList", addressBiz.getAddressByUser(uid));
		return "carttoorder";
	}
	public String receiveOrder(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		OrderBiz orderBiz=new OrderBizImpl();
		orderBiz.receiveGoods(oid);
		List<Order> orderList=orderBiz.getOrder(uid);
		session.put("orderList", orderList);
		return "revceiveorder";
	}
	public String evaluate(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		OrderBiz orderBiz=new OrderBizImpl();
		if(rate==1)
			orderBiz.evaluate(oid, 0);
		else if(rate==0)
			orderBiz.evaluate(oid, 5);
		else 
			orderBiz.evaluate(oid, rate-1);
		List<Order> orderList=orderBiz.getOrder(uid);
		session.put("orderList", orderList);
		return "evaluate";
	}
}
