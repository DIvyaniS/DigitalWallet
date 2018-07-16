package com.wallet.auth.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wallet.auth.model.CardInfo;

@Repository
public interface CardInfoRepository extends JpaRepository<CardInfo, Long>{
}
