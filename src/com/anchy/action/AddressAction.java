package com.anchy.action;

import java.util.List;
import java.util.Map;

import com.anchy.biz.AddressBiz;
import com.anchy.biz.impl.AddressBizImpl;
import com.anchy.po.Address;
import com.opensymphony.xwork2.ActionContext;

public class AddressAction {
	private int aid;
	private String province;
	private String city;
	private String district;
	private String detail;
	private int auid;
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
	public int getAuid() {
		return auid;
	}
	public void setAuid(int auid) {
		this.auid = auid;
	}
	public String getAddress(){
		Map<String, Object> session=ActionContext.getContext().getSession();
		AddressBiz addressBiz=new AddressBizImpl();
		List<Address> addressList=addressBiz.getAddressByUser(auid);
		session.put("addressList", addressList);
		return "getaddress";
	}
	public String addAddress(){
		Map<String, Object> session=ActionContext.getContext().getSession();
		AddressBiz addressBiz=new AddressBizImpl();
		addressBiz.addAddress(province, city, district, detail, auid);
		List<Address> addressList=addressBiz.getAddressByUser(auid);
		session.put("addressList", addressList);
		return "addaddress";
	}
	public String delAddress(){
		Map<String, Object> session=ActionContext.getContext().getSession();
		AddressBiz addressBiz=new AddressBizImpl();
		addressBiz.delAddress(aid);
		List<Address> addressList=addressBiz.getAddressByUser(auid);
		session.put("addressList", addressList);
		return "deladdress";
	}
}
