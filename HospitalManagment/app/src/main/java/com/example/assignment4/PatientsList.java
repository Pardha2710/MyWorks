package com.example.assignment4;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class PatientsList extends AppCompatActivity {

private PatientViewModel patientViewModel;
private TextView textView;
private EditText patientIdText;
private Button viewPatient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patients_list);
        setTitle("Patients List");
        patientViewModel= ViewModelProviders.of(this).get(PatientViewModel.class);
        textView=findViewById(R.id.txtDisplay);
        patientIdText=findViewById(R.id.testIdTxt);
        viewPatient=findViewById(R.id.button);

    }
    public void findPatient(View view)
    {
        final String patientId=patientIdText.getText().toString();
        patientViewModel.getAllPatients().observe(this, new Observer<List<Patient>>() {
            @Override
            public void onChanged(@Nullable List<Patient> patients) {
                String display="No Matching Data Found";
                for (Patient p : patients) {
                    if (p.getPatientId().equals(patientId)) {
                       display=
                                "Patient ID:" + p.getPatientId() + "\n" +
                                        "Patient Name:" + p.getFirstName() + " " + p.getLastName() + "\n" +
                                        "Department:" + p.getDepartment() + "\n" + "Room No:" + p.getRoom() + "\n";
                        break;
                    }

                }
                textView.setText(display);

            }
        });
        }
    }
