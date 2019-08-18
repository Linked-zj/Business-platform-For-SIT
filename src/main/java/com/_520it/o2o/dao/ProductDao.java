package com._520it.o2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com._520it.o2o.entity.Product;

public interface ProductDao {

	int insertProduct(Product product);

	Product queryProductById(Long productId);

	int updateProduct(Product product);
	
	/**
	 * 查询商品列表并分页,可输入的状态有:商品名(店铺id),商品状态,店铺id,商品类名
	 * @param productCondition
	 * @param rowIndex
	 * @param pageSize
	 * @return
	 */
	List<Product> queryProductList(@Param("productCondition") Product productCondition, @Param("rowIndex") int rowIndex,
			@Param("pageSize") int pageSize);
	
	/**
	 * 查询对应的商品总数
	 * @param productCondition
	 * @return
	 */
	int queryProductCount(@Param("productCondition") Product productCondition);
	
	/**
	 * 在删除商品类别前,先将该类别下的所有商品类别id置为空
	 * @param productCategoryId
	 * @return
	 */
	int updateProductCategoryToNull(Long productCategoryId);
}
