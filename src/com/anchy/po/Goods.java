package com.anchy.po;

import java.io.Serializable;

public class Goods implements Serializable {
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
	private String photo;
	private double transport;
	private int flag;
	private String message;
	private User user;
	private Third third;
	private Material gmaterial;
	private Style gstyle;
	private Brand gbrand;
	private int evaluate;
	public Goods(int gid, String name, String info, String detail,
			String material, String color, String style, String brand,
			double oriprice, double preprice, String photo, double transport,
			int flag, String message, User user, Third third,
			Material gmaterial, Style gstyle, Brand gbrand) {
		super();
		this.gid = gid;
		this.name = name;
		this.info = info;
		this.detail = detail;
		this.material = material;
		this.color = color;
		this.style = style;
		this.brand = brand;
		this.oriprice = oriprice;
		this.preprice = preprice;
		this.photo = photo;
		this.transport = transport;
		this.flag = flag;
		this.message = message;
		this.user = user;
		this.third = third;
		this.gmaterial = gmaterial;
		this.gstyle = gstyle;
		this.gbrand = gbrand;
	}

	public Goods() {
		super();
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
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public Material getGmaterial() {
		return gmaterial;
	}

	public void setGmaterial(Material gmaterial) {
		this.gmaterial = gmaterial;
	}

	public Style getGstyle() {
		return gstyle;
	}

	public void setGstyle(Style gstyle) {
		this.gstyle = gstyle;
	}

	public Brand getGbrand() {
		return gbrand;
	}

	public void setGbrand(Brand gbrand) {
		this.gbrand = gbrand;
	}

	public int getEvaluate() {
		return evaluate;
	}

	public void setEvaluate(int evaluate) {
		this.evaluate = evaluate;
	}
}
