package com.def.account.dao;

import org.springframework.stereotype.Component;

import com.def.account.entity.Account;

@Component
public class AccountDaoImpl implements AccountDao {
	
	
	
	public Account createAnAccount(Account account) {
		
		return new Account();
	}

}
