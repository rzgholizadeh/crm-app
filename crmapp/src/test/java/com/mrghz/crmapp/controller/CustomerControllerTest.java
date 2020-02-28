package com.mrghz.crmapp.controller;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import mrghz.crmapp.controller.CustomerController;
import mrghz.crmapp.service.CustomerService;

@ExtendWith(MockitoExtension.class)
class CustomerControllerTest {

	@Mock
	CustomerService customerServicelMock;

	@InjectMocks
	CustomerController theController;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testListCustomers() {
		fail("Not yet implemented");
	}

	@Test
	void testShowFormForAdd() {
		fail("Not yet implemented");
	}

	@Test
	void testShowFormForUpdate() {
		fail("Not yet implemented");
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	void testSaveCustomer() {
		fail("Not yet implemented");
	}

}
