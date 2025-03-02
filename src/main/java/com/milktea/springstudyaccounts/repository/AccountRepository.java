package com.milktea.springstudyaccounts.repository;

import com.milktea.springstudyaccounts.entity.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {
}
