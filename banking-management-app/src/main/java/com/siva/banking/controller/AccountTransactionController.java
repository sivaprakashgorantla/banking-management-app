package com.siva.banking.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siva.banking.dto.AccountDTO;
import com.siva.banking.dto.AccountTransactionDTO;
import com.siva.banking.service.AccountService;
import com.siva.banking.service.AccountTransactionService;

@RestController
@RequestMapping("/transaction/api/")
public class AccountTransactionController {

	@Autowired
	private AccountTransactionService accountTransactionService;

	@RequestMapping("all")
	public ResponseEntity<List<AccountTransactionDTO>> allAccountTransactions() {
		return new ResponseEntity<>(accountTransactionService.getAllAccountTransactions(), HttpStatus.OK);
	}

	@RequestMapping("/account/{id}")
	public ResponseEntity<List<AccountTransactionDTO>> getAccountById(@PathVariable Long id) {
		return new ResponseEntity<>(accountTransactionService.getAccountTransactionByAccountId(id), HttpStatus.OK);
	}

	
	

}
