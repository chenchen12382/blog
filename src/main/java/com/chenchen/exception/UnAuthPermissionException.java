package com.chenchen.exception;

@SuppressWarnings("serial")
public class UnAuthPermissionException extends RuntimeException {
	
	private String permissionCode;
	
	public UnAuthPermissionException() {
	}

	public UnAuthPermissionException(String message) {
		super(message);
	}
	public UnAuthPermissionException(String permissionCode, String message) {
		super(message);
		this.permissionCode = permissionCode;
	}

	public String getPermissionCode() {
		return permissionCode;
	}

	public void setPermissionCode(String permissionCode) {
		this.permissionCode = permissionCode;
	}
}
