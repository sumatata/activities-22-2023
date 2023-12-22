package com.activity.bankapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.activity.bankapp.entities.Loan;

public interface LoanRepository extends JpaRepository<Loan, Integer>{

}
