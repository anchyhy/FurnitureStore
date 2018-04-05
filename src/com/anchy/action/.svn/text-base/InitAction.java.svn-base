package com.anchy.action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.anchy.biz.CartBiz;
import com.anchy.biz.GoodsBiz;
import com.anchy.biz.InitBiz;
import com.anchy.biz.SlideBiz;
import com.anchy.biz.impl.GoodsBizImpl;
import com.anchy.biz.impl.InitBizImpl;
import com.anchy.biz.impl.SlideBizImpl;
import com.anchy.dao.InitDao;
import com.anchy.po.Classify;
import com.anchy.po.Goods;
import com.opensymphony.xwork2.ActionContext;
import com.sun.jmx.snmp.Timestamp;

public class InitAction {
	private int fid;
	private String fname;
	private int sid;
	private String sname;
	private int tid;
	private String tname;
	private String photo;
	private String saying;
	private File file;
	private String fileContentType;
	private String fileFileName;
	
	
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getSaying() {
		return saying;
	}
	public void setSaying(String saying) {
		this.saying = saying;
	}
	
	public String init(){
		Map<String, Object> session=ActionContext.getContext().getSession();
		InitBiz initBiz=new InitBizImpl();
		Map<String, Map<String,List<String>>> classifyTree=initBiz.getClassify();
		session.put("classifyTree", classifyTree);
		
		SlideBiz slideBiz=new SlideBizImpl();
		session.put("slideList", slideBiz.getSlide());
		
		GoodsBiz goodsBiz=new GoodsBizImpl();
		session.put("newList", goodsBiz.getNew());
		session.put("specialList", goodsBiz.getSpecial());
		List<Goods> topList=goodsBiz.getTop();
		session.put("topList",topList);
		return "init";
	}
	
	public String showSlide(){
		Map<String, Object> session=ActionContext.getContext().getSession();
		SlideBiz slideBiz=new SlideBizImpl();
		session.put("slideList", slideBiz.getSlide());
		return "showslide";
	}
	public String addSlide()throws Exception{
		if (file!=null) {
			String realpath = ServletActionContext.getServletContext()
					.getRealPath("/images");
			File dir = new File(realpath);
			if (!dir.exists()) {
				dir.mkdir();
			}
			if (fileContentType.equals("image/jpeg")) {
				fileContentType = ".jpg";
			} else if (fileContentType.equals("image/png")) {
				fileContentType = ".png";
			} else if (fileContentType.equals("image/gif")) {
				fileContentType = ".gif";
			}
			fileFileName = "image" + new Timestamp().getDateTime()
					+ fileContentType;
			FileUtils.copyFile(file, new File(dir, fileFileName));
		
		Map<String, Object> session=ActionContext.getContext().getSession();
		SlideBiz slideBiz=new SlideBizImpl();
		slideBiz.addSlide(fileFileName, saying);
		}
		return "addslide";
	}
	public String delSlide(){
		Map<String, Object> session=ActionContext.getContext().getSession();
		SlideBiz slideBiz=new SlideBizImpl();
		slideBiz.delSlide(sid);
		session.put("slideList", slideBiz.getSlide());
		return "delslide";
	}
}
