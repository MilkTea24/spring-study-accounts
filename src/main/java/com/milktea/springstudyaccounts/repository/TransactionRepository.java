package com.milktea.springstudyaccounts.repository;

import com.milktea.springstudyaccounts.entity.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
}
