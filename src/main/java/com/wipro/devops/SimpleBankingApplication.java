package com.wipro.devops;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.wipro.devops.model.Customer;
import com.wipro.devops.service.CustomerServiceImpl;


@SpringBootApplication
public class SimpleBankingApplication extends SpringBootServletInitializer implements CommandLineRunner {
	
	@Autowired
	private CustomerServiceImpl customerService;
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application)  {
        return application.sources(SimpleBankingApplication.class);
	}
	
    public static void main(String[] args) {
        SpringApplication.run(SimpleBankingApplication.class, args);
    }

	public void run(String... arg0) throws Exception {
		
		System.out.println("In Command Line Runner - Start");
		
		Customer customer1 = new Customer(1, "user1", "password1", "Rahulkumar", "Rakhonde", 1000, 1000, 0 ,0);
		Customer customer2 = new Customer(2, "user2", "password2", "Vijaykumar", "Subramanian", 1000, 1000, 0 ,0);
		Customer customer3 = new Customer(3, "user3", "password3", "Sandeep", "Srikhakollu", 1000, 1000, 0 ,0);
	
		customerService.createCustomer(customer1);
		customerService.createCustomer(customer2);
		customerService.createCustomer(customer3);
		
		System.out.println("In Command Line Runner - End");
	}

}
