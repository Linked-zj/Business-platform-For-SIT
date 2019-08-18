package com._520it.o2o.web.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/frontend")
public class FrontendController {

	@RequestMapping(value="/index",method=RequestMethod.GET)
	private String index() {
		return "frontend/index";
	}
	
	@RequestMapping(value="/shoplist",method=RequestMethod.GET)
	private String showShopList() {
		return "frontend/shoplist";
	}
	
	@RequestMapping(value="/shopdetail",method=RequestMethod.GET)
	private String showShopDetail() {
		return "/frontend/shopdetail";
	}
	
	@RequestMapping(value="/productdetail",method=RequestMethod.GET)
	private String showProductDetail() {
		return "/frontend/productdetail";
	}
}
