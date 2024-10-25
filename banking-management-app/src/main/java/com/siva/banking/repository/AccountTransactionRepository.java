package com.siva.banking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.siva.banking.dto.AccountDTO;
import com.siva.banking.entity.Account;
import com.siva.banking.entity.AccountTransaction;

@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Long> {
     //List<AccountDTO> findAllAccounts();
	List<AccountTransaction> findByAccount_AccountId(Long accountId);
}
