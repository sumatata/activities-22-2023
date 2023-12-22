package com.activity.bankapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.activity.bankapp.entities.Customer;
import com.activity.bankapp.exception.CustomerNotFoundException;


public interface CustomerService {
	
	//Fetch all customers
	List<Customer> fetchCustomers() throws CustomerNotFoundException;
	
	//Save the Customer
	Customer store(Customer customer);
	
	//Fetch customer by Id
	Customer findByCustomerId(Integer id) throws CustomerNotFoundException;
	
	
}
