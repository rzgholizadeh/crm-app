package com.mrghz.crmapp.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyInt;

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
@DisplayName("Customer Service Impl Test - ")
class CustomerServiceImplTest {

	@Mock
	CustomerRepository customerRepositoryMock;

	@InjectMocks
	CustomerServiceImpl theService;

	@DisplayName("findAll()")
	@Test
	void testFindAll() {
		Customer customer = new Customer();
		List<Customer> customers = new ArrayList<Customer>();
		customers.add(customer);
		when(customerRepositoryMock.findAllByOrderByLastNameAsc()).thenReturn(customers);
		List<Customer> foundCustomers = theService.findAll();
		verify(customerRepositoryMock).findAllByOrderByLastNameAsc();
		assertThat(foundCustomers).hasSize(1);

	}

	@DisplayName("findById()")
	@Test
	void testFindById() {
		Customer costumer = new Customer();
		when(customerRepositoryMock.findById(1)).thenReturn(Optional.of(costumer));
		Customer foundCostumer = theService.findById(1);
		assertThat(foundCostumer).isNotNull();
		verify(customerRepositoryMock).findById(1);
	}

	@DisplayName("save()")
	@Test
	void testSave() {
		theService.save(new Customer());
		verify(customerRepositoryMock).save(any(Customer.class));
	}

	@DisplayName("deleteById()")
	@Test
	void testDeleteById() {
		theService.deleteById(1);
		verify(customerRepositoryMock).deleteById(anyInt());
	}

}
