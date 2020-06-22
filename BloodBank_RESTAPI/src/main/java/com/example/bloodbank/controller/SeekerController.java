package com.example.bloodbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.bloodbank.model.Seeker;
import com.example.bloodbank.services.SeekerService;


@RestController
public class SeekerController {

	@Autowired
	SeekerService seekerService;
	
	@ResponseBody
	@RequestMapping("/api/seek/")
	public String home()
	{
		return "Create a Seeker Web service";
	}
	
	@RequestMapping(value = "/api/seeker/{sekId}", method = RequestMethod.GET)
    Seeker getSeeker(@PathVariable("sekId") int sekId) throws Exception {
        return seekerService.getSeeker(sekId);
    }
	
	@RequestMapping(value = "/api/seekers", method = RequestMethod.GET)
    Iterable<Seeker> getSeekers() {
        return seekerService.getSeekers();
    }

	@RequestMapping(value = "/api/seeker", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    void addSeeker(@RequestBody Seeker sek) throws Exception {
        seekerService.addSeeker(sek);
    }

    @RequestMapping(value = "/api/seeker/{sekId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    void updateSeeker(@PathVariable("sekId") int sekId, @RequestBody Seeker sek) throws Exception {
        sek.setSeekerId(sekId);
       seekerService.updateSeeker(sek);
    }
    
    @RequestMapping(value = "/api/seeker/{sekId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    void deleteSeeker(@PathVariable("sekId") int sekId) throws Exception {
        seekerService.deleteSeeker(sekId);
    }
	


}

