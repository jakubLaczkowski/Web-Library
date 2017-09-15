package com.jakublaczkowski.weblibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jakublaczkowski.weblibrary.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Customer findCustomerByPesel(String pesel);
	Customer findCustomerByEmail(String email);
}
