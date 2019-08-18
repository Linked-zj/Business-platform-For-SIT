package com._520it.o2o.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import com._520it.o2o.BaseTest;
import com._520it.o2o.entity.ProductCategory;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductCategoryDaoTest extends BaseTest{

	@Autowired
	private ProductCategoryDao productCategoryDao;
	
	@Test
	public void testAbatchInsertProductCategory() throws Exception {
		ProductCategory productCategory=new ProductCategory();
		productCategory.setProductCategoryName("商品类别4");
		productCategory.setPriority(8);
		productCategory.setCreateTime(new Date());
		productCategory.setShopId(1L);
		ProductCategory productCategory1=new ProductCategory();
		productCategory1.setProductCategoryName("商品类别5");
		productCategory1.setPriority(7);
		productCategory1.setCreateTime(new Date());
		productCategory1.setShopId(1L);
		List<ProductCategory>list=new ArrayList<ProductCategory>();	
		list.add(productCategory);
		list.add(productCategory1);
		
		int effectedNum=productCategoryDao.batchInsertProductCategory(list);
		assertEquals(2, effectedNum);
	}
	
	@Test
	public void testBqueryProductCategoryList() throws Exception {
		
		List<ProductCategory>productCategoryList=productCategoryDao.queryProductCategoryList(1L);
		System.out.println("商品类别个数:"+productCategoryList.size());
	}
	
	@Test
	public void testCDeleteProductCategory() throws Exception {
		Long shopId=1L;
		List<ProductCategory>productCategoryList=productCategoryDao.queryProductCategoryList(shopId);
		for (ProductCategory pc : productCategoryList) {
			if("商品类别4".equals(pc.getProductCategoryName()) || "商品类别5".equals(pc.getProductCategoryName())) {
				int effectedNum=productCategoryDao.deleteProductCategory(pc.getProductCategoryId(), shopId);
				assertEquals(1, effectedNum);
			}
		}
	}
	
}
