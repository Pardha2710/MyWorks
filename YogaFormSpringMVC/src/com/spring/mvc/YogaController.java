package com.spring.mvc;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class YogaController {
	
	@RequestMapping(value="/register",method = RequestMethod.POST)
	public String save(@ModelAttribute("yoga") YogaBean yoga,Model m){ 
		 ArrayList<YogaBean> al1 =new ArrayList<>();
		 al1.add(yoga);
		 m.addAttribute("list",al1);
	        return "view_details";    
	    }    

	

}
