package com.wallet.auth.service;

import com.wallet.auth.model.Transactions;

public interface TransactionsService {

		void save(String fromuser,String touser,Long amount);
		 
}
