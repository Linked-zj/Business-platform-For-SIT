package com._520it.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com._520it.o2o.BaseTest;
import com._520it.o2o.entity.HeadLine;

public class HeadLineDaoTest extends BaseTest{
	@Autowired
	private HeadLineDao headLineDao;
	
	@Test
	public void testQueryHeadLine() throws Exception {
		
		List<HeadLine>HeadLineList=headLineDao.queryHeadLine(new HeadLine());
		assertEquals(0, HeadLineList.size());
	}
}
