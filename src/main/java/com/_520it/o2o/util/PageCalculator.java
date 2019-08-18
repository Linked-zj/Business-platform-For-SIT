package com._520it.o2o.util;

public class PageCalculator {
	public static int calcultorRowPage(int pageIndex,int pageSize) {
		
		return (pageIndex>0)?(pageIndex-1)*pageSize:0;
	}
}
