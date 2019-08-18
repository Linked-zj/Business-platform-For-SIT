package com._520it.o2o.entity;

import java.util.Date;

/**
 * 本地验证实体类,主要用来做账号密码的登录
 * @author 林帅帅
 *
 */
public class LocalAuth {
	private Long localAuthId;
	private Long uesrname;
	private String password;
	private Date createTime;
	private Date lastEditTime;
	private PersonInfo personInfo;
	public Long getLocalAuthId() {
		return localAuthId;
	}
	public void setLocalAuthId(Long localAuthId) {
		this.localAuthId = localAuthId;
	}
	public Long getUesrname() {
		return uesrname;
	}
	public void setUesrname(Long uesrname) {
		this.uesrname = uesrname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getLastEditTime() {
		return lastEditTime;
	}
	public void setLastEditTime(Date lastEditTime) {
		this.lastEditTime = lastEditTime;
	}
	public PersonInfo getPersonInfo() {
		return personInfo;
	}
	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}
}
