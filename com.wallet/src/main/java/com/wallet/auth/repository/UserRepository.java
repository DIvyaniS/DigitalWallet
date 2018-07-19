package com.wallet.auth.repository;

import com.wallet.auth.model.User;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    @Transactional
    @Modifying
	@Query("update User u set u.balance = ?2 where u.username = ?1")
	void updateBalance(String username, Long amount);
    
    
}
