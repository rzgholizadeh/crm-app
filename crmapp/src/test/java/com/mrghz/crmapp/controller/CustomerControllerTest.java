package com.mrghz.crmapp.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

import mrghz.crmapp.controller.CustomerController;
import mrghz.crmapp.entity.Customer;
import mrghz.crmapp.service.CustomerService;

@ExtendWith(MockitoExtension.class)
@DisplayName("Customer Controller Test - ")
class CustomerControllerTest {

	private static final String REDIRECT_CUSTOMERS_LIST = "redirect:/customers/list";

	@Mock
	CustomerService customerServicelMock;

	@InjectMocks
	CustomerController theController;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testListCustomers() {
	}

	@Test
	void testShowFormForAdd() {
	}

	@Test
	void testShowFormForUpdate() {
	}

	@Test
	void testDelete() {
		// when
		String viewName = theController.delete(1);
		// then
		assertThat(viewName).isEqualToIgnoringCase(REDIRECT_CUSTOMERS_LIST);
	}

	@Test
	void testSaveCustomer() {
		// when
		String viewName = theController.saveCustomer(new Customer());
		// then
		assertThat(viewName).isEqualToIgnoringCase(REDIRECT_CUSTOMERS_LIST);
	}

}
