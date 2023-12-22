package com.activity.bankapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.activity.bankapp.dao.EmployeeRepository;
import com.activity.bankapp.entities.Employee;
import com.activity.bankapp.exception.EmployeeNotFoundException;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	public EmployeeRepository empdao;
	
	@Override
	public List<Employee> fetchEmployees() throws EmployeeNotFoundException {
		List<Employee> employees =empdao.findAll();
		if (employees.size() == 0)
			throw new EmployeeNotFoundException("There are no records for Employees");
		else
			return employees;
	}

	@Override
	public Employee store(Employee employee) {
		Employee employees = empdao.save(employee);
		return employees;
	}


	@Override
	public Employee findByEmployeeId(Integer id) throws EmployeeNotFoundException {
		Optional<Employee> employee = empdao.findById(id);
		return employee.orElseThrow(() -> new EmployeeNotFoundException("employee with an id "+id+"not found"));
	}

}
