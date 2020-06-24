package com.example.assignment4;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Nurse.class,Patient.class,NPTest.class},version = 1,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static volatile AppDatabase INSTANCE;
    private static final String DATABASE_NAME="HospitalDB";
    public abstract HospitalDao hospitalDao();

    public static synchronized AppDatabase getInstance(Context context)
    {
        if(INSTANCE==null)
        {
            INSTANCE= Room.databaseBuilder(context,AppDatabase.class,DATABASE_NAME).build();

        }
        return INSTANCE;
    }


}
