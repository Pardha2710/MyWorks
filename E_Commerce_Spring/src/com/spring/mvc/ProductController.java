package com.spring.mvc;

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
public class ProductController {

	private static EntityManagerFactory factory;
	private static EntityManager em;
	
	@RequestMapping(value="/product",method = RequestMethod.POST)
	public ModelAndView view(Model m,HttpServletRequest request,HttpServletResponse response){
		factory = Persistence.createEntityManagerFactory("E_Commerce_Spring");
	    em = factory.createEntityManager();
		 em.getTransaction().begin();
		 int productId=Integer.parseInt(request.getParameter("productId"));
		
		 Query query=em.createQuery("SELECT p from Products p where p.productId= '"+productId+"'");
		 
		 Products productList=(Products) query.getSingleResult();
		
		 em.getTransaction().commit();
		em.close();
		return new ModelAndView("payment","products",productList);
	}
	
	@RequestMapping("/back")
	public ModelAndView back() {
		
	return new ModelAndView("product_order");
	}
}
