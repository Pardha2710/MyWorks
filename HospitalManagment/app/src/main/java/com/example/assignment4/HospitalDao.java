package com.example.assignment4;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface HospitalDao {

@Insert
    void insert(Nurse nurse);

@Query("Select * from Nurse")
    LiveData<List<Nurse>> getAllNurses();

@Insert
    void insert(Patient patient);



@Query("Select * from Patient")
    LiveData<List<Patient>> getAllPatients();

@Insert
    void  insert(NPTest npTest);

    @Query("Select * from NPTest")
    LiveData<List<NPTest>> getAllNPTests();



}
