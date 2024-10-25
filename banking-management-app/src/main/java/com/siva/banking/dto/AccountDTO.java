package com.siva.banking.dto;

import com.siva.banking.entity.AccountType;

public class AccountDTO {

	private Long accountId;
	private String name;
	private double amount;
	private AccountType accountType;

	
	public AccountDTO() {
		super();
	}

	
	public AccountDTO(Long accountId, String name) {
		super();
		this.accountId = accountId;
		this.name = name;
	}

	    //   AccountDTO(a.accountId, a.name, a.amount, at.id, at.typeName) 
	public AccountDTO(Long accountId, String name, double amount, AccountType accountType) {
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
		return "AccountDTO [accountId=" + accountId + ", name=" + name + ", amount=" + amount + ", accountType="
				+ accountType + "]";
	}


}

