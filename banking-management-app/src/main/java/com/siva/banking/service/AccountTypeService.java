package com.siva.banking.service;

import java.util.List;
import com.siva.banking.dto.AccountTypeDTO;

public interface AccountTypeService {

	AccountTypeDTO createAccountType(AccountTypeDTO accountTypeDTO);

	AccountTypeDTO getAccountTypeById(Long id);

	List<AccountTypeDTO> getAllAccountTypes();

	void deleteAccountType(Long id);
}
