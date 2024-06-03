package com.Customer_Relation_Management.service;

import java.util.List;

import com.Customer_Relation_Management.entity.Customer;

public interface CustomerService {
	
	public String insertCustomer(Customer customer);
	
	public List<Customer> getCustomersList();
	
	public Customer getCustomerById(int id);
	
	public String updateCustomer(Customer customer);
	
	public String deleteCustomerById(int id);
	
	 public String insertMultipleCustomer(List<Customer> customers);
	 
	 public List<Customer> getCustomersByFirstName(String firstName);
	 
	 public List<Customer> getCustomersByLessThanAge(int age);
	 
	 public List<Customer> getCustomersByGreaterThanAge(int age);
	 
	 public List<Customer> getCustomersByAge(int age);

	 public List<Customer> getCustomersByLastName(String lastName);
	 
	 public List<Customer> getCustomersByEmail(String email);
	 
	 public List<Customer> getCustomersByMobileNumber(String mobileNumber);
	 
	 public String updateFirstName(int id,String firstName);
	 
	 public String updateLastName(int id,String lastName);
	 
	 public String updateEmailId(int id,String email);
	 
	 public String updateMobileNumber(int id,String mobileNumber);
	 

}
