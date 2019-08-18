package com._520it.o2o.util;

import javax.servlet.http.HttpServletRequest;

public class CodeUtil {
	
	public static boolean checkVerifyCode(HttpServletRequest request) {
		String verifyCodeExcepted=(String) request.getSession().getAttribute(
				com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY
				);
		String verifyCodeActual=HttpServletRequestUtil.getString(request, "verifyCodeActual");
		if(verifyCodeActual ==null || !verifyCodeActual.equals(verifyCodeExcepted)) {
			return false;
		}
		return true;
	}
}
