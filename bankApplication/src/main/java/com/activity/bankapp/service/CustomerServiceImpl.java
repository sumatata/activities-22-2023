package com.activity.bankapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.activity.bankapp.dao.CustomerRepository;
import com.activity.bankapp.entities.Customer;
import com.activity.bankapp.exception.CustomerNotFoundException;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	public CustomerRepository custdao;
	
	@Override
	public List<Customer> fetchCustomers() throws CustomerNotFoundException {
		List<Customer> customers =custdao.findAll();
		if (customers.size() == 0)
			throw new CustomerNotFoundException();
		else
			return customers;
	}

	@Override
	public Customer store(Customer customer) {
		Customer savedCustomers = custdao.save(customer);
		return savedCustomers;
	}


	@Override
	public Customer findByCustomerId(Integer id) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		Optional<Customer> customer = custdao.findById(id);
		return customer.orElseThrow(() -> new CustomerNotFoundException("customer with an id "+id+"not found"));
	}

	
}
