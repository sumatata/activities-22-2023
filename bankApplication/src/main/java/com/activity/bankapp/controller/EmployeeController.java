package com.activity.bankapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.activity.bankapp.entities.*;
import com.activity.bankapp.exception.*;
import com.activity.bankapp.service.*;


@RestController
@RequestMapping("/api/employee")
@CrossOrigin(origins = "*")
public class EmployeeController {

	@Autowired
	public EmployeeService empservice;
	
	@GetMapping()
	public ResponseEntity<Object> fetchProfiles() throws EmployeeNotFoundException{
		try {
			List<Employee> list =empservice.fetchEmployees();
		return ResponseEntity.status(200).body(list);
		}catch(Exception e){
			String message = e.getMessage();//every Exception class has getMessage
			Map<String, String> error =new HashMap<>();
			error.put("error", message);
			return ResponseEntity.status(404).body(error); //map will be converted to JSON
		}
	}
	
	@GetMapping(path ="/{id}")
	public ResponseEntity<Object> findById(@PathVariable("id") int id) throws EmployeeNotFoundException{
		try {
			Employee list =empservice.findByEmployeeId(id);
		return ResponseEntity.status(200).body(list);
		}catch(Exception e){
			String message = e.getMessage();//every Exception class has getMessage
			Map<String, String> error =new HashMap<>();
			error.put("error", message);
			return ResponseEntity.status(404).body(error); //map will be converted to JSON
		}
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> Store(@RequestBody Employee employee) {
		return ResponseEntity.status(201).body(empservice.store(employee));
	}
	
}

