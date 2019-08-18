package com._520it.o2o.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.o2o.dao.HeadLineDao;
import com._520it.o2o.entity.HeadLine;

@Service
public class HeadLineServiceImpl implements HeadLineService{
	
	@Autowired
	private HeadLineDao headLineDao;
	@Override
	public List<HeadLine> getHeadLineList(HeadLine headLineCondition) throws IOException {
		
		return headLineDao.queryHeadLine(headLineCondition);
	}

	
	
}
