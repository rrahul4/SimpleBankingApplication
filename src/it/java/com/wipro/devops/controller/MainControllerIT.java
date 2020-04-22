package com.wipro.devops.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.wipro.devops.model.Customer;
import com.wipro.devops.service.CustomerRepository;
import com.wipro.devops.service.CustomerService;
import com.wipro.devops.service.CustomerServiceImpl;



@RunWith(SpringRunner.class)
@DataJpaTest
public class MainControllerIT {
	
	@TestConfiguration
    static class CustomerServiceImplTestContextConfiguration {
  
        @Bean
        public CustomerService employeeService() {
            return new CustomerServiceImpl();
        }
    }
	
	 @Autowired
	 private TestEntityManager entityManager;
	 
	 @Autowired
	 private CustomerRepository customerRepo;
	 
	 @Autowired
	 private CustomerService custImpl;
	 
	
	 
	 
	
	 @Test
		public void retriveCustomerTest() throws Exception {
			System.out.println("********************** Before Entity");
			Customer cust = new Customer(3l, "test", "testpass", "firstname", "lastname", 50, 100, 50, 50);
			entityManager.merge(cust);
		    entityManager.flush();
		    
		    System.out.println("******************* After Entity");
		    
		    //custImpl.retriveCustomer(2l);
		    
		    Customer value = custImpl.retriveCustomer(3l);
		    
		    System.out.println("======================" + value.getAccountNumber());
		    
		    assertThat(value.getFirstName())
		      .isEqualTo(cust.getFirstName());
		}

	
	 @Test
	 public void updateCustomerCreditAmountTest() {
		 Customer cust = new Customer(1l, "test", "testpass", "firstname", "lastname", 50, 100, 50, 50);
		entityManager.merge(cust);
		  entityManager.flush();
		 custImpl.updateCustomerCreditAmount(1l, 30);
		 System.out.println("================ Balance = " + cust.getCurrentBalance());
		 Optional<Customer> value = customerRepo.findById(cust.getAccountNumber());
		 System.out.println("================ New Balance = " + value.get().getCurrentBalance());
		 
		 assertThat(value.get().getCurrentBalance())
	      .isEqualTo(cust.getCurrentBalance() + 30);
	 }
	 
	 @Test
	 public void updateCustomerDebitAmountTest() {
		 Customer cust = new Customer(2l, "test", "testpass", "firstname", "lastname", 50, 100, 50, 50);
			entityManager.merge(cust);
			  entityManager.flush();
		 custImpl.updateCustomerDebitAmount(2l, 30);
		 System.out.println("================ Balance = " + cust.getCurrentBalance());
		 Optional<Customer> value = customerRepo.findById(cust.getAccountNumber());
		 System.out.println("================ New Balance = " + value.get().getCurrentBalance());
		 
		 assertThat(value.get().getCurrentBalance())
	      .isEqualTo(cust.getCurrentBalance() - 30);
	 }
	
	
	
}

