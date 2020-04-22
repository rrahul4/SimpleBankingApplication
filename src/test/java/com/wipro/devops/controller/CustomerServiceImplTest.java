package com.wipro.devops.controller;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.wipro.devops.model.Customer;
import com.wipro.devops.service.CustomerRepository;
import com.wipro.devops.service.CustomerService;
import com.wipro.devops.service.CustomerServiceImpl;

@RunWith(SpringRunner.class)
public class CustomerServiceImplTest {
	
	@TestConfiguration
    static class CustomerServiceImplTestContextConfiguration {
  
        @Bean
        public CustomerService employeeService() {
            return new CustomerServiceImpl();
        }
    }
	
	@Autowired
    private CustomerService customerService;
 
    @MockBean
    private CustomerRepository customerRepository;
    
    @Mock
    CustomerServiceImpl custImpl;
    
    @MockBean
    private JdbcTemplate jdbcTemlate;
    
    Customer cust;
    
    @Before
    public void setUp() {
    	System.out.println("Inside Setup .................................");
    	cust = new Customer(1, "test", "testpass", "firstname", "lastname", 50, 100, 50, 50);
    	
    	
    }
    
   @Test
    public void whenValidName_thenEmployeeShouldBeFound() {
        String name = "firstname";
        //Customer found = customerService.retriveCustomer(1L);
        Mockito.when(customerService.retriveCustomer(1)).thenReturn(cust);
        System.out.println("=================================  "  + cust.getFirstName());
      System.out.println("Inside Loop");
         assertThat(cust.getFirstName())
          .isEqualTo(name);
         System.out.println("Finish");
     }
    
    @Test
    public void updateCustomerDebitAmountTest() {
    	Mockito.when(customerService.retriveCustomer(1)).thenReturn(cust);
    	cust.setDebitAmount(cust.getDebitAmount() + 30);
    	cust.setCurrentBalance(cust.getCurrentBalance() - 30);
    	System.out.println("====== Current Balance = " + cust.getCurrentBalance() );
    	customerRepository.save(cust);
    	assertThat(cust.getCurrentBalance()).isEqualTo(20);

    }
    
    @Test
    public void updateCustomerCreditAmountTest() {
    	Mockito.when(customerService.retriveCustomer(1)).thenReturn(cust);
    	cust.setDebitAmount(cust.getDebitAmount() + 30);
    	cust.setCurrentBalance(cust.getCurrentBalance() + 30);
    	System.out.println("====== Current Balance = " + cust.getCurrentBalance() );
    	customerRepository.save(cust);
    	assertThat(cust.getCurrentBalance()).isEqualTo(80);

    }

}

