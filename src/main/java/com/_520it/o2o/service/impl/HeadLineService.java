package com._520it.o2o.service.impl;

import java.io.IOException;
import java.util.List;

import com._520it.o2o.entity.HeadLine;

public interface HeadLineService {

	
	List<HeadLine>getHeadLineList(HeadLine headLineCondition) throws IOException;
}
