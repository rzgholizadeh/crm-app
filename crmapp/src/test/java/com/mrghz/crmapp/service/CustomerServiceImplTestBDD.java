package com.mrghz.crmapp.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import mrghz.crmapp.dao.CustomerRepository;
import mrghz.crmapp.entity.Customer;
import mrghz.crmapp.service.CustomerServiceImpl;

@ExtendWith(MockitoExtension.class)
@DisplayName("Customer Service Impl BDD Test - ")
class CustomerServiceImplTestBDD {

	@Mock
	CustomerRepository customerRepositoryMock;

	@InjectMocks
	CustomerServiceImpl theService;

	@DisplayName("findAll()")
	@Test
	void testFindAll() {
		// given
		Customer customer = new Customer();
		List<Customer> customers = new ArrayList<Customer>();
		customers.add(customer);
		given(customerRepositoryMock.findAllByOrderByLastNameAsc()).willReturn(customers);
		// when
		List<Customer> foundCustomers = theService.findAll();
		// then
		then(customerRepositoryMock).should().findAllByOrderByLastNameAsc();
		assertThat(foundCustomers).hasSize(1);

	}

	@DisplayName("findById()")
	@Test
	void testFindById() {
		// given
		Customer costumer = new Customer();
		given(customerRepositoryMock.findById(1)).willReturn(Optional.of(costumer));
		// when
		Customer foundCostumer = theService.findById(1);
		// then
		then(customerRepositoryMock).should().findById(1);
		assertThat(foundCostumer).isNotNull();
	}

	@DisplayName("save()")
	@Test
	void testSave() {
		// when
		theService.save(new Customer());
		// then
		then(customerRepositoryMock).should().save(any(Customer.class));
	}

	@DisplayName("deleteById()")
	@Test
	void testDeleteById() {
		// when
		theService.deleteById(1);
		// then
		then(customerRepositoryMock).should().deleteById(anyInt());
	}

}
