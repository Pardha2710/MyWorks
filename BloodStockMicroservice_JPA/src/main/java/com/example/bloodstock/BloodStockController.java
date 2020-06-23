package com.example.bloodstock;

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
public class BloodStockController {
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
	@Autowired 
	private BloodStockRepository bsRepository;
	
	@ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home()
    {
        return new ModelAndView("index","list",bsRepository.findAll());
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model)
    {
        BloodStock bloodStock = new BloodStock();
        model.addAttribute("bloodStock", bloodStock);
        return "insert";
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute @Valid BloodStock bloodStock, BindingResult bindingResult, Model model)
    {
    	if (bindingResult.hasErrors()) {
            System.out.println("BINDING RESULT ERROR");
            return "insert";
        } else {
        bsRepository.save(bloodStock);
        model.addAttribute("list", bsRepository.findAll());
        return "index";
        }
    }
    
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable int id)
    {
    	BloodStock obj = null;
    	for(BloodStock temp : bsRepository.findAll()) {
    		if(temp.getBsId() == id) {
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
    public ModelAndView edit(@ModelAttribute BloodStock bloodStock)
    {
    	bsRepository.deleteById(bloodStock.getBsId());
    	bsRepository.save(bloodStock);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        mv.addObject("list",bsRepository.findAll());
        return mv;
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable int id)
    {
    	BloodStock obj = null;
    	for(BloodStock temp : bsRepository.findAll()) {
    		if(temp.getBsId() == id) {
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
    public ModelAndView delete(@ModelAttribute BloodStock bloodStock)
    {
    	bsRepository.delete(bloodStock);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        mv.addObject("list",bsRepository.findAll());
        return mv;
    }
}
