package com.siva.banking.dto;

import java.time.LocalDateTime;
import java.util.Set;

import com.siva.banking.entity.Account;
import com.siva.banking.entity.TransactionType;

public class AccountTransactionDTO {

	private Long transactionId;

	private AccountDTO accountDTO;

	private TransactionType transactionType;

	private double amount;

	private LocalDateTime transactionDate;

	public AccountTransactionDTO() {
		super();
	}

	public AccountTransactionDTO(Long transactionId, AccountDTO accountDTO, TransactionType transactionType, double amount,
			LocalDateTime transactionDate) {
		super();
		this.transactionId = transactionId;
		this.accountDTO = accountDTO;
		this.transactionType = transactionType;
		this.amount = amount;
		this.transactionDate = transactionDate;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}
	public AccountDTO getAccountDTO() {
		return accountDTO;
	}

	public void setAccountDTO(AccountDTO accountDTO) {
		this.accountDTO = accountDTO;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}

	@Override
	public String toString() {
		return "AccountTransactionDTO [transactionId=" + transactionId + ", accountDTO=" + accountDTO
				+ ", transactionType=" + transactionType + ", amount=" + amount + ", transactionDate=" + transactionDate
				+ "]";
	}


}