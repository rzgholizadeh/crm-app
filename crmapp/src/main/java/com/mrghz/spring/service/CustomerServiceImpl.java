package com.mrghz.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrghz.spring.dao.CustomerDAO;
import com.mrghz.spring.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	// need to inject customer DAO
	@Autowired
	private CustomerDAO customerDAO;

	@Transactional
	@Override
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	@Transactional
	@Override
	public void saveCustomer(Customer theCustomer) {
		customerDAO.saveCustomer(theCustomer);
	}

}
