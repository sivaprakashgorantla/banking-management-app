package com.siva.banking.mapper;

import org.springframework.stereotype.Component;

import com.siva.banking.dto.AccountDTO;
import com.siva.banking.entity.Account;
import com.siva.banking.entity.AccountType;

@Component
public class AccountMapper {

	public static Account mapToAccount(AccountDTO accountDTO) {
		if (accountDTO == null) {
            return null;
        }

        Account account = new Account();
        account.setAccountId(accountDTO.getAccountId());
        account.setName(accountDTO.getName());
        account.setAmount(accountDTO.getAmount());

        // AccountType should be fetched or created separately based on your application logic
        // This is a placeholder for AccountType
        AccountType accountType = new AccountType(accountDTO.getAccountId(),accountDTO.getName());
        account.setAccountType(accountType);

        return account;

	}
	
	public static AccountDTO mapToAccountDto(Account account) {
		System.out.println("mapToAccountDto  :"+account);
		if (account == null) {
            return null;
        }

        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountId(account.getAccountId());
        accountDTO.setName(account.getName());
        accountDTO.setAmount(account.getAmount());
		accountDTO.setAccountType(account.getAccountType());
        /*
		 * // Set account type fields if (account.getAccountType() != null) {
		 * accountDTO.setAccountTypeId(account.getAccountType().getId());
		 * accountDTO.setAccountTypeName(account.getAccountType().getTypeName()); }
		 */
        return accountDTO;
	}
}
