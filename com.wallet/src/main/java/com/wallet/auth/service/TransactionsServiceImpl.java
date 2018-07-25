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
		User user = userRepository.findByUsername(fromuser);
		Transactions t = new Transactions();
		t.setToUser(touser);
		t.setFromCard("");
		t.setAmount(amount);
		t.setuId(user.getId());
		
		transactionsRepository.save(t);
		
		
		
		
	}
	public Set<Transactions> findAllTransactions(Long uId,String toUser)
	{
		Set<Transactions> t = transactionsRepository.findAllByUId(uId);
		t.addAll(transactionsRepository.findAllByToUser(toUser));
		return t;
	}

}
