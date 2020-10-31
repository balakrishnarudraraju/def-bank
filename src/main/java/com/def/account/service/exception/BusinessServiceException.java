package com.def.account.service.exception;

public class BusinessServiceException extends RuntimeException {
		
	private static final long serialVersionUID = 1L;
	private int code;
	private String message;
	
	BusinessServiceException(int code, String message){
		this.code = code;
		this.message = message;
	}
	
}
