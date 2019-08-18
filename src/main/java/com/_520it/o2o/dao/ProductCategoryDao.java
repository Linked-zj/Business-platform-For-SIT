package com._520it.o2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com._520it.o2o.entity.ProductCategory;

public interface ProductCategoryDao {
	/**
	 * 通过shopId 查询该店铺下所有商品类别
	 * @param shopId
	 * @return
	 */
	List<ProductCategory>queryProductCategoryList(Long shopId);
	
	
	int batchInsertProductCategory(List<ProductCategory>productCategoryList);
	
	int deleteProductCategory(@Param("productCategoryId")Long productCategoryId,@Param("shopId")Long shopId);
}
