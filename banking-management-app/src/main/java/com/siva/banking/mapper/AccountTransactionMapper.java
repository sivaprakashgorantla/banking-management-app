package com.siva.banking.mapper;

import org.springframework.stereotype.Component;

import com.siva.banking.dto.AccountDTO;
import com.siva.banking.dto.AccountTransactionDTO;
import com.siva.banking.entity.Account;
import com.siva.banking.entity.AccountTransaction;
@Component
public class AccountTransactionMapper {

	public static AccountTransactionDTO mapToAccountTransaction(AccountTransactionDTO accountTransactionDTO) {
		Account account = new Account(accountTransactionDTO.getAccountDTO().getAccountId(),accountTransactionDTO.getAccountDTO().getName());
		
		AccountTransaction accountTransaction = new AccountTransaction(
				accountTransactionDTO.getTransactionId(),
				account,
				accountTransactionDTO.getTransactionType(),
				accountTransactionDTO.getAmount(),
				accountTransactionDTO.getTransactionDate());
		
		return accountTransactionDTO;
	}
	
	public static AccountTransactionDTO mapToAccountTransactionDto(AccountTransaction accountTransaction) {
		
		AccountDTO accountDTO = new AccountDTO(accountTransaction.getAccount().getAccountId(),accountTransaction.getAccount().getName(),0, accountTransaction.getAccount().getAccountType());
		AccountTransactionDTO accountTransactionDTO = new AccountTransactionDTO(
				accountTransaction.getTransactionId(),
				accountDTO,
				accountTransaction.getTransactionType(),
				accountTransaction.getAmount(),
				accountTransaction.getTransactionDate());
		return accountTransactionDTO;
	}
}
