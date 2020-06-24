package com.example.assignment4;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class NPTestViewModel extends AndroidViewModel {
    private NPTestRepository npTestRepository;
    private LiveData<Integer> insertResult;
    private LiveData<List<NPTest>> allNPTests;
    public NPTestViewModel(@NonNull Application application) {
        super(application);
        npTestRepository=new NPTestRepository(application);
        insertResult=npTestRepository.getInsertResult();
        allNPTests=npTestRepository.getAllNPTests();
    }
     public void insert(NPTest npTest)
     {
         npTestRepository.insert(npTest);
     }

    public LiveData<Integer> getInsertResult() {
        return insertResult;
    }
    LiveData<List<NPTest>> getAllNPTests()
    {
        return allNPTests;
    }
    }
