package com.example.java;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

public class CustomerController {

	@Autowired
	CustomerRepository customerRepository;
	
	String[] customerLanguageList = {"English","French","Punjabi","Hindi"};
	String[] customerGenreList = {"Action","Drama","Romance","Horror","Comedy"};

	@RequestMapping("/")
	public ModelAndView home() {
		return index();
	}

	@GetMapping(value = { "/", "/index" })
	public ModelAndView index() {
		List<Customer> customers = customerRepository.findAll();
		ModelAndView model = new ModelAndView();
		model.addObject("customers", customers);
		model.addObject("title", "Home-Page");
		model.setViewName("index");
		return model;
	}

	@GetMapping("customers/{id}")
	public String getCustomer(@PathVariable("id") int customerId, Model model) {
		Customer customer = customerRepository.getOne(customerId);
		if (customer != null) {
			model.addAttribute("customer", customer);
			model.addAttribute("customerId", customerId);
			return "customer-details";
		} else {
			return "error";
		}
	}

	@GetMapping(value = "/addCustomerForm")
	public String addCustomerForm(Customer customer,Model model) {
		model.addAttribute("customer", new Customer());
		model.addAttribute("genreList", customerGenreList);
		model.addAttribute("languageList", customerLanguageList);
		model.addAttribute("title", "Add-Customer");
		return "add-customer";
	}

	@PostMapping(value = "/addCustomer")
	public ModelAndView addCustomer(@Valid Customer customer, BindingResult result, ModelAndView model) {
		if (result.hasErrors()) {
			model.addObject("customer",customer);
			model.setViewName("add-customer");
			return model;
		}
		try {
			customerRepository.save(customer);
			return index();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			String messageString = e.getMessage();
			model.addObject("message", messageString);
			model.setViewName("add-customer");
			return model;
		}
	}

	@GetMapping("/update/{id}")
	public String updateCustomerPage(@PathVariable("id") int customerId, Model model) {

		model.addAttribute("customer", customerRepository.getOne(customerId));
		model.addAttribute("customerId", customerId);
		model.addAttribute("title", "Update Customer");
		return "update-customer";
	}

	@RequestMapping(value = "/updateCustomer/{id}", consumes = "application/x-www-form-urlencoded", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public ModelAndView updateCustomer(@PathVariable("id") int customerId,@Valid @ModelAttribute("customer") Customer customer,
			 BindingResult result, Model model) throws Exception {
		if (result.hasErrors()) {
			return index();
		}
		customer.setCustId(customerId);
		customerRepository.save(customer);

		return index();
	}

	@GetMapping(value = "/delete/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public ModelAndView deleteCustomer(@PathVariable("id") int customerId) throws Exception {
		customerRepository.deleteById(customerId);
		return index();
	}
}
