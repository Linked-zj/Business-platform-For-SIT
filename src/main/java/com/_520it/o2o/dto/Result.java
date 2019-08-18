package com._520it.o2o.dto;


/**
 * 封装所有json对象,所有返回结果都用它
 *
 * @param <T>
 */
public class Result<T> {

	private boolean success;
	
	private T data;
	
	private String errMsg;
	
	private int errCode;
	
	public Result() {
		
	}
	
	public Result(boolean success,T data) {
		this.success=success;
		this.data=data;
		
	}
	
	public Result(boolean success,int errCode,String errMsg) {
		this.success=success;
		this.errMsg=errMsg;
		this.errCode=errCode;
		
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public int getErrCode() {
		return errCode;
	}

	public void setErrCode(int errCode) {
		this.errCode = errCode;
	}
	
	
}
