package com.activity.bankapp.entities;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="loan")
public class Loan {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int loan_id;
	
	private String loan_type;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "loan_id")
	private List<LoanApplication> loanappl;
	public Loan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Loan(int loan_id, String loan_type, List<LoanApplication> loanappl) {
		super();
		this.loan_id = loan_id;
		this.loan_type = loan_type;
		this.loanappl = loanappl;
	}
	public int getLoan_id() {
		return loan_id;
	}
	public void setLoan_id(int loan_id) {
		this.loan_id = loan_id;
	}
	public String getLoan_type() {
		return loan_type;
	}
	public void setLoan_type(String loan_type) {
		this.loan_type = loan_type;
	}
	public List<LoanApplication> getLoanappl() {
		return loanappl;
	}
	public void setLoanappl(List<LoanApplication> loanappl) {
		this.loanappl = loanappl;
	}
	
}
