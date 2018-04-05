package com.anchy.action;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.anchy.biz.GoodsBiz;
import com.anchy.biz.TypeBiz;
import com.anchy.biz.impl.GoodsBizImpl;
import com.anchy.biz.impl.TypeBizImpl;
import com.anchy.po.Goods;
import com.anchy.po.Type;
import com.opensymphony.xwork2.ActionContext;
import com.sun.jmx.snmp.Timestamp;

public class TypeAction {
	private int gid;
	private int tid;
	private Goods goods;
	private String kind;
	private int number;
	private String photo;
	private File uploadFile;// 得到上传的文件 
	private String uploadFileContentType;// 得到文件的类型  
	private String uploadFileName;// 得到文件的名称
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
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
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
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
	public String delSellerType(){
		Map<String, Object> session=ActionContext.getContext().getSession();
		TypeBiz typeBiz=new TypeBizImpl();
		typeBiz.delSellerType(gid, kind);
		GoodsBiz goodsBiz=new GoodsBizImpl();
		session.put("goods",goodsBiz.getGoodsById(gid));
		session.put("typeList", typeBiz.getTypeByGoods(gid));
		return "delsellertype";
		
	}
	public String chgTNum(){
		Map<String, Object> session=ActionContext.getContext().getSession();
		TypeBiz typeBiz=new TypeBizImpl();
		System.out.println(tid+"ddd"+number);
		typeBiz.changeTNum(tid, number);
		GoodsBiz goodsBiz=new GoodsBizImpl();
		session.put("goods",goodsBiz.getGoodsById(gid));
		session.put("typeList", typeBiz.getTypeByGoods(gid));
		return "chgtnum";
	}
	public String addType()throws Exception{
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
		TypeBiz typeBiz=new TypeBizImpl();
		GoodsBiz goodsBiz=new GoodsBizImpl();
		typeBiz.addType(gid, kind, uploadFileName+";", number);
		session.put("goods",goodsBiz.getGoodsById(gid));
		session.put("typeList", typeBiz.getTypeByGoods(gid));
		return "addtype";
	}
	
}
