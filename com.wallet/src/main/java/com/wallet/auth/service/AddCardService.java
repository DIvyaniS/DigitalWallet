package com.wallet.auth.service;

import com.wallet.auth.model.CardInfo;

public interface AddCardService 
{
	void save(String bankName, String cardNumber,String userName);
}
