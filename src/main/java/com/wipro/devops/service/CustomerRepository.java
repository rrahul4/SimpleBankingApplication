package com.wipro.devops.service;

import org.springframework.data.repository.CrudRepository;
import com.wipro.devops.model.Customer;


public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
