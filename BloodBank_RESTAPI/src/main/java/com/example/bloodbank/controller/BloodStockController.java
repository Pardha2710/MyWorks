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

import com.example.bloodbank.model.BloodStock;
import com.example.bloodbank.services.BloodStockService;

@RestController
public class BloodStockController {

	
	@Autowired
	BloodStockService bloodService;
	
	@ResponseBody
	@RequestMapping("/api/stock/")
	public String home()
	{
		return "Create a BloodStock Web service";
	}	
	@RequestMapping(value = "/api/bloodstock/{stockId}", method = RequestMethod.GET)
    BloodStock getBloodStock(@PathVariable("stockId") int stockId) throws Exception {
        return bloodService.getBloodStock(stockId);
    }


	@RequestMapping(value = "/api/bloodstocks", method = RequestMethod.GET)
    Iterable<BloodStock> getBloodStocks() {
        return bloodService.getBloodStocks();
    }

	@RequestMapping(value = "/api/bloodstock", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    void addBloodStock(@RequestBody BloodStock stock) throws Exception {
        bloodService.addBloodStock(stock);
    }

    @RequestMapping(value = "/api/bloodstock/{stockId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    void updateBloodStock(@PathVariable("stockId") int stockId, @RequestBody BloodStock stock) throws Exception {
        stock.setBloodStockId(stockId);
        bloodService.updateBloodStock(stock);
    }
    
    @RequestMapping(value = "/api/bloodstock/{stockId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    void deleteBloodStock(@PathVariable("stockId") int stockId) throws Exception {
        bloodService.deleteBloodStock(stockId);
    }
	


}

