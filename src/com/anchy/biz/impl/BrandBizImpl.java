package com.anchy.biz.impl;

import java.util.List;

import com.anchy.biz.BrandBiz;
import com.anchy.dao.BrandDao;
import com.anchy.dao.impl.BrandDaoImpl;
import com.anchy.po.Brand;

public class BrandBizImpl implements BrandBiz {
	BrandDao brandDao=new BrandDaoImpl();
	@Override
	public List<Brand> getByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return brandDao.getByKeyword(keyword);
	}
	@Override
	public List<Brand> getAllBrand() {
		// TODO Auto-generated method stub
		return brandDao.getAllBrand();
	}

}
