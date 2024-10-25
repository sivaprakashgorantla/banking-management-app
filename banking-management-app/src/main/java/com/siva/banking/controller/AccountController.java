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
import com.siva.banking.service.AccountService;

@RestController
@RequestMapping("/banking/api/")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@RequestMapping("new")
	public ResponseEntity<AccountDTO> addAccount(AccountDTO accountDTO) {
		return new ResponseEntity<>(accountService.createAccount(accountDTO), HttpStatus.OK);
	}

	@RequestMapping("all")
	public ResponseEntity<List<AccountDTO>> allAccounts() {
		return new ResponseEntity<>(accountService.getAllAccounts(), HttpStatus.OK);
	}

	@RequestMapping("/{id}")
	public ResponseEntity<AccountDTO> getAccountById(@PathVariable Long id) {
		return new ResponseEntity<>(accountService.getAccountById(id), HttpStatus.OK);
	}

	@RequestMapping("/{id}/deposit")
	public ResponseEntity<AccountDTO> diposit(@PathVariable Long id, Map<String, Double> requests) {

		AccountDTO accountDTO = accountService.deposit(id, requests.get("amount"));

		return ResponseEntity.ok(accountDTO);
	}

	//Withdraw account endpoint

	@RequestMapping("/{id}/withdraw")
	public ResponseEntity<AccountDTO> withdraw(@PathVariable Long id, Map<String, Double> requests) {

		AccountDTO accountDTO = accountService.withdraw(id, requests.get("amount"));

		return  ResponseEntity.ok(accountDTO);
	}
	
	//Delete account endpoint

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAcount(@PathVariable Long id) {

		accountService.deleteAccount(id);

		return  ResponseEntity.ok("Account Deleted Successfully");
	}
	

}
