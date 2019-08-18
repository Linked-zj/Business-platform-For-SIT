package com._520it.o2o.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com._520it.o2o.BaseTest;
import com._520it.o2o.dto.ImageHolder;
import com._520it.o2o.dto.ShopExecution;
import com._520it.o2o.entity.Area;
import com._520it.o2o.entity.PersonInfo;
import com._520it.o2o.entity.Shop;
import com._520it.o2o.entity.ShopCategory;
import com._520it.o2o.enums.ShopStateEnum;
import com._520it.o2o.exceptions.ShopOperationException;

public class ShopServiceTest extends BaseTest{
		@Autowired
		private ShopService shopService;
		
		
		@Test
		public void testGetSopList() throws Exception {
			Shop shopCondition=new Shop();
			ShopCategory shopCategory=new ShopCategory();
			shopCategory.setShopCategoryId(1l);
			shopCondition.setShopCategory(shopCategory);
			ShopExecution se=shopService.getShopList(shopCondition, 2, 3);
			System.out.println("店铺列表数:"+se.getShopList().size());
			System.out.println("店铺总数:" +se.getCount());
			
			
			
		}
		
		@Test
		public void testModify() throws ShopOperationException, FileNotFoundException {
			Shop shop=new Shop();
			shop.setShopId(1L);
			shop.setShopName("测试的店铺");
			File shopImg=new File("F:/images/time.png");
			InputStream is=new FileInputStream(shopImg);
			ImageHolder imageHolder=new ImageHolder("time.png",is);
			ShopExecution shopExecution=shopService.modifyShop(shop, imageHolder);
			System.out.println("新图片地址为:" +shopExecution.getShop().getShopImg());
		}
		
		@Test
		public void testInsertShop() throws Exception {
			Shop shop=new Shop();
			PersonInfo owner=new PersonInfo();
			Area area=new Area();
			ShopCategory shopCategory=new ShopCategory();
			owner.setUserId(1L);
			area.setAreaId(2);
			shopCategory.setShopCategoryId(1L);
			shop.setOwner(owner);
			shop.setArea(area);
			shop.setShopCategory(shopCategory);
			shop.setShopName("测试的店铺3");
			shop.setShopDesc("test3");
			shop.setShopAddr("test3");
			shop.setPhone("test3");
			shop.setCreateTime(new Date());
			shop.setEnableStatus(ShopStateEnum.CHECK.getState());
			shop.setAdvice("审核中");
			File shopImg=new File("F:/images/view.png");
			InputStream is=new FileInputStream(shopImg);
			ImageHolder imageHolder=new ImageHolder(shopImg.getName(),is);
			ShopExecution se=shopService.addShop(shop,imageHolder);
			assertEquals(ShopStateEnum.CHECK.getState(), se.getState());
		}
}
