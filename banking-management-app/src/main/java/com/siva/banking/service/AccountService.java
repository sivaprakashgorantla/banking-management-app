package com.siva.banking.service;

import java.util.List;

import com.siva.banking.dto.AccountDTO;

public interface AccountService {

	AccountDTO createAccount(AccountDTO accountDTO);
	
	AccountDTO getAccountById(Long id);
	
	List<AccountDTO> getAllAccounts();
	
	AccountDTO deposit(Long id, double amount);

	AccountDTO withdraw(Long id, double amount);
	
	void deleteAccount(Long id);
	
}
