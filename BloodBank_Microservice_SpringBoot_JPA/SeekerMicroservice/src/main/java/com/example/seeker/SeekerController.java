package com.example.seeker;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SeekerController {

	 @InitBinder
	    public void initBinder(WebDataBinder binder) {
	        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	    }
		@Autowired 
		private SeekerRepository spRepository;
		
		@ResponseBody
	    @RequestMapping(value = "/", method = RequestMethod.GET)
	    public ModelAndView home()
	    {
	        return new ModelAndView("index","sekpa_list",spRepository.findAll());
	    }
		
	    @RequestMapping(value = "/add", method = RequestMethod.GET)
	    public String add(Model model)
	    {
	        Seeker sekpa = new Seeker();
	        model.addAttribute("seeker", sekpa);
	        return "insert";
	    }
	    
	    @RequestMapping(value = "/add", method = RequestMethod.POST)
	    public String add(@ModelAttribute @Valid Seeker seeker, BindingResult bindingResult, Model model)
	    {
	    	if (bindingResult.hasErrors()) {
	            System.out.println("BINDING RESULT ERROR");
	            
	            return "insert";
	        } else {
	        spRepository.save(seeker);
	        model.addAttribute("sekpa_list", spRepository.findAll());
	        return "index";
	        }
	    }
	    
	    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	    public ModelAndView edit(@PathVariable int id)
	    {
	    	Seeker obj = null;
	    	for(Seeker temp : spRepository.findAll()) {
	    		if(temp.getSpId() == id) {
	    			System.out.println("Object matched");
	    			obj = temp;
	    		}
	    	}
	        ModelAndView mv = new ModelAndView();
	        mv.setViewName("edit");
			mv.addObject("obj",obj);
	        return mv;
	    }
	    
	    @RequestMapping(value = "/edit/edit", method = RequestMethod.POST)
	    public ModelAndView edit(@ModelAttribute Seeker seeker)
	    {
	    	spRepository.deleteById(seeker.getSpId());
	    	spRepository.save(seeker);
	        ModelAndView mv = new ModelAndView();
	        mv.setViewName("index");
	        mv.addObject("sekpa_list",spRepository.findAll());
	        return mv;
	    }
	    
	    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	    public ModelAndView delete(@PathVariable int id)
	    {
	    	Seeker obj = null;
	    	for(Seeker temp : spRepository.findAll()) {
	    		if(temp.getSpId() == id) {
	    			System.out.println("Object matched");
	    			obj = temp;
	    		}
	    	}
	        ModelAndView mv = new ModelAndView();
	        mv.setViewName("delete");
	        mv.addObject("obj",obj);
	        return mv;
	    }
	    
	    @RequestMapping(value = "/delete/delete", method = RequestMethod.POST)
	    public ModelAndView delete(@ModelAttribute Seeker seeker)
	    {
	    	spRepository.delete(seeker);
	        ModelAndView mv = new ModelAndView();
	        mv.setViewName("index");
	        mv.addObject("sekpa_list",spRepository.findAll());
	        return mv;
	        
	    }
}
