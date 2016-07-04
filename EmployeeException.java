package com.springmvcexample.util;

public class EmployeeException extends RuntimeException {

	private static final long serialVersionUID = 4778623401821686014L;

	private String exceptionMsg;
	
	public EmployeeException(String exceptionMsg){
		this.exceptionMsg=exceptionMsg;
	}

	public String getExceptionMsg() {
		return exceptionMsg;
	}

	public void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}
}
