package com._520it.o2o.service;

import java.util.List;

import com._520it.o2o.entity.ShopCategory;

public interface ShopCategoryService {
	
	/**
	 * 根据查询条件获取ShopCategory列表
	 * @param shopCategoryCondition
	 * @return
	 */
	List<ShopCategory>getShopCategoryList(ShopCategory shopCategoryCondition);
	
}
