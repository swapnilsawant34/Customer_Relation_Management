package com.Customer_Relation_Management.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Customer_Relation_Management.entity.Customer;

@Repository
public class CustomerDao {
	
	//@Autowired  //we can use autowired or constructor injection
	
	SessionFactory sf;
    
	//constructor injection
	public CustomerDao(SessionFactory sf) {
		super();
		this.sf = sf;
	}
	
	//API-1:insert
	public String insertCustomer(Customer customer) {
		
		Session session = sf.openSession();
		//for insert,update,delete-->you need use Transaction
		
		Transaction tr = session.beginTransaction();
		session.save(customer); //save method:-insert data
		tr.commit();
		session.close();
		
		
		return "Customer's Information is insert Succesfully";
		
	}
	
	//API-2:fetch data
	
	public List<Customer> getCustomersList()
	{
		Session session = sf.openSession();
		
		//Transaction tr = session.beginTransaction();
		
		return session.createQuery("from Customer").list();
		
		
	}
	
	
	//API-3:fetch data by using id.(Customer id)
	public Customer getCustomerById(int id)
	{
        Session session = sf.openSession();
		
        Customer customer = session.get(Customer.class, id);    //or Customer customer = session.load(Customer.class, id);
        
        
        return customer;
		
        /*
         * Difference between get and load method
         * get-->It will return null if object not found in database.
         * load-->It will return objectNotfoundException if object not found in database.
         */
		
	}
	
	//API-4:update data
	public String updateCustomer(Customer customer)
	{
		  Session session = sf.openSession();
		  
		  Transaction tr = session.beginTransaction();
		  
		  session.update(customer);   //call update method
		  
		  tr.commit();
		  session.close();
		  
		  return "Customer's Information is updated Succesfully";
		  
	}
	
	//API-5:delete data
	
	public String deleteCustomerById(int id)
	{
		  Session session = sf.openSession();
		  
		  Transaction tr = session.beginTransaction();
		  
		  Customer customer = session.get(Customer.class, id);
		  session.delete(customer);
		  
		  tr.commit();
		  session.close();
		  
		  return "Customer's Information is deleted Succesfully";
		  
	}
	
	    //API-6:Insert multiple customer
       public String insertMultipleCustomer(List<Customer> customers) 
       {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		//to insert multiple data need use for each loop to iterate the data from List
		for(Customer customer:customers)
		{
			session.save(customer);
			
		}
		
		
		tr.commit();
		session.close();
		
		
		return "Customer's Information are inserted Succesfully";
		
	  }
	
     
     //API-7:Search/fetch by name
       public List<Customer> getCustomersByFirstName(String firstName)
       {
    	   Session session = sf.openSession();
    	   String qry="from Customer c where c.firstName=:firstName"; 
    	 //this is HQL query ,here Customer is entity(pojo) class  and c is variable/reference/alises ,using that reference call firstName.
    	 
    	Query<Customer> customers=session.createQuery(qry,Customer.class);
    	//createQuery method return Query<Customer> which is belong to org.hibernate.query.Query package.  
    	customers.setParameter("firstName", firstName);
    	List<Customer> list= customers.list();  //here list() method  List<Customer> which is belong to org.hibernate package                  
    	                     
		return list;
		
		/*   
		 * customers.setParameter("firstName", firstName);
		 *                             |          |
		 *                             |          |
		 *                             |         \|/          
		 *                             |         this variable name from above method i.e-getCustomersByFirstName(String firstName) method
		 *                             |
		 *                            \|/
		 *        this is column name from database table     
		 * 
		 */
    	   
       }
       
      //API-8 :fetch/get customers by less than age(for e.g.fetch customers < 30...like that) 
       
