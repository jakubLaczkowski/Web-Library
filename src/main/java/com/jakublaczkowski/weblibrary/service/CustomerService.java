package com.jakublaczkowski.weblibrary.service;

import java.util.List;

import com.jakublaczkowski.weblibrary.exception.CustomerExistsException;
import com.jakublaczkowski.weblibrary.model.Customer;


public interface CustomerService {
	
	void addCustomer(Customer customer) throws CustomerExistsException;
	void removeCustomer(Long customerId);
	void updateCustomer(Long customerId, Customer customer);
	Customer getCustomer(Long customerId);
	Customer getCustomerByPesel(String pesel);
	List<Customer> getAllCustomers();
	

}
