package com.activity.bankapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.activity.bankapp.dao.LoanApplicationRepository;
import com.activity.bankapp.entities.Employee;
import com.activity.bankapp.entities.Loan;
import com.activity.bankapp.entities.LoanApplication;
import com.activity.bankapp.exception.LoanAppNotFoundException;
import com.activity.bankapp.exception.LoanNotFoundException;

@Service
public class LoanAppServiceImpl implements LoanAppService{

	@Autowired
	public LoanApplicationRepository loanappdao;
	
	@Override
	public List<LoanApplication> fetchLoanapp() throws LoanAppNotFoundException {
		List<LoanApplication> loans =loanappdao.findAll();
		if (loans.size() == 0)
			throw new LoanAppNotFoundException("There are no records for Employees");
		else
			return loans;
	}

	@Override
	public LoanApplication store(LoanApplication loanapp) {
		LoanApplication loans = loanappdao.save(loanapp);
		return loans;
	}


	@Override
	public LoanApplication findByLoanAppId(Integer id) throws LoanAppNotFoundException {
		Optional<LoanApplication> loan = loanappdao.findById(id);
		return loan.orElseThrow(() -> new LoanAppNotFoundException("employee with an id "+id+"not found"));
	}

}
