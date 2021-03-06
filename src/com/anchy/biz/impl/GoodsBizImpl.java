package com.anchy.biz.impl;

import java.util.List;

import com.anchy.biz.GoodsBiz;
import com.anchy.dao.GoodsDao;
import com.anchy.dao.impl.GoodsDaoImpl;
import com.anchy.po.Goods;

public class GoodsBizImpl implements GoodsBiz {
	GoodsDao goodsDao=new GoodsDaoImpl();
	@Override
	public List<Goods> firstSearch(String keyword1, int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		return goodsDao.firstSearch(keyword1, pageNum, pageSize);
	}
	@Override
	public int[] getDiscount(String keyword) {
		// TODO Auto-generated method stub
		return goodsDao.getDiscount(keyword);
	}
	@Override
	public Goods getGoodsById(int gid) {
		// TODO Auto-generated method stub
		return goodsDao.getGoodsById(gid);
	}
	@Override
	public List<Goods> getSellerGoods(int uid, int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		return goodsDao.getSellerGoods(uid, pageNum, pageSize);
	}
	@Override
	public List<Goods> getSellerThird(int uid, int gtid, int pageNum,
			int pageSize) {
		// TODO Auto-generated method stub
		return goodsDao.getSellerThird(uid, gtid, pageNum, pageSize);
	}
	@Override
	public void addGoods(String name, String info, String detail,int mid,
			String material, String color,int sid, String style,int bid, String brand, int uid,
			int thirdid, double preprice, String photo, double transport) {
		// TODO Auto-generated method stub
		goodsDao.addGoods(name, info, detail,mid, material, color,sid, style,bid, brand, uid, thirdid, preprice, photo, transport);
	}
	@Override
	public void delPhoto(int gid, String pname) {
		// TODO Auto-generated method stub
		goodsDao.delPhoto(gid, pname);
	}
	@Override
	public void chgGoods(int gid, String info, String detail, String material,
			String color, String style, String brand, double preprice,
			double transport) {
		// TODO Auto-generated method stub
		goodsDao.chgGoods(gid, info, detail, material, color, style, brand, preprice, transport);
	}
	@Override
	public void addPhoto(int gid, String pname) {
		// TODO Auto-generated method stub
		goodsDao.addPhoto(gid, pname);
	}
	@Override
	public boolean delGoods(int gid) {
		// TODO Auto-generated method stub
		return goodsDao.delGoods(gid);
	}
	@Override
	public List<Goods> getGoodsByPrice(double pricefrom, double priceto,
			String keyword, int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		return goodsDao.getGoodsByPrice(pricefrom, priceto, keyword, pageNum, pageSize);
	}
	@Override
	public List<Goods> noTransport(String keyword, int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		return goodsDao.noTransport(keyword, pageNum, pageSize);
	}
	@Override
	public List<Goods> getTop() {
		// TODO Auto-generated method stub
		return goodsDao.getTop();
	}
	@Override
	public List<Goods> getNew() {
		// TODO Auto-generated method stub
		return goodsDao.getNew();
	}
	@Override
	public List<Goods> getSpecial() {
		// TODO Auto-generated method stub
		return goodsDao.getSpecial();
	}
	@Override
	public List<Goods> getRecent(int uid) {
		// TODO Auto-generated method stub
		return goodsDao.getRecent(uid);
	}
	@Override
	public List<Goods> checkGoods() {
		// TODO Auto-generated method stub
		return goodsDao.checkGoods();
	}
	@Override
	public void agrGoods(int gid) {
		// TODO Auto-generated method stub
		goodsDao.agrGoods(gid);
	}
	@Override
	public void disagrGoods(int gid, String message) {
		// TODO Auto-generated method stub
		goodsDao.disagrGoods(gid, message);
	}
	@Override
	public List<Goods> getDisAgrGoods(int uid) {
		// TODO Auto-generated method stub
		return goodsDao.getDisAgrGoods(uid);
	}
	@Override
	public List<Goods> getSRGoods(int uid) {
		// TODO Auto-generated method stub
		return goodsDao.getSRGoods(uid);
	}
	@Override
	public List<Goods> searchByDiscount(String keyword, int pageNum,
			int pageSize, int d) {
		// TODO Auto-generated method stub
		return goodsDao.searchByDiscount(keyword, pageNum, pageSize, d);
	}
	@Override
	public List<Goods> searchByBrand(String keyword, int pageNum, int pageSize,
			int bid) {
		// TODO Auto-generated method stub
		return goodsDao.searchByBrand(keyword, pageNum, pageSize, bid);
	}
	@Override
	public List<Goods> searchByMaterial(String keyword, int pageNum,
			int pageSize, int mid) {
		// TODO Auto-generated method stub
		return goodsDao.searchByMaterial(keyword, pageNum, pageSize, mid);
	}
	@Override
	public List<Goods> searchByStyle(String keyword, int pageNum, int pageSize,
			int sid) {
		// TODO Auto-generated method stub
		return goodsDao.searchByStyle(keyword, pageNum, pageSize, sid);
	}
	@Override
	public Goods getGoodsByType(int tid) {
		// TODO Auto-generated method stub
		return goodsDao.getGoodsByType(tid);
	}
	@Override
	public int getFirstSearchCount(String keyword) {
		// TODO Auto-generated method stub
		return goodsDao.getFirstSearchCount(keyword);
	}
	@Override
	public int getDiscountCount(String keyword, int d) {
		// TODO Auto-generated method stub
		return goodsDao.getDiscountCount(keyword, d);
	}
	@Override
	public int getStyleCount(String keyword, int s) {
		// TODO Auto-generated method stub
		return goodsDao.getStyleCount(keyword, s);
	}
	@Override
	public int getBrandCount(String keyword, int b) {
		// TODO Auto-generated method stub
		return goodsDao.getBrandCount(keyword, b);
	}
	@Override
	public int getMaterialCount(String keyword, int m) {
		// TODO Auto-generated method stub
		return goodsDao.getMaterialCount(keyword, m);
	}
	@Override
	public int getTransportCount(String keyword) {
		// TODO Auto-generated method stub
		return goodsDao.getTransportCount(keyword);
	}
	@Override
	public int getPriceCount(String keyword, double pricefrom, double priceto) {
		// TODO Auto-generated method stub
		return goodsDao.getPriceCount(keyword, pricefrom, priceto);
	}

}
