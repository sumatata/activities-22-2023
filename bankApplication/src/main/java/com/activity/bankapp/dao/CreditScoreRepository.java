package com.activity.bankapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.activity.bankapp.entities.CreditScore;

public interface CreditScoreRepository extends JpaRepository<CreditScore, Integer>{

}
