package com.chenchen.exception;

@SuppressWarnings("serial")
public class ParamException extends RuntimeException {
	
	private int errorCode;
	
	public ParamException() {
	}

	public ParamException(String message) {
		super(message);
	}
	
	public ParamException(int errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	
	
	
	

}
