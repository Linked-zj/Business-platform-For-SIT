package com._520it.o2o.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com._520it.o2o.dao.ProductCategoryDao;
import com._520it.o2o.dao.ProductDao;
import com._520it.o2o.dto.ProductCategoryExecution;
import com._520it.o2o.entity.ProductCategory;
import com._520it.o2o.enums.ProductCategoryStateEnum;
import com._520it.o2o.exceptions.ProductCategoryOperationException;
import com._520it.o2o.service.ProductCategoryService;


@Service
public class ProductCategoryServiceImpl implements ProductCategoryService{
	
	@Autowired
	private ProductCategoryDao productCategoryDao;
	@Autowired
	private ProductDao productDao;
	
	@Override
	public List<ProductCategory> getProductCategoryList(Long shopId) {
		return productCategoryDao.queryProductCategoryList(shopId);
		
	}

	@Override
	@Transactional
	public ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList)
			throws ProductCategoryOperationException {
		if(productCategoryList !=null && productCategoryList.size()>0) {
			try {
			int effectedNum=productCategoryDao.batchInsertProductCategory(productCategoryList);
			if(effectedNum<=0) {
				throw new ProductCategoryOperationException("店铺创建失败");
			}else {
				return new ProductCategoryExecution(ProductCategoryStateEnum.SUCCESS);
			}
		}catch(Exception e) {
			throw new ProductCategoryOperationException("batchAddProductCategory error:" +e.getMessage());
		}
		
	}else {
		return new ProductCategoryExecution(ProductCategoryStateEnum.EMPTY_LIST);
		}
	}

	@Override
	public ProductCategoryExecution deleteProductCategory(Long productCategoryId, Long shopId)
			throws ProductCategoryOperationException {
		// TODO 将此商品类别下的商品的类别id置为空
		
		try {
			int effectedNum=productDao.updateProductCategoryToNull(productCategoryId);
			if(effectedNum < 0) {
				throw new RuntimeException("商品类别更新异常");
			}
		} catch (Exception e) {
			throw new RuntimeException("deleteProductCategory error" +e.getMessage());
		}
		try {
			int effectedNum=productCategoryDao.deleteProductCategory(productCategoryId, shopId);
			if(effectedNum<=0) {
				throw new ProductCategoryOperationException("商品类别删除失败");
			}else {
				return new ProductCategoryExecution(ProductCategoryStateEnum.SUCCESS);
			}
		} catch (Exception e) {
			throw new ProductCategoryOperationException("deleteProductCategory error:" + e.getMessage());
		}
		
	}

}
