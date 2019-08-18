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
import com._520it.o2o.entity.Product;
import com._520it.o2o.entity.ProductCategory;
import com._520it.o2o.entity.ProductImg;
import com._520it.o2o.entity.Shop;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductDaoTest extends BaseTest{

	@Autowired
	private ProductDao productDao;
	@Autowired
	private ProductImgDao productImgDao;
	
	@Test
	public void testAInsertProduct() throws Exception {
		Shop shop=new Shop();
		shop.setShopId(1L);
		ProductCategory productCategory=new ProductCategory();
		productCategory.setProductCategoryId(1L);
		
		Product product=new Product();
		product.setProductName("测试1");
		product.setCreateTime(new Date());
		product.setEnableStatus(1);
		product.setImgAddr("test1");
		product.setProductDesc("这是测试1");
		product.setLastEditTime(new Date());
		product.setPriority(2);
		product.setShop(shop);
		product.setProductCategory(productCategory);
		
		int effectedNum=productDao.insertProduct(product);
		assertEquals(1, effectedNum);
	}
	
	@Test
	public void testBQueryProductById() throws Exception {
		Long productId=1L;
		ProductImg productImg1=new ProductImg();
		productImg1.setImgAddr("图片1");
		productImg1.setImgDesc("测试图片2");
		productImg1.setPriority(1);
		productImg1.setCreateTime(new Date());
		productImg1.setProductId(productId);
		
		ProductImg productImg2=new ProductImg();
		productImg2.setImgAddr("图片2");
		productImg2.setImgAddr("测试图片2");
		productImg2.setPriority(2);
		productImg2.setCreateTime(new Date());
		productImg2.setProductId(productId);
		List<ProductImg>productImgList=new ArrayList<ProductImg>();
		productImgList.add(productImg1);
		productImgList.add(productImg2);
		int effectedNum=productImgDao.batchInsertProductImg(productImgList);
		assertEquals(2,effectedNum);
		Product product=productDao.queryProductById(productId);
		assertEquals(2,product.getProductImgList().size());
		effectedNum=productImgDao.deleteProductImgByProductId(productId);
		assertEquals(2,effectedNum);
	}
	
	@Test
	public void testQueryProductList() throws Exception {
		Product productCondition=new Product();
		List<Product>productList=productDao.queryProductList(productCondition, 0, 2);
		assertEquals(2,productList.size());
		
		int count=productDao.queryProductCount(productCondition);
		assertEquals(8,count);
		
		productCondition.setProductName("美");
		productList=productDao.queryProductList(productCondition, 0, 3);
		assertEquals(1,productList.size());
	}
	
	@Test
	public void testUpdateproduct() throws Exception {
		Product product=new Product();
		Shop shop=new Shop();
		ProductCategory pc=new ProductCategory();
		shop.setShopId(1L);
		pc.setProductCategoryId(2L);
		product.setProductId(1L);
		product.setShop(shop);
		product.setProductName("第一个产品");
		product.setProductCategory(pc);
		int effectedNum=productDao.updateProduct(product);
		assertEquals(1,effectedNum);
		
	}
	
	@Test
	public void testUpdateProductCategoryToNull() throws Exception {
		int effectedNum=productDao.updateProductCategoryToNull(6L);
		assertEquals(1,effectedNum);
	}
	
}
