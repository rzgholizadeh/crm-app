package com.mrghz.crmapp.entity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mrghz.crmapp.entity.Customer;

class CustomerTest {

	Customer theCustomer;

	@BeforeEach
	void setUp() throws Exception {
		theCustomer = new Customer(1, "testFirstName", "testLastName", "testEmail");
	}

	@Test
	void test() {
		assertThat(theCustomer.getFirstName()).isEqualTo("testFirstName");
		assertThat(theCustomer.getLastName()).isEqualTo("testLastName");
		assertThat(theCustomer.getEmail()).isEqualTo("testEmail");
	}

}
