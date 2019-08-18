package com._520it.o2o.service;

import java.util.List;

import com._520it.o2o.dto.ProductCategoryExecution;
import com._520it.o2o.entity.ProductCategory;
import com._520it.o2o.exceptions.ProductCategoryOperationException;

public interface ProductCategoryService {
	
	List<ProductCategory>getProductCategoryList(Long shopId);
	
	
	ProductCategoryExecution batchAddProductCategory(List<ProductCategory>productCategoryList)throws ProductCategoryOperationException;
	
	ProductCategoryExecution deleteProductCategory(Long productCategoryId,Long shopId) throws ProductCategoryOperationException;
}
