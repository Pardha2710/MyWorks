package com.example.assignment4;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class PatientActivity extends AppCompatActivity {

    Patient patient;
    PatientViewModel patientViewModel;
    EditText pId,pFName,pLName,pDept,pNuId,pRoom;
    Button pAdd,pView,pUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);
        setTitle("Patient Form");

        patientViewModel= ViewModelProviders.of(this).get(PatientViewModel.class);
        patient=new Patient();
        pId=findViewById(R.id.txtTId);
        pFName=findViewById(R.id.txtPId);
        pLName=findViewById(R.id.txtNId);
        pDept=findViewById(R.id.txtBP);
        pNuId=findViewById(R.id.txtNuId);
        pRoom=findViewById(R.id.txtRoom);
        pAdd=findViewById(R.id.btnEnter);
        pUpdate=findViewById(R.id.btnUpdate);
        pView=findViewById(R.id.btnView);

        SharedPreferences myPref = getSharedPreferences("MyCustomSharedPreferences", MODE_PRIVATE);
        final String myString = myPref.getString("NurseId","");
        pNuId.setText(myString, TextView.BufferType.EDITABLE);
        pAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            patient.setPatientId(pId.getText().toString());
            patient.setFirstName(pFName.getText().toString());
            patient.setLastName(pLName.getText().toString());
            patient.setDepartment(pDept.getText().toString());
            patient.setNurseId(myString);
            patient.setRoom(pRoom.getText().toString());
            patientViewModel.insert(patient);
            }
        });
        patientViewModel.getInsertResult().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer result) {
                if (result == 1) {
                    SharedPreferences myPreference =
                            getSharedPreferences("MySharedPreferences", MODE_PRIVATE);
                    SharedPreferences.Editor prefEditor = myPreference.edit();
                    prefEditor.putString("PatientId", pId.getText().toString());
                    prefEditor.putString("IdNurse",pNuId.getText().toString());
                    prefEditor.commit();
                    Toast.makeText(PatientActivity.this, "Patient successfully saved", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(getApplicationContext(),NurseActivity.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(PatientActivity.this, "Error saving Patient", Toast.LENGTH_SHORT).show();
                }
            }
        });
        pUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
pView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(getApplicationContext(),PatientsList.class);
        startActivity(intent);
    }
});
    }
    public void getList(View view)
    {

        patientViewModel.getAllPatients();

    }

}
