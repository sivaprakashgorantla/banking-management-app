package com.siva.banking.loader;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.siva.banking.entity.Account;
import com.siva.banking.entity.AccountTransaction;
import com.siva.banking.entity.AccountType;
import com.siva.banking.entity.TransactionType;
import com.siva.banking.repository.AccountRepository;
import com.siva.banking.repository.AccountTransactionRepository;
import com.siva.banking.repository.AccountTypeRepository;

@Component
public class AccountRunner implements CommandLineRunner {

	private static String SAVINGS = "SAVINGS";
	private static String CURRENT = "CURRENT";
	
	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private AccountTypeRepository accountTypeRepository ;

	@Autowired
	private AccountTransactionRepository accountTransactionRepository;

	
	@Override
	public void run(String... args) throws Exception {

		System.out.println("Account Loadeder...........................");

		List<AccountType> accountTypeList = Arrays.asList(new AccountType(CURRENT), new AccountType(SAVINGS));

		accountTypeRepository.saveAll(accountTypeList);
		
		List<AccountType> fetchAccountType = accountTypeRepository.findAll();

		// TODO Auto-generated method stub
		List<Account> listAccounts = Arrays.asList(
				new Account(91230001L, "abc", 123456.78,fetchAccountType.get(1)),
				new Account(91230002L, "abc1", 123456.78,fetchAccountType.get(0)),
				new Account(91230003L, "abc2", 123456.78,fetchAccountType.get(1)),
				new Account(91230004L, "abc3", 123456.78,fetchAccountType.get(0)),
				new Account(91239005L, "abc4", 123456.78,fetchAccountType.get(1)),
				new Account(91230006L, "abc5", 123456.78,fetchAccountType.get(0)), 
				new Account(91230007L, "abc6", 123456.78,fetchAccountType.get(1)));
		accountRepository.saveAll(listAccounts);
		
		// Assume you have a TransactionType enum with values like DEPOSIT, WITHDRAWAL, etc.
		System.out.println("Account : "+accountRepository.findAll().get(0));
		Account accountDb = accountRepository.findAll().get(0);
		List<AccountTransaction> accountTransactions = Arrays.asList(
		    new AccountTransaction(987456321L, accountDb, TransactionType.DEPOSIT, 505554.00, LocalDateTime.now()),
		    new AccountTransaction(987456322L, accountDb, TransactionType.WITHDRAWAL, 505554.00, LocalDateTime.now())
		);

		accountTransactionRepository.saveAll(accountTransactions);

	}

}