       public List<Customer> getCustomersByLessThanAge(int age)
       {
    	   Session session = sf.openSession();
    	   String qry="from Customer c where c.age<:age"; 
    	   
    		Query<Customer> customers=session.createQuery(qry,Customer.class);
    		customers.setParameter("age", age);
    		
    		List<Customer> list= customers.list();
    		
    		return list;
       }
     //API-9 :fetch/get customers by less than age(for e.g.fetch customers > 30...like that)  
       public List<Customer> getCustomersByGreaterThanAge(int age)
       {
    	   Session session = sf.openSession();
    	   String qry="from Customer c where c.age>:age"; 
    	   
    		Query<Customer> customers=session.createQuery(qry,Customer.class);
    		customers.setParameter("age", age);
    		
    		List<Customer> list= customers.list();
    		
    		return list;
       }
       
       
       //API-10:fetch/get customer by age
       public List<Customer> getCustomersByAge(int age)
       {
    	     Session session = sf.openSession();
    	     String qry="from Customer c where c.age=:age"; 
    	     Query<Customer> customers=session.createQuery(qry,Customer.class); 
    	   
    	     customers.setParameter("age", age);
   		
   		    List<Customer> list= customers.list();
   		
   		return list;
       }
       
      //API-11
       public List<Customer> getCustomersByLastName(String lastName)
       {
    	   Session session = sf.openSession();
    	   String qry="from Customer c where c.lastName=:lastName"; 
  	     Query<Customer> customers=session.createQuery(qry,Customer.class); 
  	   
  	     customers.setParameter("lastName", lastName);
 		
 		    List<Customer> list= customers.list();
 		
 		return list;
       }
       
       //API-12
       public List<Customer> getCustomersByEmail(String email)
       {
    	   Session session = sf.openSession();
    	   String qry="from Customer c where c.email=:email"; 
  	     Query<Customer> customers=session.createQuery(qry,Customer.class); 
  	   
  	     customers.setParameter("email", email);
 		
 		    List<Customer> list= customers.list();
 		
 		return list;
       }
       //API-13
       public List<Customer> getCustomersByMobileNumber(String mobileNumber)
       {
    	   Session session = sf.openSession();
    	   String qry="from Customer c where c.mobileNumber=:mobileNumber"; 
  	     Query<Customer> customers=session.createQuery(qry,Customer.class); 
  	   
  	     customers.setParameter("mobileNumber", mobileNumber);
 		
 		    List<Customer> list= customers.list();
 		
 		return list;
       }
       
       
       //API-14
       public String updateFirstName(int id,String firstName)
       {
    	   Session session = sf.openSession();
    	   Transaction tr = session.beginTransaction();
    	   Customer customer = session.get(Customer.class, id);
    	   customer.setFirstName(firstName);
    	   tr.commit();
    	   session.close();
    	   
    	   return "Customer's First Name is updated Succesfully";
    	   
       }
       
       //API-15
       public String updateLastName(int id,String lastName)
       {
    	   Session session = sf.openSession();
    	   Transaction tr = session.beginTransaction();
    	   Customer customer = session.get(Customer.class, id);
    	   customer.setLastName(lastName);
    	   tr.commit();
    	   session.close();
    	   
    	   return "Customer's Last Name is updated Succesfully";
    	   
       }
       
       public String updateEmailId(int id,String email)
       {
    	   Session session = sf.openSession();
    	   Transaction tr = session.beginTransaction();
    	   Customer customer = session.get(Customer.class, id);
    	   customer.setEmail(email);
    	   tr.commit();
    	   session.close();
    	   
    	   return "Customer's Email is updated Succesfully";
    	   
       }
       
       public String updateMobileNumber(int id,String mobileNumber)
       {
    	   Session session = sf.openSession();
    	   Transaction tr = session.beginTransaction();
    	   Customer customer = session.get(Customer.class, id);
    	   customer.setMobileNumber(mobileNumber);
    	   tr.commit();
    	   session.close();
    	   
    	   return "Customer's Mobile Number is updated Succesfully"; 
    	   
    	   
       }
}
