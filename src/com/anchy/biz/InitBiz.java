package com.anchy.biz;

import java.util.List;
import java.util.Map;

import com.anchy.po.Classify;

public interface InitBiz {
	//显示三级分类
	public Map<String, Map<String,List<String>>> getClassify();
}
