package com.def.account.service.exception;

public class AccountOpeningExceptionCustomerDoesnotExist extends BusinessServiceException {

	public AccountOpeningExceptionCustomerDoesnotExist(String message){
		super(123, message);		
	}
}
