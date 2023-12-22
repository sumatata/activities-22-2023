package com.activity.bankapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.activity.bankapp.entities.LoanApplication;

public interface LoanApplicationRepository extends JpaRepository<LoanApplication, Integer>{

}
