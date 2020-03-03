package com.mrghz.crmapp.controller;

import static org.mockito.Mockito.reset;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import mrghz.crmapp.controller.CustomerController;
import mrghz.crmapp.service.CustomerService;

@WebMvcTest(CustomerController.class)
@DisplayName("Customer Controller Test - ")
class CustomerControllerSpringMVCTest {

	@MockBean
	CustomerService customerServicelMock;

	@Autowired
	MockMvc mockMvc;

	@BeforeEach
	void setup() {
	}

	@AfterEach
	void tearDown() {
		reset(customerServicelMock);
	}

	@DisplayName("listCustomers()")
	@Test
	void testListCustomers() throws Exception {
		// Using Spring MVC stand-alone
		mockMvc.perform(get("/customers/list")).andExpect(status().isOk())
				.andExpect(model().attributeExists("customers"))
				.andExpect(view().name("customers/list-customers"));

	}

	@DisplayName("showFormForAdd()")
	@Test
	void testShowFormForAdd() throws Exception {
		// Using Spring MVC stand-alone
		mockMvc.perform(get("/customers/showFormForAdd")).andExpect(status().isOk())
				.andExpect(model().attributeExists("customer"))
				.andExpect(view().name("customers/customer-form"));
	}

	@DisplayName("showFormForUpdate()")
	@Test
	void testShowFormForUpdate() throws Exception {
		// Using Spring MVC stand-alone
		mockMvc.perform(get("/customers/showFormForUpdate")).andExpect(status().isOk())
				.andExpect(model().attributeExists("customer"))
				.andExpect(view().name("customers/customer-form"));
	}

	@DisplayName("delete()")
	@Test
	void testDelete() throws Exception {
	}

	@DisplayName("saveCustomer()")
	@Test
	void testSaveCustomer() {
	}

}
