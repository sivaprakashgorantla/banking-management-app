package com.siva.banking.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siva.banking.dto.AccountDTO;
import com.siva.banking.dto.AccountTransactionDTO;
import com.siva.banking.dto.AccountTypeDTO;
import com.siva.banking.entity.Account;
import com.siva.banking.entity.AccountTransaction;
import com.siva.banking.entity.AccountType;
import com.siva.banking.exception.AccountGlobalException;
import com.siva.banking.mapper.AccountMapper;
import com.siva.banking.mapper.AccountTransactionMapper;
import com.siva.banking.mapper.AccountTypeMapper;
import com.siva.banking.repository.AccountTransactionRepository;
import com.siva.banking.repository.AccountTypeRepository;

@Service
public class AccountTransactionServiceImpl implements AccountTransactionService {

	@Autowired
	private AccountTransactionRepository accountTransactionRepository;

	@Override
	public List<AccountTransactionDTO> getAccountTransactionByAccountId(Long id) {
		// TODO Auto-generated method stub
//The method orElseThrow(() -> {}) is undefined for the type List<AccountTransaction>
		List<AccountTransaction> accountTransactions =  accountTransactionRepository.findByAccount_AccountId(id);
				if (accountTransactions == null ) {
					new AccountGlobalException("Account does not exists");
				}
				/*
				 * AccountTransactionDTO accountTransactionDTO = AccountTransactionMapper
				 * .mapToAccountTransactionDto(accountTransactions);
				 */
		return accountTransactions.stream()
	            .map(AccountTransactionMapper::mapToAccountTransactionDto) // Maps each transaction to its DTO
	            .collect(Collectors.toList()); // Collects the results into a list;
	}

	@Override
	public List<AccountTransactionDTO> getAllAccountTransactions() {
		// TODO Auto-generated method stub
		List<AccountTransaction> accountTransactions = accountTransactionRepository.findAll();
		return accountTransactions.stream().map(AccountTransactionMapper::mapToAccountTransactionDto)
				.collect(Collectors.toList());
	}

}
