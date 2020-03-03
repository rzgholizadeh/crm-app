package com.mrghz.crmapp.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import mrghz.crmapp.controller.CustomerController;
import mrghz.crmapp.entity.Customer;
import mrghz.crmapp.service.CustomerService;

@ExtendWith(MockitoExtension.class)
@DisplayName("Customer Controller Test - ")
class CustomerControllerTest {

	private static final String CUSTOMERS_CUSTOMER_FORM = "customers/customer-form";
	private static final String CUSTOMERS_LIST_CUSTOMERS = "customers/list-customers";
	private static final String REDIRECT_CUSTOMERS_LIST = "redirect:/customers/list";

	@Mock
	CustomerService customerServicelMock;

	@Mock
	Model modelMock;

	@InjectMocks
	CustomerController theController;

	MockMvc mockMvc;

	@BeforeEach
	void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(theController).build();
	}

	@DisplayName("listCustomers()")
	@Test
	void testListCustomers() throws Exception {
		// when
		String viewName = theController.listCustomers(modelMock);
		// then
		then(customerServicelMock).should().findAll();
		then(modelMock).should().addAttribute(anyString(), anyList());
		assertThat(viewName).isEqualTo(CUSTOMERS_LIST_CUSTOMERS);

		// Using Spring MVC stand-alone
		mockMvc.perform(get("/customers/list")).andExpect(status().isOk())
				.andExpect(model().attributeExists("customers"))
				.andExpect(view().name("customers/list-customers"));

	}

	@DisplayName("showFormForAdd()")
	@Test
	void testShowFormForAdd() throws Exception {
		// when
		String viewName = theController.showFormForAdd(modelMock);
		// then
		then(modelMock).should().addAttribute(anyString(), any());
		assertThat(viewName).isEqualTo(CUSTOMERS_CUSTOMER_FORM);

		// Using Spring MVC stand-alone
		mockMvc.perform(get("/customers/showFormForAdd")).andExpect(status().isOk())
				.andExpect(model().attributeExists("customer"))
				.andExpect(view().name("customers/customer-form"));
	}

	@DisplayName("showFormForUpdate()")
	@Test
	void testShowFormForUpdate() throws Exception {
		// when
		String viewName = theController.showFormForUpdate(1, modelMock);
		// then
		then(customerServicelMock).should().findById(1);
		then(modelMock).should().addAttribute(anyString(), any());
		assertThat(viewName).isEqualTo(CUSTOMERS_CUSTOMER_FORM);

		// Using Spring MVC stand-alone
		mockMvc.perform(get("/customers/showFormForUpdate")).andExpect(status().isOk())
				.andExpect(model().attributeExists("customer"))
				.andExpect(view().name("customers/customer-form"));
	}

	@DisplayName("delete()")
	@Test
	void testDelete() throws Exception {
		// when
		String viewName = theController.delete(1);
		// then
		assertThat(viewName).isEqualToIgnoringCase(REDIRECT_CUSTOMERS_LIST);
	}

	@DisplayName("saveCustomer()")
	@Test
	void testSaveCustomer() {
		// when
		String viewName = theController.saveCustomer(new Customer());
		// then
		assertThat(viewName).isEqualToIgnoringCase(REDIRECT_CUSTOMERS_LIST);
	}

}
