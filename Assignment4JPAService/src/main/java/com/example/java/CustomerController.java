package com.example.java;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerRepository customerRepository;
	
	// Get All Employees
	@RequestMapping(value = "/customers", method = RequestMethod.GET)
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }
    
	@RequestMapping(value = "/customer/{custId}", method = RequestMethod.GET)
    public Customer getCustomer(@PathVariable("custId") int custId) {
    	Customer customer = customerRepository.findById(custId)
    			.orElseThrow(() -> new IllegalArgumentException("Invalid movie id :" + custId));
    	return customer;
    }

    // Add a new movie
	@RequestMapping(value = "/customer", method = RequestMethod.POST)
    public Customer addCustomer(@Valid @RequestBody Customer customer) {
        return customerRepository.save(customer);
    }
    //update a movie
	@RequestMapping(value = "/customer/{custId}", method = RequestMethod.PUT)
    public void updateCustomer(@PathVariable("custId") int custId,@Valid Customer customer) {
    	customer.setCustId(custId);
    	customerRepository.save(customer);
    }
    //delete a movie
	@RequestMapping(value = "/customer/{custId}", method = RequestMethod.DELETE)
    public void deleteCustomer(@PathVariable("custId") int custId) {
    	Customer customer = customerRepository.findById(custId)
    			.orElseThrow(() -> new IllegalArgumentException("Invalid movie id :" + custId));
    	customerRepository.delete(customer);
    }
}
