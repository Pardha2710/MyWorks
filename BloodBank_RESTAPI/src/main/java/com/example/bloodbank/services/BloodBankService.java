package com.example.bloodbank.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.bloodbank.model.BloodBank;


@Service
public class BloodBankService {

	
Map<Integer, BloodBank> bloodBank=new HashMap<Integer, BloodBank>();
	
	public void addBloodBank(BloodBank bank) throws Exception {
        if(bloodBank.containsKey(bank.getBloodBanbkId())) 
        {
            throw new Exception("BloodBank Id already exists");
        }
        else {
        	bloodBank.put(bank.getBloodBanbkId(), bank);
        }
    }
	public Iterable<BloodBank> getBloodBanks(){
        return bloodBank.values();
    }
	
	public BloodBank getBloodBank(int bankId) throws Exception {

        if(bloodBank.containsKey(bankId)) {
            return bloodBank.get(bankId);
        }
        else {
            throw new Exception("BloodBank Id not found");
        }
    }
	public void updateBloodBank(BloodBank bank) throws Exception {
        if(bloodBank.containsKey(bank.getBloodBanbkId())) {
            bloodBank.put(bank.getBloodBanbkId(), bank);
        }
        else {
            throw new Exception("BloodBank Id not found");
        }
    }
 public void deleteBloodBank(int bankId) throws Exception {
        if(bloodBank.containsKey(bankId)) {
            bloodBank.remove(bankId);
        }
        else {
            throw new Exception("BloodBank Id not found");
        }
    }
}

