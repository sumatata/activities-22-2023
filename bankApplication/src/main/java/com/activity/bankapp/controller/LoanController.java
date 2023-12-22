package com.activity.bankapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.activity.bankapp.entities.Customer;
import com.activity.bankapp.entities.Loan;
import com.activity.bankapp.exception.CustomerNotFoundException;
import com.activity.bankapp.exception.LoanNotFoundException;
import com.activity.bankapp.service.LoanService;

@RestController
@RequestMapping("/api/loan")
@CrossOrigin(origins = "*")
public class LoanController {

	public LoanService loansvc;
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> Store(@RequestBody Loan loan) {
		return ResponseEntity.status(201).body(loansvc.store(loan));
	}
	
	@GetMapping()
	public ResponseEntity<Object> fetchLoans() throws LoanNotFoundException{
		try {
			List<Loan> list =loansvc.fetchLoans();
		return ResponseEntity.status(200).body(list);
		}catch(Exception e){
			String message = e.getMessage();//every Exception class has getMessage
			Map<String, String> error =new HashMap<>();
			error.put("error", message);
			return ResponseEntity.status(404).body(error); //map will be converted to JSON
		}
	}
	
	@GetMapping(path ="/{id}")
	public ResponseEntity<Object> findById(@PathVariable("id") int id) throws LoanNotFoundException{
		try {
			Loan list =loansvc.findByLoanId(id);
		return ResponseEntity.status(200).body(list);
		}catch(Exception e){
			String message = e.getMessage();//every Exception class has getMessage
			Map<String, String> error =new HashMap<>();
			error.put("error", message);
			return ResponseEntity.status(404).body(error); //map will be converted to JSON
		}
	}
}
