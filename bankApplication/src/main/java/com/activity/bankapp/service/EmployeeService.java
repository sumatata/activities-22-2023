package com.activity.bankapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.activity.bankapp.entities.Employee;
import com.activity.bankapp.exception.CustomerNotFoundException;
import com.activity.bankapp.exception.EmployeeNotFoundException;


public interface EmployeeService {
 
		//Fetch all customers
		List<Employee> fetchEmployees() throws  EmployeeNotFoundException;
		
		//Save the Customer
		Employee store(Employee employee);
		
		//Fetch customer by Id
		Employee findByEmployeeId(Integer id) throws EmployeeNotFoundException;
}
