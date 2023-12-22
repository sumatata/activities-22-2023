package com.activity.bankapp.service;

import java.util.List;

import com.activity.bankapp.dao.LoanApplicationRepository;
import com.activity.bankapp.entities.Employee;
import com.activity.bankapp.entities.LoanApplication;
import com.activity.bankapp.exception.EmployeeNotFoundException;
import com.activity.bankapp.exception.LoanAppNotFoundException;

public interface LoanAppService {

			
			//Fetch all customers
			List<LoanApplication> fetchLoanapp() throws  LoanAppNotFoundException;
			
			//Save the Customer
			LoanApplication store(LoanApplication loanapp);
			
			//Fetch customer by Id
			LoanApplication findByLoanAppId(Integer id) throws LoanAppNotFoundException;
}
