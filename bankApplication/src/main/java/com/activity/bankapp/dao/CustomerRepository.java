package com.activity.bankapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.activity.bankapp.entities.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	
}
