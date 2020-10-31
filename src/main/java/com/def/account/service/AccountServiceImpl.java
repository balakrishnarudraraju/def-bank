/**
 * 
 */
package com.def.account.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.def.account.dto.input.AccountCreateRequestType;
import com.def.account.entity.Account;
import com.def.account.repository.AccountRepository;
import com.def.account.service.exception.AccountOpeningExceptionCustomerDoesnotExist;
import com.def.account.service.exception.BusinessServiceException;

/**
 * @author Balakrishna Rudraraj
 *
 */
@Service
public class AccountServiceImpl implements AccountService {

	
	@Autowired
	private AccountRepository accountRepo;
	
	public Account createAccount(AccountCreateRequestType accountCreateRequestDTO) throws BusinessServiceException {
		
		if(accountCreateRequestDTO.getCustomerId().equalsIgnoreCase("1234")) {
				Account account = new Account();
				account.setBalance(BigDecimal.ZERO); //initial value as zero
				account.setCurrency(accountCreateRequestDTO.getCurrency());
				account.setCustomerId(accountCreateRequestDTO.getCustomerId());
				account.setStatus('A'); //active
				account.setType("S"); //savings account
				return accountRepo.save(account);	
		}else {
			throw new AccountOpeningExceptionCustomerDoesnotExist("AccountOpeningFailedDueToCustomerDoesNotExist");
		}			
	}
	
	public Account getAccount(Long accountNumber) {
		return accountRepo.findById(accountNumber).orElseThrow(EntityNotFoundException::new);
	}
	
	public List<Account> listAccounts(){
		List<Account> accounts = new ArrayList<Account>();

		accountRepo.findAll().forEach(accounts::add);
		
		return accounts; 
	}
	
	public List<Account> listAccountsByCustomerId(String customerId){
		return accountRepo.findByCustomerId(customerId);
	}
	
}
