package com.example.assignment4;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;

import java.util.List;

public class PatientRepository {
    private final HospitalDao hospitalDao;
    private MutableLiveData<Integer> insertResult = new MutableLiveData<Integer>();
    private LiveData<List<Patient>> patientsList;

    public PatientRepository(Context context) {
        AppDatabase db=AppDatabase.getInstance(context);
        hospitalDao=db.hospitalDao();
        patientsList=hospitalDao.getAllPatients();
    }

    LiveData<List<Patient>> getAllPatients()
    {
        return patientsList;
    }

    public void insert(Patient patient)
    {
        insertAsync(patient);
    }

    public LiveData<Integer> getInsertResult() {
        return insertResult;
    }

    private void insertAsync(final Patient patient)
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try
                {
                    hospitalDao.insert(patient);
                    insertResult.postValue(1);
                }
                catch (Exception e)
                {
                    insertResult.postValue(0);
                }
            }
        }).start();
    }

}
