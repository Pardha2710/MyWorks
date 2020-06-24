package com.example.assignment4;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;

import java.util.List;

public class NurseRepository {
    private final HospitalDao hospitalDao;
    private MutableLiveData<Integer> insertResult = new MutableLiveData<Integer>();
    private LiveData<List<Nurse>> nursesList;
    private String value;

    public NurseRepository(Context context)
    {
        AppDatabase db=AppDatabase.getInstance(context);
        hospitalDao=db.hospitalDao();
        nursesList=hospitalDao.getAllNurses();

    }
    LiveData<List<Nurse>> getAllNurses()
    {
        return nursesList;
    }
    public void insert(Nurse nurse)
    {
        insertAsync(nurse);
    }

    public LiveData<Integer> getInsertResult() {
        return insertResult;
    }

    private void insertAsync(final Nurse nurse)
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try
                {
                    hospitalDao.insert(nurse);
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
