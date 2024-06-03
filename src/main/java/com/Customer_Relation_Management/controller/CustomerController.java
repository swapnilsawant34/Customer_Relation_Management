package com.Customer_Relation_Management.controller;

import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Customer_Relation_Management.entity.Customer;
import com.Customer_Relation_Management.service.CustomerService;


@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	//@Autowired
	CustomerService  customerService;

	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	//API:1-insert customers details
	@PostMapping("/insert")
	public String insertCustomer(@RequestBody Customer customer )
	{
		String msg = customerService.insertCustomer(customer);
		
		return msg;
	}
	
	//API:2-fetch/get customer details
	@GetMapping("/fetch")
	public List<Customer> getCustomersList()
	{
		List<Customer> list = customerService.getCustomersList();
		
		return list;
		
	}
	
	//API:3-fetch by id
	@GetMapping("/{id}")
	public Customer getCustomerById(@PathVariable int id)
	{
		Customer customerById = customerService.getCustomerById(id);
		
		return  customerById;
	}
	
	//API:4-update
	@PutMapping("/update")
	public String customerUpdate(@RequestBody Customer customer)
	{
		String msg = customerService.updateCustomer(customer);
		
		return msg;
	}
	
	//API:5-delete by id
	@DeleteMapping("/{id}")
	public String CustomerDeleteById( @PathVariable int id)
	{
		String deleteCustomerById = customerService.deleteCustomerById(id);
		
		return deleteCustomerById;
	}
	
	//API:6-insert multiple customers
	@PostMapping("/multiple-insert")
	public String insertMultipleCustomers(@RequestBody List<Customer> customers)
	{
		String msg = customerService.insertMultipleCustomer(customers);
		
		return msg;
		
	}
	//API:7-Search/fetch by Customer Name.
	@GetMapping("/byfirstname/{firstName}")
	public List<Customer> getCustomersByFirstName(@PathVariable String firstName)
	{
		List<Customer> customersByFirstName = customerService.getCustomersByFirstName(firstName);
		
		return customersByFirstName;
	}
	
	//API:8-fetch data age using less than age condition.
	@GetMapping("/bylessthanage/{age}")
	public List<Customer> getCustomersByLessThanAge(@PathVariable int age)
	{
		List<Customer> customersByLessThanAge = customerService.getCustomersByLessThanAge(age);
		
		return customersByLessThanAge;
	}
	
	//API:9-fetch data age using greater than age condition.
	@GetMapping("/bygreaterthanage/{age}")
	public List<Customer> getCustomersByGreaterThanAge(@PathVariable int age)
	{
		List<Customer> customersByGreaterThanAge = customerService.getCustomersByGreaterThanAge(age);
		
		return customersByGreaterThanAge;
	}
	
	//API:10-fetch customers details by age
	@GetMapping("/byage/{age}")
	public List<Customer> getCustomersByAge(@PathVariable int age)
	{
		List<Customer> customersByAge = customerService.getCustomersByAge(age);
		
		return customersByAge;
		
	}
	
	//API:11-fetch customers details by last name
		@GetMapping("/bylastname/{lastName}")
		public List<Customer> getCustomersByLastName(@PathVariable String lastName)
		{
	           List<Customer> customersByLastName = customerService.getCustomersByLastName(lastName);
			
			return customersByLastName;
		}
	
		
				
	
	//API:12-fetch customers details by email
	@GetMapping("/byemail/{email}")
	public List<Customer> getCustomersByEmail(@PathVariable String email)
	{
          List<Customer> customersByEmail = customerService.getCustomersByEmail(email);
		
		return customersByEmail;
	}
	
	
	
	//API:13-fetch customers details by mobile number
	@GetMapping("/bymobileno/{mobileNumber}")
	public List<Customer> getCustomersByMobileNumber(@PathVariable String mobileNumber)
	{
		 List<Customer> customersByMobileNumber = customerService.getCustomersByMobileNumber(mobileNumber);
		
		return customersByMobileNumber;
		
	}
	
	//API:14-update customer details by first name
		@PutMapping("/updatefirstname/{id}")
	       public String updateFirstName(@PathVariable int id,@RequestBody Map<String ,String> request) {

		String firstName=request.get("firstName");
		return customerService.updateFirstName(id, firstName);
	     }
		
		
		
		//API:15-update customer details by last name
		@PutMapping("/updatelastname/{id}")
	       public String updateLastName(@PathVariable int id,@RequestBody Map<String ,String> request) {

		String lastName=request.get("lastName");
		return customerService.updateLastName(id, lastName);
	     }
		
	

			// API:16-update customer details by mail id
			@PutMapping("/updateemail/{id}")
			public String updateEmailId(@PathVariable int id, @RequestBody Map<String, String> request) {

				String email = request.get("email");
				return customerService.updateEmailId(id, email);
			}
			
			
			// API:17-update customer details by mobile number.
			@PutMapping("/updatemobileno/{id}")
			public String updateMobileNumber(@PathVariable int id, @RequestBody Map<String, String> request) {

				String mobileNumber = request.get("mobileNumber");
				return customerService.updateMobileNumber(id, mobileNumber);
			}			
						
						
	  
			// API:18-update customer details by age.
			@PutMapping("/updateage/{id}")
			public String updateAge(@PathVariable int id, @RequestBody Map<String, Integer> request) {

				int age = request.get("age");
				return customerService.updateAge(id, age);
			}						
							
}



