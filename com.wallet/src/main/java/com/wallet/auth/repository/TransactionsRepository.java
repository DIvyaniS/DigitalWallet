package com.wallet.auth.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wallet.auth.model.Transactions;
@Repository
public interface TransactionsRepository extends JpaRepository<Transactions, Long>{

	Set<Transactions> findAllByUId(Long uId);
	Set<Transactions> findAllByToUser(String toUser);
}
