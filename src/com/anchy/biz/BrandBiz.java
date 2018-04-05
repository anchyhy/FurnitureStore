package com.anchy.biz;

import java.util.List;

import com.anchy.po.Brand;

public interface BrandBiz {
	public List<Brand> getByKeyword(String keyword);
	public List<Brand> getAllBrand();

}
