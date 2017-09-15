package com.jakublaczkowski.weblibrary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jakublaczkowski.weblibrary.exception.CustomerExistsException;
import com.jakublaczkowski.weblibrary.model.Customer;
import com.jakublaczkowski.weblibrary.service.CustomerService;

@Controller
public class CustomerController {
	
	
	private CustomerService customerService;
	
	@Autowired
	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	@GetMapping(value = "customers")
	public List<Customer> listCustomers(){
		return customerService.getAllCustomers();
	}
	
	@PostMapping(value = "customers")
	public void addCustomer(@RequestBody Customer customer) throws CustomerExistsException{
		customerService.addCustomer(customer);
	}
	
	@PutMapping(value = "customers/{id}")
	public void updateCustomer(@PathVariable("id") Long customerId, @RequestBody Customer customer){
		customerService.updateCustomer(customerId, customer);
	}
	
	@DeleteMapping(value = "customers/{id}")
	public void removeCustomer(@PathVariable("id") Long customerId){
		customerService.removeCustomer(customerId);
	}
	
	@GetMapping(value = "customers/{id}")
	public Customer getCustomer(@PathVariable("id") Long customerId){
		return customerService.getCustomer(customerId);
	}
	
	@GetMapping(value = "customers/pesel/{pesel}")
	public Customer getCustomerByPesel(@PathVariable("pesel") String pesel){
		return customerService.getCustomerByPesel(pesel);
	}
}
