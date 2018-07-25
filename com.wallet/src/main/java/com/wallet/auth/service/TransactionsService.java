package com.wallet.auth.service;

import java.util.Set;

import com.wallet.auth.model.Transactions;

public interface TransactionsService {

		void save(String fromuser,String touser,Long amount);
		Set<Transactions> findAllTransactions(Long uId,String toUser);
		
}
