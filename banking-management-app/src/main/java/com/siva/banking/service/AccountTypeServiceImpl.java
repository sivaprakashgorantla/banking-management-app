package com.siva.banking.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.siva.banking.dto.AccountDTO;
import com.siva.banking.dto.AccountTypeDTO;
import com.siva.banking.entity.Account;
import com.siva.banking.entity.AccountType;
import com.siva.banking.exception.AccountGlobalException;
import com.siva.banking.mapper.AccountMapper;
import com.siva.banking.mapper.AccountTypeMapper;
import com.siva.banking.repository.AccountTypeRepository;

public class AccountTypeServiceImpl implements AccountTypeService {

	@Autowired
	private AccountTypeRepository accountTypeRepository;
	
	@Override
	public AccountTypeDTO createAccountType(AccountTypeDTO accountTypeDTO) {
		// TODO Auto-generated method stub
		AccountType accountType = AccountTypeMapper.mapToAccountType(accountTypeDTO);
		AccountType saveAccountType =  accountTypeRepository.save(accountType);
		AccountTypeDTO accountTypeDTO2 = AccountTypeMapper.mapToAccountTypeDto(saveAccountType);
		return accountTypeDTO2;
	}

	@Override
	public AccountTypeDTO getAccountTypeById(Long id) {
		// TODO Auto-generated method stub

		AccountType accountType = accountTypeRepository.findById(id).orElseThrow(() ->new AccountGlobalException("AccountType does not exists"));
		AccountTypeDTO accountTypeDTO =  AccountTypeMapper.mapToAccountTypeDto(accountType);
		return accountTypeDTO;	}

	@Override
	public List<AccountTypeDTO> getAllAccountTypes() {
		// TODO Auto-generated method stub
		List<AccountType> accounTypets= accountTypeRepository.findAll();
		return accounTypets.stream().map(AccountTypeMapper::mapToAccountTypeDto).collect(Collectors.toList());

	}

	@Override
	public void deleteAccountType(Long id) {
		// TODO Auto-generated method stub
		AccountType accountType = accountTypeRepository.findById(id).orElseThrow(() -> new AccountGlobalException("AccountType does not exists"));

		accountTypeRepository.delete(accountType);

	}

}
