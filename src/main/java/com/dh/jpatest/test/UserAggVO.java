package com.dh.jpatest.test;

import pub.sort;

public class UserAggVO {

	@sort(value = "1")
	private String userName;
	@sort(value = "2")
	private String orderName;
	@sort(value = "3")
	private String testName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	@Override
	public String toString() {
		return "UserAggVO [userName=" + userName + ", orderName=" + orderName + ", testName=" + testName + "]";
	}
	
	

}
