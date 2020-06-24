package com.example.assignment4;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity
public class NPTest {

    @PrimaryKey
    @NonNull
    private String nptestId;


    private String nurseId;


    private String patientId;
    private String bpRate;
    private String temperature;

    public String getNptestId() {
        return nptestId;
    }

    public String getNurseId() {
        return nurseId;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getBpRate() {
        return bpRate;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setNptestId(String nptestId) {
        this.nptestId = nptestId;
    }

    public void setNurseId(String nurseId) {
        this.nurseId = nurseId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public void setBpRate(String bpRate) {
        this.bpRate = bpRate;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }
}
