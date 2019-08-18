package com._520it.o2o.service;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com._520it.o2o.BaseTest;
import com._520it.o2o.dto.ImageHolder;
import com._520it.o2o.dto.ProductExecution;
import com._520it.o2o.entity.Product;
import com._520it.o2o.entity.ProductCategory;
import com._520it.o2o.entity.Shop;
import com._520it.o2o.enums.ProductStateEnum;

public class ProductServiceTest extends BaseTest{

	
	@Autowired
	private ProductService productService;
	
	@Test
	public void testaddProduct() throws Exception {
		Product product=new Product();
		Shop shop=new Shop();
		shop.setShopId(1L);
		ProductCategory pc=new ProductCategory();
		pc.setProductCategoryId(1L);
		product.setShop(shop);
		product.setProductCategory(pc);
		product.setProductName("测试商品1");
		product.setProductDesc("这是测试");
		product.setPriority(20);
		product.setCreateTime(new Date());
		product.setEnableStatus(ProductStateEnum.SUCCESS.getState());
		//创建缩略图文件流
		File thumbnailFile=new File("F:/images/view.png");
		InputStream is=new FileInputStream(thumbnailFile);
		ImageHolder thumbnail=new ImageHolder(thumbnailFile.getName(),is);
		//创建两个商品详情图文件流并将它们添加到详情图列表中
		File productImg1=new File("F:/images/view.png");
		InputStream is1=new FileInputStream(productImg1);
		File productImg2=new File("F:/images/time.png");
		InputStream is2=new FileInputStream(productImg1);
		List<ImageHolder> productImgList=new ArrayList<ImageHolder>();
		productImgList.add(new ImageHolder(productImg1.getName(),is1));
		productImgList.add(new ImageHolder(productImg2.getName(),is2));
		ProductExecution pe=productService.addProduct(product, thumbnail, productImgList);
		assertEquals(ProductStateEnum.SUCCESS.getState(), pe.getState());
	}
	
	@Test
	public void testModifyProduct() throws Exception {
		Product product=new Product();
		Shop shop=new Shop();
		ProductCategory pc=new ProductCategory();
		shop.setShopId(1L);
		pc.setProductCategoryId(1L);
		product.setProductId(1L);
		product.setProductCategory(pc);
		product.setShop(shop);
		product.setProductName("正式的商品");
		product.setProductDesc("正式的商品");
		//创建缩略图文件流
		File thumbnailFile=new File("F:/images/search.png");
		InputStream is=new FileInputStream(thumbnailFile);
		ImageHolder thumbnail=new ImageHolder(thumbnailFile.getName(), is);
		//创建两个商品详情图文件并将它们添加到商品详情图列表中
		File thumbnailFile1=new File("F:/images/1.png");
		InputStream is1=new FileInputStream(thumbnailFile1);
		File thumbnailFile2=new File("F:/images/time.png");
		InputStream is2=new FileInputStream(thumbnailFile2);
		List<ImageHolder>productImgList=new ArrayList<ImageHolder>();
		productImgList.add(new ImageHolder(thumbnailFile1.getName(), is1));
		productImgList.add(new ImageHolder(thumbnailFile2.getName(), is2));
		ProductExecution pe=productService.modifyProduct(product, thumbnail, productImgList);
		assertEquals(ProductStateEnum.SUCCESS.getState(),pe.getState());
		
		
	}
}
