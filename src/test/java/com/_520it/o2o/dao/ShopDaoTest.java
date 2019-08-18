package com._520it.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com._520it.o2o.BaseTest;
import com._520it.o2o.entity.Area;
import com._520it.o2o.entity.PersonInfo;
import com._520it.o2o.entity.Shop;
import com._520it.o2o.entity.ShopCategory;

public class ShopDaoTest extends BaseTest{
	@Autowired
	private ShopDao shopDao;
	
	@Test
	public void testqueryShopList() throws Exception {
		Shop shopCondition=new Shop();
		ShopCategory parentCategory=new ShopCategory();
		ShopCategory childCategory=new ShopCategory();
		parentCategory.setShopCategoryId(5L);
		childCategory.setParent(parentCategory);
		shopCondition.setShopCategory(childCategory);
		List<Shop>shopList=shopDao.queryShopList(shopCondition, 0, 6);
		System.out.println("店铺列表的大小:" + shopList.size());
		int count=shopDao.queryShopCount(shopCondition);
		System.out.println("店铺总数为:" + count);
	
	}
	
	@Test
	public void testqueryShopById() throws Exception {
		Long shopId=1L;
		Shop shop=shopDao.queryShopById(shopId);
		System.out.println(shop.getArea().getAreaId());
		System.out.println(shop.getArea().getAreaName());
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
		shop.setShopName("测试的店铺");
		shop.setShopDesc("test");
		shop.setShopAddr("test");
		shop.setPhone("test");
		shop.setShopImg("test");
		shop.setCreateTime(new Date());
		shop.setEnableStatus(1);
		shop.setAdvice("审核中");
		int effectedNum=shopDao.insertShop(shop);
		assertEquals(1,effectedNum);
	}
	@Test
	public void testUpdateShop() throws Exception {
		Shop shop=new Shop();
		shop.setShopId(1L);
		shop.setShopDesc("测试描述");
		shop.setShopAddr("测试地址");
		shop.setLastEditTime(new Date());
		int effectedNum=shopDao.updateShop(shop);
		assertEquals(1,effectedNum);
	}
}
