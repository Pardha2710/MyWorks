package com.example.assignment4;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class NurseViewModel extends AndroidViewModel {

    private NurseRepository nurseRepository;
    private LiveData<Integer> insertResult;
    private LiveData<List<Nurse>> allNurses;

    public NurseViewModel(@NonNull Application application) {

        super(application);
        nurseRepository=new NurseRepository(application);
        insertResult=nurseRepository.getInsertResult();
        allNurses=nurseRepository.getAllNurses();
    }

    public void insert(Nurse nurse)
    {
        nurseRepository.insert(nurse);
    }

    public LiveData<Integer> getInsertResult() {
        return insertResult;
    }

    LiveData<List<Nurse>> getAllNurses()
    {
        return allNurses;
    }
}
