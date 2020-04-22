package com.wipro.devops.service;

import com.wipro.devops.model.Customer;


public interface CustomerService {
	
	public String createCustomer(Customer customer);
	
	public Customer retriveCustomer(int i);
	
	public void updateCustomerCreditAmount(int accountNumber, int Amount);
	
	public void updateCustomerDebitAmount(int accountNumber, int Amount);
}
