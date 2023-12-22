package com.activity.bankapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.activity.bankapp.dao.LoanRepository;
import com.activity.bankapp.entities.Employee;
import com.activity.bankapp.entities.Loan;
import com.activity.bankapp.exception.EmployeeNotFoundException;
import com.activity.bankapp.exception.LoanNotFoundException;

@Service
public class LoanServiceImpl implements LoanService{

	@Autowired
	public LoanRepository loandao;
	
	@Override
	public Loan store(Loan loan) {
		Loan loans = loandao.save(loan);
		return loans;
	}

	@Override
	public List<Loan> fetchLoans() throws LoanNotFoundException {
		List<Loan> loans =loandao.findAll();
		if (loans.size() == 0)
			throw new LoanNotFoundException("There are no records for Employees");
		else
			return loans;
	}

	@Override
	public Loan findByLoanId(Integer id) throws LoanNotFoundException {
		Optional<Loan> loan = loandao.findById(id);
		return loan.orElseThrow(() -> new LoanNotFoundException("employee with an id "+id+"not found"));
	}

}
