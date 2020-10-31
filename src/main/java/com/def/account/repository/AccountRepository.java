package com.def.account.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.def.account.entity.Account;


public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {

	List<Account> findByCustomerId(String customerId);

}