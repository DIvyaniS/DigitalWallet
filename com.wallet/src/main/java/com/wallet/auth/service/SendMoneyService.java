package com.wallet.auth.service;

public interface SendMoneyService {
	void updateBalance(String fromuser,String touser, Long amount);

}
