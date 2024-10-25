package com.siva.banking.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "account_transactions")
public class AccountTransaction {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long transactionId;

	@ManyToOne
	@JoinColumn(name = "account_id", nullable = false)
	private Account account;

	@Enumerated(EnumType.STRING)
	private TransactionType transactionType;

	private double amount;

	private LocalDateTime transactionDate;

	// Constructors, getters, and setters

	public AccountTransaction() {
	}

	public AccountTransaction(Account account, double amount, TransactionType transactionType) {
		this.account = account;
		this.amount = amount;
		this.transactionType = transactionType;
		this.transactionDate = LocalDateTime.now();
	}

	public AccountTransaction(Long transactionId, Account account, TransactionType transactionType, double amount,
			LocalDateTime transactionDate) {
		super();
		this.transactionId = transactionId;
		this.account = account;
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

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}

	@Override
	public String toString() {
		return "AccountTransaction{" + "transactionId=" + transactionId + ", account=" + account + ", amount=" + amount
				+ ", transactionType=" + transactionType + ", transactionDate=" + transactionDate + '}';
	}
}
