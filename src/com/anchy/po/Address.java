package com.anchy.po;

import java.io.Serializable;

public class Address implements Serializable {
	private int aid;
	private String province;
	private String city;
	private String district;
	private String detail;
	private User user;
	
	public Address() {
		super();
	}

	public Address(int aid, String province, String city, String district,
			String detail, User user) {
		super();
		this.aid = aid;
		this.province = province;
		this.city = city;
		this.district = district;
		this.detail = detail;
		this.user = user;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
