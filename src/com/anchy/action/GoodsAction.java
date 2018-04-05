package com.anchy.action;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;























import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.anchy.biz.BrandBiz;
import com.anchy.biz.GoodsBiz;
import com.anchy.biz.MaterialBiz;
import com.anchy.biz.OrderBiz;
import com.anchy.biz.SeenBiz;
import com.anchy.biz.StyleBiz;
import com.anchy.biz.ThirdBiz;
import com.anchy.biz.TypeBiz;
import com.anchy.biz.impl.BrandBizImpl;
import com.anchy.biz.impl.GoodsBizImpl;
import com.anchy.biz.impl.MaterialBizImpl;
import com.anchy.biz.impl.OrderBizImpl;
import com.anchy.biz.impl.StyleBizImpl;
import com.anchy.biz.impl.ThirdBizImpl;
import com.anchy.biz.impl.TypeBizImpl;
import com.anchy.dao.SeenBizImpl;
import com.anchy.po.Goods;
import com.anchy.po.Order;
import com.anchy.po.Third;
import com.anchy.po.Type;
import com.anchy.po.User;
import com.opensymphony.xwork2.ActionContext;
import com.sun.jmx.snmp.Timestamp;

public class GoodsAction {
	private int pageNum;
	private int pageSize;
	private String keyword1;
	private int discount;
	private int bid;
	private int sid;
	private int mid;
	private int gid;
	private String name;
	private String info;
	private String detail;
	private String material;
	private String color;
	private String style;
	private String brand;
	private double oriprice;
	private double preprice;
	private double pricefrom;
	private double priceto;
	private String photo;
	private double transport;
	private User user;
	private int uid;
	private Third third;
	private int gtid;
	private String pname;
	private String message;
	
	private int tid;
	private Goods goods;
	private String kind;
	private int number;
	private String tphoto;
	
	
	private File[] multipleFile;// 得到上传的文件 
	private String[] multipleFileContentType;// 得到文件的类型  
	private String[] multipleFileName;// 得到文件的名称
	
