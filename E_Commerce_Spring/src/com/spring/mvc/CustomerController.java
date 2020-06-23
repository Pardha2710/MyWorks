package com.spring.mvc;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CustomerController {
	
	private static EntityManagerFactory factory;
	private static EntityManager em;
	public String user;
	public static int customerId;
	
	@RequestMapping("/login")
	public ModelAndView login(Model m,HttpServletRequest request,HttpServletResponse response)
	{
		factory = Persistence.createEntityManagerFactory("E_Commerce_Spring");
	    em = factory.createEntityManager();
	    try
	    {
			String userName=request.getParameter("username");
			String password=request.getParameter("password");
			 em.getTransaction().begin();
			 Query query1=em.createQuery("SELECT p from Products p");
			List<Products> productsList=query1.getResultList(); 
			Query query=em.createQuery("SELECT c From Customers c where c.userName='"+userName+"'AND c.password='"+password+"'");		
			Customers results=(Customers) query.getSingleResult();
			customerId =  results.getCustomerId();
			user=results.getUserName();
			
			
			 em.getTransaction().commit();
			 em.close();
			
			return new ModelAndView("product_order","productsList",productsList);	
	    }
	    catch(Exception e){
	    	return new ModelAndView("register_navi");
	    }
			
	}
	@RequestMapping(value="/add_customer",method = RequestMethod.POST)
	public ModelAndView add(@ModelAttribute("customers") Customers customers,Model m){
		factory = Persistence.createEntityManagerFactory("E_Commerce_Spring");
	    em = factory.createEntityManager();
		 ArrayList<Customers> al1 =new ArrayList<>();
		 al1.add(customers);
		 
		 em.getTransaction().begin();
		 m.addAttribute("list",al1);
		 em.persist(customers);
		 
		    em.getTransaction().commit();
		    em.close();
		return new ModelAndView("login");
	}
	
	@RequestMapping("/view_customer")
	public ModelAndView viewCustomers(Model m, HttpServletRequest request, HttpServletResponse response) {
		factory = Persistence.createEntityManagerFactory("E_Commerce_Spring");
		em = factory.createEntityManager();
		 em.getTransaction().begin(); 
		 
		
		Query query = em
				.createQuery("SELECT c From Customers c where c.customerId = '" + customerId + "'");
		Customers results = (Customers) query.getSingleResult();
		
		   em.getTransaction().commit();
		em.close();
		return new ModelAndView("view_details", "customers", results);
	}
	
	public static int customerIdData() 
	{
		return customerId;
	}
	
	@RequestMapping("/home")
	public ModelAndView logout()
	{
		return new ModelAndView("login");
	}
	
	@RequestMapping("/update")
	public ModelAndView updateCustomers(Model m, HttpServletRequest request, HttpServletResponse response) {
		factory = Persistence.createEntityManagerFactory("E_Commerce_Spring");
		em = factory.createEntityManager();
		 em.getTransaction().begin(); 
		Query query = em
				.createQuery("SELECT c From Customers c where c.userName = '" + user+ "'");
		Customers results = (Customers) query.getSingleResult();
		
		   em.getTransaction().commit();
		em.close();
		return new ModelAndView("update_user", "customers", results);
	}
	@RequestMapping(value="/update_customer",method = RequestMethod.POST)
	public ModelAndView updateCustomer(HttpServletRequest request, HttpServletResponse response){
		factory = Persistence.createEntityManagerFactory("E_Commerce_Spring");
	    em = factory.createEntityManager();
	    String userName=request.getParameter("userName");
	    String password=request.getParameter("password");
	    String firstName=request.getParameter("firstname");
	    String lastName=request.getParameter("lastname");
	    String address=request.getParameter("address");
	    String city=request.getParameter("city");
	    String postalCode=request.getParameter("postalCode");
		 em.getTransaction().begin();
		 Customers customers=em.find(Customers.class, customerId);
		 customers.setUserName(userName);
		 customers.setPassword(password);
		 customers.setFirstname(firstName);
		 customers.setLastname(lastName);
		 customers.setAddress(address);
		 customers.setCity(city);
		 customers.setPostalCode(postalCode);
		 em.persist(customers);em.getTransaction().commit();
		 Query query1=em.createQuery("SELECT c From Customers c where c.userName = '" + customerId + "'");
		 List<Customers> results = query1.getResultList();
		
			em.close();
			return new ModelAndView("user_success");
	}
}
