package com.example.bloodbank.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.bloodbank.model.BloodStock;


@Service
public class BloodStockService {

	
Map<Integer, BloodStock> bloodStock = new HashMap<>();
	
	public void addBloodStock(BloodStock stock) throws Exception {
        if(bloodStock.containsKey(stock.getBloodStockId())) {
            throw new Exception("BloodStock Id already exists");
        }
        else {
            bloodStock.put(stock.getBloodStockId(), stock);
        }
    }

    public Iterable<BloodStock> getBloodStocks(){
        return bloodStock.values();
    }

    public BloodStock getBloodStock(int stockId) throws Exception {

        if(bloodStock.containsKey(stockId)) {
            return bloodStock.get(stockId);
        }
        else {
            throw new Exception("BloodStock Id not found");
        }
    }

    public void updateBloodStock(BloodStock stock) throws Exception {
        if(bloodStock.containsKey(stock.getBloodStockId())) {
            bloodStock.put(stock.getBloodStockId(), stock);
        }
        else {
            throw new Exception("BloodStock Id not found");
        }
    }


    public void deleteBloodStock(int stockId) throws Exception {
        if(bloodStock.containsKey(stockId)) {
            bloodStock.remove(stockId);
        }
        else {
            throw new Exception("BloodStock Id not found");
        }
    }
}



