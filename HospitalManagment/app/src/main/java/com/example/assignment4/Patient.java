package com.example.assignment4;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = Nurse.class,
parentColumns = "nurseId",
childColumns = "nurseId",
onDelete=ForeignKey.CASCADE,onUpdate =ForeignKey.CASCADE ),
indices = @Index(value = "nurseId"))


public class Patient {

    @PrimaryKey
    @NonNull
    private String patientId;
    private String firstName;
    private String lastName;
    private String department;

    @ColumnInfo(name="nurseId")
    private String nurseId;
    private String room;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getNurseId() {
        return nurseId;
    }

    public void setNurseId(String nurseId) {
        this.nurseId = nurseId;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}
