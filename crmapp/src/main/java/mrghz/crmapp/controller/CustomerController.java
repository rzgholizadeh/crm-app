package mrghz.crmapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mrghz.crmapp.entity.Customer;
import mrghz.crmapp.service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {

	private CustomerService customerService;

	@Autowired
	public CustomerController(CustomerService theCustomerService) {
		customerService = theCustomerService;
	}

	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		List<Customer> theCustomers = customerService.findAll();
		theModel.addAttribute("customers", theCustomers);
		return "customers/list-customers";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer);
		return "customers/customer-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {
		Customer theCustomer = customerService.findById(theId);
		theModel.addAttribute("customer", theCustomer);
		return "customers/customer-form";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("customerId") int theId) {
		customerService.deleteById(theId);
		return "redirect:/customers/list";
	}

	@PostMapping("/save")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		customerService.save(theCustomer);
		return "redirect:/customers/list";
	}

}
