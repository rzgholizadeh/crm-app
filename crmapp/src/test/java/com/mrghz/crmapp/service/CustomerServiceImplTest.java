package com.mrghz.crmapp.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import mrghz.crmapp.dao.CustomerRepository;
import mrghz.crmapp.entity.Customer;
import mrghz.crmapp.service.CustomerServiceImpl;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

	@Mock
	CustomerRepository customerRepositoryMock;

	@InjectMocks
	CustomerServiceImpl theService;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Disabled
	@Test
	void testFindAll() {
		fail("Not yet implemented");
	}

	@Test
	void testFindById() {
		Customer costumer = new Customer();
		when(customerRepositoryMock.findById(1)).thenReturn(Optional.of(costumer));
		costumer = theService.findById(1);
		assertThat(costumer).isNotNull();
		verify(customerRepositoryMock).findById(1);
	}

	@Disabled
	@Test
	void testSave() {
	}

	@Test
	void testDeleteById() {
		theService.deleteById(1);
		verify(customerRepositoryMock).deleteById(1);
	}

}
