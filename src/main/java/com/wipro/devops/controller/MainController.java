package com.wipro.devops.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wipro.devops.model.Customer;
import com.wipro.devops.service.CustomerServiceImpl;

@Controller
public class MainController {

	@Autowired
	private CustomerServiceImpl customerService;
	
    @GetMapping("/register")
    public String registerGet( Model model) {
    	
    	model.addAttribute("customer", new Customer());
        return "register";
    }
          
    @GetMapping("/login")
    public String loginGet( Model model) {
    	
      	model.addAttribute("customer", new Customer());
        return "login";
    }
    
    @PostMapping("/accountDetails")
    public String accountDetails( @RequestParam (required= false, value = "txntype") String txntype, 
   		@ModelAttribute Customer customer, Model model) {
	   	      	
   	    System.out.println("Trans amount: " + customer.getTransactionAmount() + txntype ); 
   	    
   	    if (customer.getAccountNumber() == 0)
		{
 	      customerService.createCustomer(customer);
	    }
	
   	
   	    if (txntype != null && txntype.equalsIgnoreCase("Credit")) 
   	    { 	
   	    	customerService.updateCustomerCreditAmount(customer.getAccountNumber(), customer.getTransactionAmount());  		
   	    } else if (txntype != null && txntype.equalsIgnoreCase ("Debit"))
   	         {	
   	    	   customerService.updateCustomerDebitAmount(customer.getAccountNumber(), customer.getTransactionAmount());  		
   	         }
   	 
        System.out.println("From accountDetails :" + customerService.retriveCustomer(customer.getAccountNumber()).toString());    	
	
      	model.addAttribute("customer", customerService.retriveCustomer(customer.getAccountNumber()));
				
        return "accountDetails";
   }

}
