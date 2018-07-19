package com.wallet.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wallet.auth.model.User;
import com.wallet.auth.repository.UserRepository;
@Service
public class AddMoneyServiceImpl implements AddMoneyService{
	
	@Autowired
    private UserRepository userRepository;
	public void updateBalance(String username, Long amount)
	{
		User user = userRepository.findByUsername(username);
		userRepository.updateBalance(username, amount+user.getBalance());
	}

}
