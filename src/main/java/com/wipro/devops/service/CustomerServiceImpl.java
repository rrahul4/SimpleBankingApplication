package com.wipro.devops.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.wipro.devops.model.Customer;



@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	JdbcTemplate jdbcTemlate;
	
	public String createCustomer(Customer customer) {
		 
		 customer.setMessage("Welcome to Account Details Page!!");
		 customerRepository.save(customer);
		 
		 return "Success";
		
	}
	
	public Customer retriveCustomer(int i) {
		
		Customer customer = new Customer();
				
		customer = jdbcTemlate.queryForObject("Select * From CUSTOMER where ACCOUNT_NUMBER=?", new Object[] {i},
				new BeanPropertyRowMapper<Customer>(Customer.class));
		
		return customer;
			
	}

	
	public void updateCustomerCreditAmount(int accountNumber, int Amount) {
		
	    Customer customer = retriveCustomer(accountNumber);
		
	    if (Amount < 0)
   	    {
   	    	customer.setMessage("Transaction Amount must be greater than 0 !!");
   	    } else {
   	    	customer.setCreditAmount(customer.getCreditAmount() + Amount);
   		    customer.setCurrentBalance(customer.getCurrentBalance() + Amount);
   		   	customer.setMessage("Transaction is Successful !!");
   	    	
   	    }

	    customerRepository.save(customer);
	    
		
	}
	
	public void updateCustomerDebitAmount(int accountNumber, int Amount) {
		
        Customer customer = retriveCustomer(accountNumber);
		
	    if (Amount < 0)
   	    {
   	    	customer.setMessage("Transaction Amount must be greater than 0 !!");
   	    } else if ((customer.getCurrentBalance() - Amount) < 0) {
   	    	customer.setMessage("Transaction Declined...Current Balance is going to be less than 0");
   	    	
   	    } else { 
	        customer.setDebitAmount(customer.getDebitAmount() + Amount);
	        customer.setCurrentBalance(customer.getCurrentBalance() - Amount);
	       	customer.setMessage("Transaction is Successful !!");
   	    }
	    
	    customerRepository.save(customer);
	  
		
	}
}
