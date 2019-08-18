package com._520it.o2o.dao;

import java.util.List;

import com._520it.o2o.entity.ProductImg;

public interface ProductImgDao {

	/**
	 * 批量添加商品图片
	 * @param productList
	 * @return
	 */
	int batchInsertProductImg(List<ProductImg>productImgList);
	
	int deleteProductImgByProductId(Long productId);
	
	List<ProductImg>queryProductImgList(Long productId);
}
