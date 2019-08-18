package com._520it.o2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com._520it.o2o.entity.HeadLine;

public interface HeadLineDao {
	
	List<HeadLine>queryHeadLine(@Param("headLineCondition")HeadLine headLineCondition);
	
}
