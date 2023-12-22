package com.activity.bankapp.service;




import java.util.List;

import com.activity.bankapp.entities.*;
import com.activity.bankapp.exception.EmployeeNotFoundException;
import com.activity.bankapp.exception.LoanNotFoundException;


public interface LoanService {

	
	
			//Fetch all customers
			List<Loan> fetchLoans() throws  LoanNotFoundException;
			
			//Save the Customer
			Loan store(Loan loan);
			
			//Fetch customer by Id
			Loan findByLoanId(Integer id) throws LoanNotFoundException;
}
