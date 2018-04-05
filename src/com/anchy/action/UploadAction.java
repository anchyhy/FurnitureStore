package com.anchy.action;

import java.io.File;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.anchy.biz.SellerBiz;
import com.anchy.biz.impl.SellerBizImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.jmx.snmp.Timestamp;



public class UploadAction extends ActionSupport {
	private File FileI;// 得到上传的文件 
	private String FileIContentType;// 得到文件的类型  
	private String FileIName;// 得到文件的名称
	
	private File FileII;// 得到上传的文件 
	private String FileIIContentType;// 得到文件的类型  
	private String FileIIName;// 得到文件的名称
	
	private File FileIII;// 得到上传的文件 
	private String FileIIIContentType;// 得到文件的类型  
	private String FileIIIName;// 得到文件的名称
	
	private int uid;
	
	

	
	
	

	public File getFileI() {
		return FileI;
	}

	public void setFileI(File fileI) {
		FileI = fileI;
	}

	public String getFileIContentType() {
		return FileIContentType;
	}

	public void setFileIContentType(String fileIContentType) {
		FileIContentType = fileIContentType;
	}

	public String getFileIName() {
		return FileIName;
	}

	public void setFileIName(String fileIName) {
		FileIName = fileIName;
	}

	public File getFileII() {
		return FileII;
	}

	public void setFileII(File fileII) {
		FileII = fileII;
	}

	public String getFileIIContentType() {
		return FileIIContentType;
	}

	public void setFileIIContentType(String fileIIContentType) {
		FileIIContentType = fileIIContentType;
	}

	public String getFileIIName() {
		return FileIIName;
	}

	public void setFileIIName(String fileIIName) {
		FileIIName = fileIIName;
	}

	public File getFileIII() {
		return FileIII;
	}

	public void setFileIII(File fileIII) {
		FileIII = fileIII;
	}

	public String getFileIIIContentType() {
		return FileIIIContentType;
	}

	public void setFileIIIContentType(String fileIIIContentType) {
		FileIIIContentType = fileIIIContentType;
	}

	public String getFileIIIName() {
		return FileIIIName;
	}

	public void setFileIIIName(String fileIIIName) {
		FileIIIName = fileIIIName;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String sellerUpload()throws Exception{
		String realpath=ServletActionContext.getServletContext().getRealPath("/images");
		File dir=new File(realpath);
		if(!dir.exists()){
			dir.mkdir();
		}
		if(FileIContentType.equals("image/jpeg")){
			FileIContentType=".jpg";
			}
		else if(FileIContentType.equals("image/png")){
			FileIContentType=".png";
			}
		else if(FileIContentType.equals("image/gif")){
			FileIContentType=".gif";
			}
		if(FileIIContentType.equals("image/jpeg")){
			FileIIContentType=".jpg";
			}
		else if(FileIIContentType.equals("image/png")){
			FileIIContentType=".png";
			}
		else if(FileIIContentType.equals("image/gif")){
			FileIIContentType=".gif";
			}
		if(FileIIIContentType.equals("image/jpeg")){
			FileIIIContentType=".jpg";
			}
		else if(FileIIIContentType.equals("image/png")){
			FileIIIContentType=".png";
			}
		else if(FileIIIContentType.equals("image/gif")){
			FileIIIContentType=".gif";
			}
		FileIName="image"+new Timestamp().getDateTime()+FileIContentType;
		FileUtils.copyFile(FileI,new File(dir,FileIName));
		FileIIName="image"+new Timestamp().getDateTime()+FileIIContentType;
		FileUtils.copyFile(FileII,new File(dir,FileIIName));
		FileIIIName="image"+new Timestamp().getDateTime()+FileIIIContentType;
		FileUtils.copyFile(FileIII,new File(dir,FileIIIName));
		
		
		
		
		Map<String, Object> session=ActionContext.getContext().getSession();
		SellerBiz sellerBiz= new SellerBizImpl();
		sellerBiz.addSeller(uid, FileIName, FileIIName, FileIIIName);
		return "sellerupload";
	}
}
