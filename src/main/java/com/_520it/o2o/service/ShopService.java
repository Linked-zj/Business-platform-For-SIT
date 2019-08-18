package com._520it.o2o.service;


import com._520it.o2o.dto.ImageHolder;
import com._520it.o2o.dto.ShopExecution;
import com._520it.o2o.entity.Shop;
import com._520it.o2o.exceptions.ShopOperationException;

public interface ShopService {
	
	
	
	public ShopExecution getShopList(Shop shopCondition,int pageIndex,int pageSize);
	/**
	 * 通过店铺id获取店铺信息
	 * @param shopId
	 * @return
	 */
	Shop getByShopId(long shopId);
	
	/**
	 * 更新店铺信息,包括图片处理
	 * @param shop
	 * @param shopImgInputStream
	 * @param fileName
	 * @return
	 */
	ShopExecution modifyShop(Shop shop,ImageHolder thumbnail) throws ShopOperationException;
	
	
	
	/**
	 * 注册店铺信息,包括图片处理
	 * @param shop
	 * @param shopImgInputStream
	 * @param fileName
	 * @return
	 */
	ShopExecution addShop(Shop shop,ImageHolder thumbnail)throws ShopOperationException;
}
