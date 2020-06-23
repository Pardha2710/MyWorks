package com.spring.mvc;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrderController {

	CustomerController cc;
	private static EntityManagerFactory factory;
	private static EntityManager em;
	public static int orderId;
	
	@RequestMapping("/order")
	public ModelAndView place(HttpServletRequest request, HttpServletResponse response) {
		factory = Persistence.createEntityManagerFactory("E_Commerce_Spring");
		em = factory.createEntityManager();
		em.getTransaction().begin();
		Orders orders = new Orders();
		
		orders.setCustomerId(cc.customerIdData());
		
		
		orders.setProductId(Integer.parseInt(request.getParameter("productId")));
		
		
		LocalDateTime dateTime = LocalDateTime.now(); 
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		
		orders.setOrderDate(dateTime.format(formatter));
		
		
		orders.setStatus("Paid");
		
		
		orders.setAmountPaid(request.getParameter("amountPaid"));
		
		
		
		orders.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		
		
		orders.setCategory(request.getParameter("category"));
		
		
		em.persist(orders);
		em.getTransaction().commit();

		orderId=orders.getOrderId();
		
		
		em.close();

		return new ModelAndView("order_success");
	}
	
	@RequestMapping("/view_order")
	public ModelAndView viewOrders(Model m, HttpServletRequest request, HttpServletResponse response) {
		factory = Persistence.createEntityManagerFactory("E_Commerce_Spring");
		em = factory.createEntityManager();
		 em.getTransaction().begin(); 
		
		Query query = em
				.createQuery("SELECT o From Orders o where o.orderId = '" + orderId + "'");
		Orders results = (Orders) query.getSingleResult();
		
		   em.getTransaction().commit();
		em.close();
		return new ModelAndView("order_summary", "orders", results);
	}
	
	@RequestMapping("/cancel")
	public ModelAndView cancel(Model m, HttpServletRequest request, HttpServletResponse response)
	{
		factory = Persistence.createEntityManagerFactory("E_Commerce_Spring");
		em = factory.createEntityManager();
		 em.getTransaction().begin(); 
		
		Query query = em
				.createQuery("SELECT o From Orders o where o.orderId = '" + orderId + "'");
		Orders results = (Orders) query.getSingleResult();
		
		 String date1=results.getOrderDate();
		 SimpleDateFormat df2 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		 
		 LocalDateTime dateTime = LocalDateTime.now(); 
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
			String date2=dateTime.format(formatter);
			
			Date d1=null;
			Date d2=null;
			
		 try {
			 	d1=df2.parse(date1);
			 	d2=df2.parse(date2);
			 	
			 	long diff=d2.getTime()-d1.getTime();
			 	
			 	long diffHours = diff / (60 * 60 * 1000) % 24;
			 	if(diffHours<24)
			 	{
			 		Orders order=em.find(Orders.class, orderId);
			 		em.getTransaction().begin();
			 		em.remove(order);
			 		em.getTransaction().commit();
			 		return new ModelAndView("order_cancel");
			 	}
			 	
		 	}
		 catch (Exception ex ){
	          System.out.println(ex);
	       }  
		 em.getTransaction().commit();
		em.close();
		return new ModelAndView("order_summary");
	}
	@RequestMapping("/update_order")
	public ModelAndView updateCustomers(Model m, HttpServletRequest request, HttpServletResponse response) {
		factory = Persistence.createEntityManagerFactory("E_Commerce_Spring");
		em = factory.createEntityManager();
		 em.getTransaction().begin(); 
		Query query = em
				.createQuery("SELECT o From Orders o where o.orderId = '" + orderId+ "'");
		Orders results = (Orders) query.getSingleResult();
		
		   em.getTransaction().commit();
		em.close();
		return new ModelAndView("update_order", "orders", results);
	}
	@RequestMapping(value="/updateOrder",method = RequestMethod.POST)
	public ModelAndView updateOrder(HttpServletRequest request, HttpServletResponse response){
		factory = Persistence.createEntityManagerFactory("E_Commerce_Spring");
	    em = factory.createEntityManager();
	    
	    int quantity=Integer.parseInt(request.getParameter("quantity"));
	    String category=request.getParameter("category");
	    
		 em.getTransaction().begin();
		 Orders orders=em.find(Orders.class, orderId);
		 orders.setQuantity(quantity);
		 orders.setCategory(category);
		 em.persist(orders);em.getTransaction().commit();
		 Query query=em.createQuery("SELECT o From Orders o where o.orderId = '" + orderId + "'");
		 List<Orders> results = query.getResultList();
		
			em.close();
			return new ModelAndView("order_status");
	}
}
