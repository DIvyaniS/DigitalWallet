package com.wallet.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wallet.auth.model.Transactions;
@Repository
public interface TransactionsRepository extends JpaRepository<Transactions, Long>{

}
