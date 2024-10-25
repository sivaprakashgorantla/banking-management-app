package com.siva.banking.mapper;

import org.springframework.stereotype.Component;

import com.siva.banking.dto.AccountTypeDTO;
import com.siva.banking.entity.AccountType;
@Component
public class AccountTypeMapper {

	public static AccountType mapToAccountType(AccountTypeDTO accountTypeDTO) {
		AccountType accountType= new AccountType(accountTypeDTO.getId(),accountTypeDTO.getTypeName());
		return accountType;
	}
	
	public static AccountTypeDTO mapToAccountTypeDto(AccountType accountType) {
		AccountTypeDTO accountTypeDTO = new AccountTypeDTO(accountType.getId(),accountType.getTypeName());
		return accountTypeDTO;
	}
}
