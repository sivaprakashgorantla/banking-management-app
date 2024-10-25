package com.siva.banking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.siva.banking.dto.AccountDTO;
import com.siva.banking.entity.AccountType;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType, Long> {


}
