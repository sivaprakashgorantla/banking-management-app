package com.siva.banking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Accounts")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long accountId;
	private String name;
	private double amount;

	// Many Accounts can have one AccountType
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "account_type_id")
	@JsonIgnore
	private AccountType accountType;

	public Account() {
		super();
	}

	public Account(Long accountId, String name, double amount, AccountType accountType) {
		super();
		this.accountId = accountId;
		this.name = name;
		this.amount = amount;
		this.accountType = accountType;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", name=" + name + ", amount=" + amount + ", accountType="
				+ accountType + "]";
	}

	
}
