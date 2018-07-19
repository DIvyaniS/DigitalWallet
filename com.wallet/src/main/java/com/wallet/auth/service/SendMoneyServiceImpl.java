package com.wallet.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wallet.auth.model.User;
import com.wallet.auth.repository.TransactionsRepository;
import com.wallet.auth.repository.UserRepository;

@Service
public class SendMoneyServiceImpl implements SendMoneyService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TransactionsRepository transactionsRepository;
	public void updateBalance(String fromuser, String touser, Long amount)
	{
		User user1 = userRepository.findByUsername(fromuser);
		User user2 = userRepository.findByUsername(touser);
		userRepository.updateBalance(fromuser, user1.getBalance()-amount);
		userRepository.updateBalance(touser, user2.getBalance()+amount);
		
	}
	
}
