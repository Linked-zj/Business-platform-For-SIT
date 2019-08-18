package com._520it.o2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com._520it.o2o.entity.Shop;

public interface ShopDao {

	List<Shop> queryShopList(@Param("shopCondition") Shop shopCondition, @Param("rowIndex") int rowIndex,
			@Param("pageSize") int pageSize);
	
	int queryShopCount(@Param("shopCondition") Shop shopCondition);

	/**
	 * 
	 * @param shopId
	 * @return
	 */
	Shop queryShopById(Long shopId);

	/**
	 * 插入商店
	 * 
	 * @param shop
	 * @return
	 */
	int insertShop(Shop shop);

	/**
	 * 更新商店
	 * 
	 * @param shop
	 * @return
	 */
	int updateShop(Shop shop);
}
