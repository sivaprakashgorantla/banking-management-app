package com.siva.banking.service;

import java.util.List;

import com.siva.banking.dto.AccountTransactionDTO;

public interface AccountTransactionService {

	List<AccountTransactionDTO> getAccountTransactionByAccountId(Long id);

	List<AccountTransactionDTO> getAllAccountTransactions();

}
