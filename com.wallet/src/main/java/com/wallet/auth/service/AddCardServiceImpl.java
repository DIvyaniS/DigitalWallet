package com.wallet.auth.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wallet.auth.model.CardInfo;
import com.wallet.auth.model.User;
import com.wallet.auth.repository.CardInfoRepository;

@Service
public class AddCardServiceImpl implements AddCardService{
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CardInfoRepository cardInfoRepository;
	
	@Override
	@Transactional
	public void save(String bankName, String cardNumber,String userName)
	{
		System.out.println("*****************Entered****************");
		CardInfo cardInfo = new CardInfo();
		cardInfo.setBankName(bankName);
		cardInfo.setCardNumber(cardNumber);
		
		User user = userService.findByUsername(userName);
		System.out.println("****************username: "+user.getUsername());
		if(cardInfo.getUsers() != null)
		{
			cardInfo.getUsers().add(user);	
		}
		else 
		{
			Set<User> s = new HashSet<>();
			s.add(user);
			cardInfo.setUsers(s);
		}
		
		if(user.getCardInfo() != null)
		{
			user.getCardInfo().add(cardInfo);
		}
		else
		{
			Set<CardInfo> c = new HashSet<>();
			c.add(cardInfo);
			user.setCardInfo(c);
		}
		
		
		
		System.out.println("****************username2: "+user.getUsername());
		cardInfoRepository.save(cardInfo);
		
		
	}

}
