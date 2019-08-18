package com._520it.o2o.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com._520it.o2o.BaseTest;
import com._520it.o2o.entity.Area;


public class AreaServiceTest extends BaseTest{
	
	@Autowired
	private AreaService areaService;
	
	@Test
	public void testGetAreaList() throws Exception {
		List<Area>areaList=areaService.getAreaList();
		assertEquals("西苑", areaList.get(0).getAreaName());
	}

}
