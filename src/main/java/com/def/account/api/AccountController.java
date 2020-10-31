/**
 * 
 */
package com.def.account.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.def.account.dto.input.AccountCreateRequestType;
import com.def.account.dto.output.AccountCreateResponseType;
import com.def.account.entity.Account;
import com.def.account.service.AccountService;

/**
 * Enables the mapping for restful urls to application services mapping. Deals with account maintenance activities such as 'open an account', 'credit amount', 'debit amount' etc.
 * 
 * @author Balakrishna Rudraraju
 *
 */
@RestController
@RequestMapping("/api/v1.0/accounts")
public class AccountController {	
	
	@Autowired
	private AccountService accountService;
		
	@PostMapping("")
	public HttpEntity<AccountCreateResponseType> createAccount(@RequestBody @Valid AccountCreateRequestType account) {		
		
		Account accountPersisted = accountService.createAccount(account);
				
		AccountCreateResponseType accountCreateResponse =  new AccountCreateResponseType();
		
		accountCreateResponse.setBalance(accountPersisted.getBalance());
		accountCreateResponse.setCurrency(accountPersisted.getCurrency());
		accountCreateResponse.setCustomerId(accountPersisted.getCustomerId());
		accountCreateResponse.setNumber(accountPersisted.getNumber());
		accountCreateResponse.setStatus(accountPersisted.getStatus());
		accountCreateResponse.setType(accountPersisted.getType());
						
		return new ResponseEntity<>(accountCreateResponse, HttpStatus.CREATED);
	}
	
	@GetMapping("")
	public List<Account> listAccounts() {			
		return accountService.listAccounts();		
	}
	
	@GetMapping("/{accountNumber}")
	public Account getAccountDetails(@PathVariable Long accountNumber) {		
		return accountService.getAccount(accountNumber);		
	}
	
	@GetMapping("/customer/{customerId}")
	public List<Account> listAccountsByCustomerId(@PathVariable String customerId) {			
		return accountService.listAccountsByCustomerId(customerId);		
	}
	
	
}
