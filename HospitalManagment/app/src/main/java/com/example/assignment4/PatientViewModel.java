package com.example.assignment4;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class PatientViewModel extends AndroidViewModel {
    private PatientRepository patientRepository;
    private LiveData<Integer> insertResult;
    private LiveData<List<Patient>> allPatients;
    public PatientViewModel(@NonNull Application application) {
        super(application);
        patientRepository=new PatientRepository(application);
        insertResult=patientRepository.getInsertResult();
        allPatients=patientRepository.getAllPatients();
    }

    public void insert(Patient patient)
    {
        patientRepository.insert(patient);
    }
    public LiveData<Integer> getInsertResult() {
        return insertResult;
    }
    LiveData<List<Patient>> getAllPatients()
    {
        return allPatients;
    }

}
