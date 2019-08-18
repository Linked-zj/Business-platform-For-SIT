package com._520it.o2o.service;

import java.util.List;

import com._520it.o2o.dto.ImageHolder;
import com._520it.o2o.dto.ProductExecution;
import com._520it.o2o.entity.Product;
import com._520it.o2o.exceptions.ProductOperationException;

public interface ProductService {

	ProductExecution addProduct(Product product, ImageHolder thumbnail, List<ImageHolder> productImgList)
			throws ProductOperationException;

	Product getProductById(Long productId);

	ProductExecution modifyProduct(Product product, ImageHolder thumbnail, List<ImageHolder>  productImgHolderList)
			throws ProductOperationException;
	
	ProductExecution getProductList(Product productCondition,int pageIndex,int pageSize);

}
