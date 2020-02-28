package com.mrghz.crmapp.service;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import mrghz.crmapp.dao.CustomerRepository;
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

	@Disabled
	@Test
	void testFindById() {
		fail("Not yet implemented");
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