	private File uploadFile;// 得到上传的文件 
	private String uploadFileContentType;// 得到文件的类型  
	private String uploadFileName;// 得到文件的名称
	
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getKeyword1() {
		return keyword1;
	}
	public void setKeyword1(String keyword1) {
		this.keyword1 = keyword1;
	}
	
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getOriprice() {
		return oriprice;
	}
	public void setOriprice(double oriprice) {
		this.oriprice = oriprice;
	}
	public double getPreprice() {
		return preprice;
	}
	public void setPreprice(double preprice) {
		this.preprice = preprice;
	}
	public double getPricefrom() {
		return pricefrom;
	}
	public void setPricefrom(double pricefrom) {
		this.pricefrom = pricefrom;
	}
	public double getPriceto() {
		return priceto;
	}
	public void setPriceto(double priceto) {
		this.priceto = priceto;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public double getTransport() {
		return transport;
	}
	public void setTransport(double transport) {
		this.transport = transport;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Third getThird() {
		return third;
	}
	public void setThird(Third third) {
		this.third = third;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getTphoto() {
		return tphoto;
	}
	public void setTphoto(String tphoto) {
		this.tphoto = tphoto;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getGtid() {
		return gtid;
	}
	public void setGtid(int gtid) {
		this.gtid = gtid;
	}
	
	public File[] getMultipleFile() {
		return multipleFile;
	}
	public void setMultipleFile(File[] multipleFile) {
		this.multipleFile = multipleFile;
	}
	public String[] getMultipleFileContentType() {
		return multipleFileContentType;
	}
	public void setMultipleFileContentType(String[] multipleFileContentType) {
		this.multipleFileContentType = multipleFileContentType;
	}
	public String[] getMultipleFileName() {
		return multipleFileName;
	}
	public void setMultipleFileName(String[] multipleFileName) {
		this.multipleFileName = multipleFileName;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public File getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}
	public String getUploadFileContentType() {
		return uploadFileContentType;
	}
	public void setUploadFileContentType(String uploadFileContentType) {
		this.uploadFileContentType = uploadFileContentType;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String firstSearch()throws UnsupportedEncodingException{
		Map<String, Object> session=ActionContext.getContext().getSession();
		GoodsBiz goodsBiz=new GoodsBizImpl();
		this.keyword1 = new String(keyword1.getBytes("ISO-8859-1"), "UTF-8");
		int d[]=goodsBiz.getDiscount(keyword1);
		List<Goods> goodsList=goodsBiz.firstSearch(keyword1, pageNum, pageSize);
		int cfirst=goodsBiz.getFirstSearchCount(keyword1);
		session.put("cfirst", cfirst);
		session.put("goodsList1", goodsList);
		session.put("d", d);
		session.put("keyword1", keyword1);
		session.put("pageSize", pageSize);
		session.put("pageNum", pageNum);
		BrandBiz brandBiz=new BrandBizImpl();
		session.put("brandList", brandBiz.getByKeyword(keyword1));
		StyleBiz styleBiz=new StyleBizImpl();
		session.put("styleList", styleBiz.getByKeyword(keyword1));
		MaterialBiz materialBiz=new MaterialBizImpl();
		session.put("materialList", materialBiz.getMaterialByKeyword(keyword1));
		session.put("searchflag", 1);
		return "firstsearch";
	}
	public String discountSearch()throws UnsupportedEncodingException{
		Map<String, Object> session=ActionContext.getContext().getSession();
		GoodsBiz goodsBiz=new GoodsBizImpl();
		this.keyword1 = new String(keyword1.getBytes("ISO-8859-1"), "UTF-8");
		System.out.println(keyword1);
		int d[]=goodsBiz.getDiscount(keyword1);
		List<Goods> goodsList=goodsBiz.searchByDiscount(keyword1, pageNum, pageSize, discount);
		int cdiscount=goodsBiz.getDiscountCount(keyword1, discount);
		session.put("cdiscount", cdiscount);
		session.put("goodsList1", goodsList);
		session.put("d", d);
		session.put("keyword1", keyword1);
		session.put("pageSize", pageSize);
		session.put("pageNum", pageNum);
		session.put("discount", discount);
		BrandBiz brandBiz=new BrandBizImpl();
		session.put("brandList", brandBiz.getByKeyword(keyword1));
		StyleBiz styleBiz=new StyleBizImpl();
		session.put("styleList", styleBiz.getByKeyword(keyword1));
		MaterialBiz materialBiz=new MaterialBizImpl();
		session.put("materialList", materialBiz.getMaterialByKeyword(keyword1));
		session.put("searchflag", 2);
		return "discountsearch";
	}
	public String brandSearch()throws UnsupportedEncodingException{
		Map<String, Object> session=ActionContext.getContext().getSession();
		GoodsBiz goodsBiz=new GoodsBizImpl();
		this.keyword1 = new String(keyword1.getBytes("ISO-8859-1"), "UTF-8");
		int d[]=goodsBiz.getDiscount(keyword1);
		System.out.println(keyword1);
		List<Goods> goodsList=goodsBiz.searchByBrand(keyword1, pageNum, pageSize, bid);
		int cbrand=goodsBiz.getBrandCount(keyword1, bid);
		session.put("cbrand", cbrand);
		session.put("goodsList1", goodsList);
		session.put("d", d);
		session.put("keyword1", keyword1);
		session.put("pageSize", pageSize);
		session.put("pageNum", pageNum);
		session.put("bid", bid);
		BrandBiz brandBiz=new BrandBizImpl();
		session.put("brandList", brandBiz.getByKeyword(keyword1));
		StyleBiz styleBiz=new StyleBizImpl();
		session.put("styleList", styleBiz.getByKeyword(keyword1));
		MaterialBiz materialBiz=new MaterialBizImpl();
		session.put("materialList", materialBiz.getMaterialByKeyword(keyword1));
		session.put("searchflag", 4);
		return "brandsearch";
	}
	public String styleSearch()throws UnsupportedEncodingException{
		Map<String, Object> session=ActionContext.getContext().getSession();
		GoodsBiz goodsBiz=new GoodsBizImpl();
		this.keyword1 = new String(keyword1.getBytes("ISO-8859-1"), "UTF-8");
		int d[]=goodsBiz.getDiscount(keyword1);
		List<Goods> goodsList=goodsBiz.searchByStyle(keyword1, pageNum, pageSize, sid);
		int cstyle=goodsBiz.getStyleCount(keyword1, sid);
		session.put("cstyle", cstyle);
		session.put("goodsList1", goodsList);
		session.put("d", d);
		session.put("keyword1", keyword1);
		session.put("pageSize", pageSize);
		session.put("pageNum", pageNum);
		session.put("sid", sid);
		BrandBiz brandBiz=new BrandBizImpl();
		session.put("brandList", brandBiz.getByKeyword(keyword1));
		StyleBiz styleBiz=new StyleBizImpl();
		session.put("styleList", styleBiz.getByKeyword(keyword1));
		MaterialBiz materialBiz=new MaterialBizImpl();
		session.put("materialList", materialBiz.getMaterialByKeyword(keyword1));
		session.put("searchflag", 3);
		return "stylesearch";
	}
	public String materialSearch()throws UnsupportedEncodingException{
		Map<String, Object> session=ActionContext.getContext().getSession();
		GoodsBiz goodsBiz=new GoodsBizImpl();
		this.keyword1 = new String(keyword1.getBytes("ISO-8859-1"), "UTF-8");
		int d[]=goodsBiz.getDiscount(keyword1);
		List<Goods> goodsList=goodsBiz.searchByMaterial(keyword1, pageNum, pageSize, mid);
		int cmaterial=goodsBiz.getMaterialCount(keyword1, mid);
		session.put("cmaterial", cmaterial);
		session.put("goodsList1", goodsList);
		session.put("d", d);
		session.put("keyword1", keyword1);
		session.put("pageSize", pageSize);
		session.put("pageNum", pageNum);
		session.put("mid", mid);
		BrandBiz brandBiz=new BrandBizImpl();
		session.put("brandList", brandBiz.getByKeyword(keyword1));
		StyleBiz styleBiz=new StyleBizImpl();
		session.put("styleList", styleBiz.getByKeyword(keyword1));
		MaterialBiz materialBiz=new MaterialBizImpl();
		session.put("materialList", materialBiz.getMaterialByKeyword(keyword1));
		session.put("searchflag", 5);
		return "materialsearch";
	}
	public String single(){
		Map<String, Object> session=ActionContext.getContext().getSession();
		GoodsBiz goodsBiz=new GoodsBizImpl();
		Goods goods=goodsBiz.getGoodsById(gid);
		TypeBiz typeBiz=new TypeBizImpl();
		List<Type> typeList=typeBiz.getTypeByGoods(gid);
		session.put("recentList", goodsBiz.getRecent(uid));
		SeenBiz seenBiz=new SeenBizImpl();
		seenBiz.addSeen(uid, gid);
		session.put("typeList", typeList);
		session.put("goods", goods);
		session.remove("showMessage");
		return "single";
	}
	public String backSingle(){
		Map<String, Object> session=ActionContext.getContext().getSession();
		GoodsBiz goodsBiz=new GoodsBizImpl();
		Goods goods=goodsBiz.getGoodsById(gid);
		TypeBiz typeBiz=new TypeBizImpl();
		List<Type> typeList=typeBiz.getTypeByGoods(gid);
		session.put("typeList", typeList);
		session.put("goods", goods);
		return "backsingle";
	}
	public String sellerGoods(){
		Map<String, Object> session=ActionContext.getContext().getSession();
		GoodsBiz goodsBiz=new GoodsBizImpl();
		//右边商品
		session.put("sellergoods", goodsBiz.getSellerGoods(uid, pageNum, pageSize));
		session.put("pageSize", pageSize);
		session.put("pageNum", pageNum);
		//拒绝商品
		session.put("srgsum", goodsBiz.getSRGoods(uid).size());
		ThirdBiz thirdBiz=new ThirdBizImpl();
		//左边分类
		session.put("sthird", thirdBiz.getSThird(uid));
		OrderBiz orderBiz=new OrderBizImpl();
		List<Order> sorderList=orderBiz.showSOrder(uid);
		int osum=sorderList.size();
		//订单
		session.put("sorderList", sorderList);
		session.put("osum", osum);
		//未审核商品
		session.put("sdgsum", goodsBiz.getDisAgrGoods(uid).size());
		return "sellergoods";
	}
	public String sellerThird(){
		Map<String, Object> session=ActionContext.getContext().getSession();
		GoodsBiz goodsBiz=new GoodsBizImpl();
		session.put("sellergoods", goodsBiz.getSellerThird(uid,gtid, pageNum, pageSize));
		return "sellerthird";
	}
	public String sellerAddGoods(){
		Map<String, Object> session=ActionContext.getContext().getSession();
		ThirdBiz thirdBiz=new ThirdBizImpl();
		MaterialBiz materialBiz=new MaterialBizImpl();
		StyleBiz styleBiz=new StyleBizImpl();
		BrandBiz brandBiz=new BrandBizImpl();
		session.put("thirdList", thirdBiz.getThird());
		session.put("brandList", brandBiz.getAllBrand());
		session.put("styleList", styleBiz.getAllStyle());
		session.put("materialList", materialBiz.getAllMaterial());
		return "selleraddgoods";
	}
	public String seadGoods( ) throws Exception{
		Map<String, Object> session=ActionContext.getContext().getSession();
		GoodsBiz goodsBiz=new GoodsBizImpl();
		photo="";
		for(int i=0;i<multipleFile.length;i++){
				String realpath = ServletActionContext.getServletContext()
						.getRealPath("/images");
			    File uploadFile=multipleFile[i];// 得到上传的文件 
			    System.out.println(multipleFile[i]);
				String uploadFileContentType="";// 得到文件的类型  
				String uploadFileName;// 得到文件的名称
				File dir = new File(realpath);
				if (!dir.exists()) {
					dir.mkdir();
				}
				if (multipleFileContentType[i].equals("image/jpeg")) {
					uploadFileContentType = ".jpg";
				} else if (multipleFileContentType[i].equals("image/png")) {
					uploadFileContentType = ".png";
				} else if (multipleFileContentType[i].equals("image/gif")) {
					uploadFileContentType = ".gif";
				}
				System.out.println(uploadFileContentType);
				uploadFileName = "image" + new Timestamp().getDateTime()
						+ uploadFileContentType;
				photo+=uploadFileName+";";
				FileUtils.copyFile(uploadFile, new File(dir, uploadFileName));
		}
		
		goodsBiz.addGoods(name, info, detail, mid,material, color, sid,style, bid,brand, uid, gtid, preprice, photo, transport);
		session.put("sellergoods", goodsBiz.getDisAgrGoods(uid));
		session.put("pageSize", pageSize);
		session.put("pageNum", pageNum);
		session.put("srgsum", goodsBiz.getSRGoods(uid).size());
		ThirdBiz thirdBiz=new ThirdBizImpl();
		session.put("sthird", thirdBiz.getSThird(uid));
		OrderBiz orderBiz=new OrderBizImpl();
		List<Order> sorderList=orderBiz.showSOrder(uid);
		int osum=sorderList.size();
		session.put("sorderList", sorderList);
		session.put("osum", osum);
		session.put("sdgsum", goodsBiz.getDisAgrGoods(uid).size());
		return "seadgoods";
	}
	
	public String sellerSingle(){
		Map<String, Object> session=ActionContext.getContext().getSession();
		GoodsBiz goodsBiz=new GoodsBizImpl();
		session.put("goods",goodsBiz.getGoodsById(gid));
		TypeBiz typeBiz=new TypeBizImpl();
		session.put("typeList", typeBiz.getTypeByGoods(gid));
		return "sellersingle";
	}
	
	public String delSellerPhoto(){
		Map<String, Object> session=ActionContext.getContext().getSession();
		GoodsBiz goodsBiz=new GoodsBizImpl();
		goodsBiz.delPhoto(gid, pname);
		session.put("goods",goodsBiz.getGoodsById(gid));
		TypeBiz typeBiz=new TypeBizImpl();
		session.put("typeList", typeBiz.getTypeByGoods(gid));
		return "delsellerphoto";
		
	}
	public String chgGoods(){
		Map<String, Object> session=ActionContext.getContext().getSession();
		GoodsBiz goodsBiz=new GoodsBizImpl();
		goodsBiz.chgGoods(gid, info, detail, material, color, style, brand, preprice, transport);
		session.put("goods",goodsBiz.getGoodsById(gid));
		TypeBiz typeBiz=new TypeBizImpl();
		session.put("typeList", typeBiz.getTypeByGoods(gid));
		return "chggoods";
	}
	public String addPhoto()throws Exception{
		String realpath=ServletActionContext.getServletContext().getRealPath("/images");
		File dir=new File(realpath);
		if(!dir.exists()){
			dir.mkdir();
		}
		if(uploadFileContentType.equals("image/jpeg")){
			uploadFileContentType=".jpg";
			}
		else if(uploadFileContentType.equals("image/png")){
			uploadFileContentType=".png";
			}
		else if(uploadFileContentType.equals("image/gif")){
			uploadFileContentType=".gif";
			}
		uploadFileName="image"+new Timestamp().getDateTime()+uploadFileContentType;
		FileUtils.copyFile(uploadFile,new File(dir,uploadFileName));
		Map<String, Object> session=ActionContext.getContext().getSession();
		GoodsBiz goodsBiz=new GoodsBizImpl();
		goodsBiz.addPhoto(gid, uploadFileName+";");
		session.put("goods",goodsBiz.getGoodsById(gid));
		TypeBiz typeBiz=new TypeBizImpl();
		session.put("typeList", typeBiz.getTypeByGoods(gid));
		return "addphoto";
		
	}
	public String sdelGoods(){
		Map<String, Object> session=ActionContext.getContext().getSession();
		GoodsBiz goodsBiz=new GoodsBizImpl();
		boolean tmp=goodsBiz.delGoods(gid);
		if(tmp){
			session.put("sellergoods", goodsBiz.getSellerGoods(uid, pageNum, pageSize));
			session.put("pageSize", pageSize);
			session.put("pageNum", pageNum);
			ThirdBiz thirdBiz=new ThirdBizImpl();
			session.put("sthird", thirdBiz.getSThird(uid));
			session.put("sdgsum", goodsBiz.getDisAgrGoods(uid).size());
			session.put("srgsum", goodsBiz.getSRGoods(uid).size());
		}
		return "sdelgoods";
		
		
	}
	public String price()throws UnsupportedEncodingException{
		Map<String, Object> session=ActionContext.getContext().getSession();
		GoodsBiz goodsBiz=new GoodsBizImpl();
		this.keyword1 = new String(keyword1.getBytes("ISO-8859-1"), "UTF-8");
		List<Goods> goodsList=goodsBiz.getGoodsByPrice(pricefrom, priceto, keyword1, pageNum, pageSize);
		int cprice=goodsBiz.getPriceCount(keyword1, pricefrom, priceto);
		session.put("cprice", cprice);
		session.put("goodsList1", goodsList);
		session.put("pricefrom", pricefrom);
		session.put("priceto", priceto);
		session.put("keyword1", keyword1);
		session.put("pageSize", pageSize);
		session.put("pageNum", pageNum);
		session.put("searchflag", 6);
		return "price";
	}
	public String transport()throws UnsupportedEncodingException{
		Map<String, Object> session=ActionContext.getContext().getSession();
		GoodsBiz goodsBiz=new GoodsBizImpl();
		this.keyword1 = new String(keyword1.getBytes("ISO-8859-1"), "UTF-8");
		List<Goods> goodsList=goodsBiz.noTransport(keyword1, pageNum, pageSize);
		int ctransport=goodsBiz.getTransportCount(keyword1);
		session.put("ctransport", ctransport);
		session.put("goodsList1", goodsList);
		session.put("keyword1", keyword1);
		session.put("pageSize", pageSize);
		session.put("pageNum", pageNum);
		session.put("searchflag", 7);
		return "transport";
	}
	public String checkGoods(){
		Map<String, Object> session=ActionContext.getContext().getSession();
		GoodsBiz goodsBiz=new GoodsBizImpl();
		List<Goods> agList=new ArrayList<Goods>();
		agList=goodsBiz.checkGoods();
		session.put("agList",agList);
		session.remove("reloadmessage");
		return "checkgoods";
	}
	public String agrGoods(){
		Map<String, Object> session=ActionContext.getContext().getSession();
		GoodsBiz goodsBiz=new GoodsBizImpl();
		goodsBiz.agrGoods(gid);
		List<Goods> agList=goodsBiz.checkGoods();
		session.put("agList",agList);
		session.put("agsum",agList.size());
		session.put("reloadmessage", "3");
		return "agrgoods";
	}
	public String disAgrGoods(){
		Map<String, Object> session=ActionContext.getContext().getSession();
		GoodsBiz goodsBiz=new GoodsBizImpl();
		goodsBiz.disagrGoods(gid, message);
		List<Goods> agList=goodsBiz.checkGoods();
		session.put("agList",agList);
		session.put("agsum",agList.size());
		session.put("reloadmessage", "3");
		return "disagrgoods";
	}
	public String getSDGoods(){
		Map<String, Object> session=ActionContext.getContext().getSession();
		GoodsBiz goodsBiz=new GoodsBizImpl();
		session.put("sellergoods", goodsBiz.getDisAgrGoods(uid));
		ThirdBiz thirdBiz=new ThirdBizImpl();
		session.put("sthird", thirdBiz.getSThird(uid));
		OrderBiz orderBiz=new OrderBizImpl();
		List<Order> sorderList=orderBiz.showSOrder(uid);
		int osum=sorderList.size();
		session.put("sorderList", sorderList);
		session.put("osum", osum);
		session.put("sdgsum", goodsBiz.getDisAgrGoods(uid).size());
		session.put("srgsum", goodsBiz.getSRGoods(uid).size());
		return "getsdgoods";
	}
	public String getSRDoods(){
		Map<String, Object> session=ActionContext.getContext().getSession();
		GoodsBiz goodsBiz=new GoodsBizImpl();
		session.put("sellergoods", goodsBiz.getSRGoods(uid));
		ThirdBiz thirdBiz=new ThirdBizImpl();
		session.put("sthird", thirdBiz.getSThird(uid));
		OrderBiz orderBiz=new OrderBizImpl();
		List<Order> sorderList=orderBiz.showSOrder(uid);
		int osum=sorderList.size();
		session.put("sorderList", sorderList);
		session.put("osum", osum);
		session.put("sdgsum", goodsBiz.getDisAgrGoods(uid).size());
		session.put("srgsum", goodsBiz.getSRGoods(uid).size());
		return "getsrgoods";
	}
}
