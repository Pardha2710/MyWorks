package com.example.bloodbank;

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
public class BloodBankController {
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
	@Autowired 
	private BloodBankRepository bbRepository;
	
	@ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home()
    {
        return new ModelAndView("index","list",bbRepository.findAll());
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model)
    {
        BloodBank bloodBank = new BloodBank();
        model.addAttribute("bloodBank", bloodBank);
        return "insert";
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute @Valid BloodBank bloodBank, BindingResult bindingResult, Model model)
    {
    	if (bindingResult.hasErrors()) {
            System.out.println("BINDING RESULT ERROR");
            return "insert";
        } else {
        bbRepository.save(bloodBank);
        model.addAttribute("list", bbRepository.findAll());
        return "index";
        }
    }
    
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable int id)
    {
    	BloodBank obj = null;
    	for(BloodBank temp : bbRepository.findAll()) {
    		if(temp.getBbId() == id) {
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
    public ModelAndView edit(@ModelAttribute BloodBank bloodBank)
    {
    	bbRepository.deleteById(bloodBank.getBbId());
    	bbRepository.save(bloodBank);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        mv.addObject("list",bbRepository.findAll());
        return mv;
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable int id)
    {
    	BloodBank obj = null;
    	for(BloodBank temp : bbRepository.findAll()) {
    		if(temp.getBbId() == id) {
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
    public ModelAndView delete(@ModelAttribute BloodBank bloodBank)
    {
    	bbRepository.delete(bloodBank);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        mv.addObject("list",bbRepository.findAll());
        return mv;
    }
}
