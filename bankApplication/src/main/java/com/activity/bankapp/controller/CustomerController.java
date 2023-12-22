package com.activity.bankapp.controller;

import java.util.List;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.activity.bankapp.entities.Customer;
import com.activity.bankapp.exception.CustomerNotFoundException;
import com.activity.bankapp.service.*;

@RestController
@RequestMapping("/api/customer")
@CrossOrigin(origins = "*")
public class CustomerController {

	@Autowired
	public CustomerService custservice;
	
	@GetMapping()
	public ResponseEntity<Object> fetchProfiles() throws CustomerNotFoundException{
		try {
			List<Customer> list =custservice.fetchCustomers();
		return ResponseEntity.status(200).body(list);
		}catch(Exception e){
			String message = e.getMessage();//every Exception class has getMessage
			Map<String, String> error =new HashMap<>();
			error.put("error", message);
			return ResponseEntity.status(404).body(error); //map will be converted to JSON
		}
	}
	
	@GetMapping(path ="/{id}")
	public ResponseEntity<Object> findById(@PathVariable("id") int id) throws CustomerNotFoundException{
		try {
			Customer list =custservice.findByCustomerId(id);
		return ResponseEntity.status(200).body(list);
		}catch(Exception e){
			String message = e.getMessage();//every Exception class has getMessage
			Map<String, String> error =new HashMap<>();
			error.put("error", message);
			return ResponseEntity.status(404).body(error); //map will be converted to JSON
		}
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> Store(@RequestBody Customer customer) {
		return ResponseEntity.status(201).body(custservice.store(customer));
	}
	
}
