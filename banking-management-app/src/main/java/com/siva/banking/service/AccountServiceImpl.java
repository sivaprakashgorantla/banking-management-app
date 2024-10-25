package com.siva.banking.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siva.banking.dto.AccountDTO;
import com.siva.banking.entity.Account;
import com.siva.banking.exception.AccountGlobalException;
import com.siva.banking.mapper.AccountMapper;
import com.siva.banking.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public AccountDTO createAccount(AccountDTO accountDTO) {
		// TODO Auto-generated method stub
		Account account = AccountMapper.mapToAccount(accountDTO);
		Account saveAccount =  accountRepository.save(account);
		AccountDTO SaveAccountDTO2 = AccountMapper.mapToAccountDto(saveAccount);
		return SaveAccountDTO2;
	}


	@Override
	public AccountDTO getAccountById(Long id) {
		// TODO Auto-generated method stub
		
		Account account  = accountRepository.findById(id).orElseThrow(() ->new AccountGlobalException("Account does not exists"));
		AccountDTO accountDTO =  AccountMapper.mapToAccountDto(account);
		return accountDTO;
	}


	@Override
	public List<AccountDTO> getAllAccounts() {
		// TODO Auto-generated method stub
		List<Account> listAccount = accountRepository.findAll();
		return listAccount.stream().map(AccountMapper::mapToAccountDto).collect(Collectors.toList());
	}

	
	@Override
	public AccountDTO deposit(Long id, double amount) {
		// TODO Auto-generated method stub
		
		Account account = accountRepository.findById(id).orElseThrow(() -> new AccountGlobalException("Account does not exists"));
		
		double total = account.getAmount()+amount;
		
		account.setAmount(total);
		
		Account savedAccount = accountRepository.save(account);
		
		AccountDTO accountDTO = AccountMapper.mapToAccountDto(savedAccount);
		return accountDTO;
	}


	@Override
	public AccountDTO withdraw(Long id, double amount) {
		// TODO Auto-generated method stub
		Account account = accountRepository.findById(id).orElseThrow(() -> new AccountGlobalException("Account does not exists"));

		if(account.getAmount() < amount) {
			throw new RuntimeException("Account Insuffeciant Amount");
		}
		
		double totalAmount = account.getAmount() - amount;
		account.setAmount(totalAmount);
		
		Account savedAccount = accountRepository.save(account);
		
		AccountDTO accountDTO = AccountMapper.mapToAccountDto(savedAccount);
		
		return accountDTO;
	}


	@Override
	public void deleteAccount(Long id) {
		// TODO Auto-generated method stub
		Account account = accountRepository.findById(id).orElseThrow(() -> new AccountGlobalException("Account does not exists"));

		accountRepository.delete(account);
		
	}


	

}
