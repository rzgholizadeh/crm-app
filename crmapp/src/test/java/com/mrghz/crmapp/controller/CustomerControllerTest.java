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
import org.springframework.ui.Model;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

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

	@DisplayName("listCustomers()")
	@Test
	void testListCustomers() {
		// when
		String viewName = theController.listCustomers(modelMock);
		// then
		then(customerServicelMock).should().findAll();
		then(modelMock).should().addAttribute(anyString(), anyList());
		assertThat(viewName).isEqualTo(CUSTOMERS_LIST_CUSTOMERS);
	}

	@DisplayName("showFormForAdd()")
	@Test
	void testShowFormForAdd() {
		// when
		String viewName = theController.showFormForAdd(modelMock);
		// then
		then(modelMock).should().addAttribute(anyString(), any());
		assertThat(viewName).isEqualTo(CUSTOMERS_CUSTOMER_FORM);
	}

	@DisplayName("showFormForUpdate()")
	@Test
	void testShowFormForUpdate() {
		// when
		String viewName = theController.showFormForUpdate(1, modelMock);
		// then
		then(customerServicelMock).should().findById(1);
		then(modelMock).should().addAttribute(anyString(),any());
		assertThat(viewName).isEqualTo(CUSTOMERS_CUSTOMER_FORM);
	}

	@DisplayName("delete()")
	@Test
	void testDelete() {
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
