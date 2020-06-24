package com.example.assignment4;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;

import java.util.List;

public class NPTestRepository {

    private final HospitalDao hospitalDao;
    private MutableLiveData<Integer> insertResult = new MutableLiveData<Integer>();
    private LiveData<List<NPTest>> nptestsList;

    public NPTestRepository(Context context)
    {
        AppDatabase db=AppDatabase.getInstance(context);
        hospitalDao=db.hospitalDao();
        nptestsList=hospitalDao.getAllNPTests();

    }
    LiveData<List<NPTest>> getAllNPTests()
    {
        return nptestsList;
    }
     public void insert(NPTest npTest)
     {
         insertAsync(npTest);
     }

    public LiveData<Integer> getInsertResult() {
        return insertResult;
    }

    private void insertAsync(final NPTest npTest)
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try
                {
                    hospitalDao.insert(npTest);
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
