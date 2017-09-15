package com.jakublaczkowski.weblibrary.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jakublaczkowski.weblibrary.exception.CustomerExistsException;
import com.jakublaczkowski.weblibrary.model.Customer;
import com.jakublaczkowski.weblibrary.repository.CustomerRepository;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepository;

	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public void addCustomer(Customer customer) throws CustomerExistsException {
		Customer existingCustomer = customerRepository.findCustomerByPesel(customer.getPesel());
		Customer existingCustomer2 = customerRepository.findCustomerByEmail(customer.getEmail());

		if (existingCustomer != null || existingCustomer2 != null) {
			throw new CustomerExistsException("Pesel or email already in use.");
		} else {
			customerRepository.saveAndFlush(customer);
		}

	}

	public void removeCustomer(Long customerId) {
		Customer customer = customerRepository.getOne(customerId);
		customerRepository.delete(customer);
	}

	public void updateCustomer(Long customerId, Customer customer) {
		Customer existingCustomer = customerRepository.findOne(customerId);
		BeanUtils.copyProperties(customer, existingCustomer);
		customerRepository.saveAndFlush(existingCustomer);
	}

	public Customer getCustomer(Long customerId) {
		return customerRepository.findOne(customerId);
	}

	public Customer getCustomerByPesel(String pesel) {
		return customerRepository.findCustomerByPesel(pesel);
	}

	public Customer getCustomerByEmail(String email) {
		return customerRepository.findCustomerByEmail(email);
	}

	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}


}
