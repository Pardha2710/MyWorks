package com.example.bloodbank.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.bloodbank.model.Seeker;


@Service
public class SeekerService {
	
	Map<Integer, Seeker> seeker = new HashMap<>();

	 public void addSeeker(Seeker sek) throws Exception {
	        if(seeker.containsKey(sek.getSeekerId())) 
	        {
	            throw new Exception("Seeker Id already exists");
	        }
	        else {
	            seeker.put(sek.getSeekerId(), sek);
	        }
	    }

	 public Iterable<Seeker> getSeekers(){
	        return seeker.values();
	    }
	 
	 public Seeker getSeeker(int sekId) throws Exception {

	        if(seeker.containsKey(sekId)) {
	            return seeker.get(sekId);
	        }
	        else {
	            throw new Exception("Seeker Id not found");
	        }
	    }
	 public void updateSeeker(Seeker sek) throws Exception {
	        if(seeker.containsKey(sek.getSeekerId())) {
	            seeker.put(sek.getSeekerId(), sek);
	        }
	        else {
	            throw new Exception("Seeker Id not found");
	        }
	    }
	 public void deleteSeeker(int sekId) throws Exception {
	        if(seeker.containsKey(sekId)) {
	            seeker.remove(sekId);
	        }
	        else {
	            throw new Exception("Seeker Id not found");
	        }
	    }
}
