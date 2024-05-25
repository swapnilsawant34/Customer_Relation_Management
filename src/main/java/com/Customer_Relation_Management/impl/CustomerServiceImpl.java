package com.Customer_Relation_Management.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Customer_Relation_Management.dao.CustomerDao;
import com.Customer_Relation_Management.entity.Customer;
import com.Customer_Relation_Management.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	
	CustomerDao customerDao; 
	
	//constructor injection
	public CustomerServiceImpl(CustomerDao customerDao) {
		super();
		this.customerDao = customerDao;
	}


	@Override
	public String insertCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
		String msg = customerDao.insertCustomer(customer);
		
		return msg;
		
		
		//return customerDao.insertCustomer(customer);
	}


	@Override
	public List<Customer> getCustomersList() {
		// TODO Auto-generated method stub
		
		List<Customer> list = customerDao.getCustomersList();
		
		return list;
	}


	@Override
	public Customer getCustomerById(int id) {
		
		Customer customerById = customerDao.getCustomerById(id);
		
		return customerById;
	}


	@Override
	public String updateCustomer(Customer customer) {
		
		String msg = customerDao.updateCustomer(customer);
		
		return msg;
	}


	@Override
	public String deleteCustomerById(int id) {
		String deleteCustomerById = customerDao.deleteCustomerById(id);
		
		return deleteCustomerById;
	}


	@Override
	public String insertMultipleCustomer(List<Customer> customers) {
		String msg = customerDao.insertMultipleCustomer(customers);
		
		return msg;
	}


	@Override
	public List<Customer> getCustomersByFirstName(String firstName) {
		List<Customer> customersByFirstName = customerDao.getCustomersByFirstName(firstName);
		return customersByFirstName;
	}


	@Override
	public List<Customer> getCustomersByLessThanAge(int age) {
		List<Customer> customersByLessThanAge = customerDao.getCustomersByLessThanAge(age);
		
		return customersByLessThanAge;
	}


	@Override
	public List<Customer> getCustomersByGreaterThanAge(int age) {
		
		List<Customer> customersByGreaterThanAge = customerDao.getCustomersByGreaterThanAge(age);
		
		return customersByGreaterThanAge;
		
	}


	@Override
	public List<Customer> getCustomersByAge(int age) {
		List<Customer> customersByAge = customerDao.getCustomersByAge(age);
		
		return customersByAge;
	}


	@Override
	public List<Customer> getCustomersByLastName(String lastName) {
		 List<Customer> customersByLastName = customerDao.getCustomersByLastName(lastName);
		
		return customersByLastName;
	}


	@Override
	public List<Customer> getCustomersByEmail(String email) {
		
		List<Customer> customersByEmail = customerDao.getCustomersByEmail(email);
		
		return customersByEmail;
	}


	@Override
	public List<Customer> getCustomersByMobileNumber(String mobileNumber) {
		List<Customer> customersByMobileNumber = customerDao.getCustomersByMobileNumber(mobileNumber);
		
		return customersByMobileNumber;
	}
	
	
	

}
