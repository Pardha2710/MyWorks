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

import com.example.bloodbank.model.BloodBank;
import com.example.bloodbank.services.BloodBankService;


@RestController
public class BloodBankController {

	
	@Autowired
	BloodBankService bloodBankService;
	
	@ResponseBody
	@RequestMapping("/api/bank/")
	public String home()
	{
		return "Create a BloodBank Web service";
	}
	
	@RequestMapping(value = "/api/bloodbank/{bankId}", method = RequestMethod.GET)
    BloodBank getBloodBank(@PathVariable("bankId") int bankId) throws Exception {
        return bloodBankService.getBloodBank(bankId);
    }


	@RequestMapping(value = "/api/bloodbanks", method = RequestMethod.GET)
    Iterable<BloodBank> getBloodBanks() {
        return bloodBankService.getBloodBanks();
    }

	@RequestMapping(value = "/api/bloodbank", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    void addBloodBank(@RequestBody BloodBank bank) throws Exception {
        bloodBankService.addBloodBank(bank);
    }

    @RequestMapping(value = "/api/bloodbank/{bankId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    void updateBloodBank(@PathVariable("bankId") int bankId, @RequestBody BloodBank bank) throws Exception {
        bank.setBloodBanbkId(bankId);
        bloodBankService.updateBloodBank(bank);
    }
    
    @RequestMapping(value = "/api/bloodbank/{bankId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    void deleteBloodBank(@PathVariable("bankId") int bankId) throws Exception {
        bloodBankService.deleteBloodBank(bankId);
    }
	
	
	
}
