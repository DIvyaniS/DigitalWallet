package com.wallet.auth.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wallet.auth.model.Transactions;
import com.wallet.auth.model.User;
import com.wallet.auth.repository.TransactionsRepository;
import com.wallet.auth.repository.UserRepository;

@Service
public class TransactionsServiceImpl implements TransactionsService{
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TransactionsRepository transactionsRepository;
	@Override
	public void save(String fromuser,String touser,Long amount)
	{
		Transactions t = new Transactions();
		t.setToUser(touser);
		t.setFromCard("");
		t.setAmount(amount);
		Set<Transactions> s = new HashSet<>();
		s.add(t);
		
		User user = userRepository.findByUsername(fromuser);
		if(!user.getTransactions().isEmpty())
		{
			user.getTransactions().add(t);
			//System.out.println("at transactions"+user.toString());
		}
		else
		{
			user.setTransactions(s);
			System.out.println("at transactions"+user.toString());
			
		}
		transactionsRepository.save(t);
	}

}
