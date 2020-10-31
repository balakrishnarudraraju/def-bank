package com.def.account.service;

import java.util.List;

import com.def.account.dto.input.AccountCreateRequestType;
import com.def.account.entity.Account;

public interface AccountService {
	
	public Account createAccount(AccountCreateRequestType account);
	
	public Account getAccount(Long accountNumber);

	public List<Account> listAccounts();
	
	public List<Account> listAccountsByCustomerId(String customerId);
}
