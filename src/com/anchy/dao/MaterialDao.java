package com.anchy.dao;

import java.util.List;

import com.anchy.po.Material;

public interface MaterialDao {
	public List<Material> getMaterialByKeyword(String keyword1);
	public List<Material> getAllMaterial();
}
