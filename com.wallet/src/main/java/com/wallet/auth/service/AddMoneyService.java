package com.wallet.auth.service;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface AddMoneyService {
	
	void updateBalance(String username, Long amount);
	
}
