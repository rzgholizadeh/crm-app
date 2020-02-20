package com.mrghz.spring.service;

import java.util.List;

import com.mrghz.spring.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

}
