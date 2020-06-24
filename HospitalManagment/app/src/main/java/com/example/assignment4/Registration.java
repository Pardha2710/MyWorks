package com.example.assignment4;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity {

    NurseViewModel nurseViewModel;
    Nurse nurse;
    EditText id,fName,lName,dept,pasw;
    Button regi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        setTitle("Nurse Registration");
        nurseViewModel= ViewModelProviders.of(this).get(NurseViewModel.class);
        nurse=new Nurse();
        id=findViewById(R.id.txtTId);
        fName=findViewById(R.id.txtPId);
        lName=findViewById(R.id.txtNId);
        dept=findViewById(R.id.txtBP);
        pasw=findViewById(R.id.txtPass);

        regi=findViewById(R.id.btnEnter);

        regi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nurse.setNurseId(id.getText().toString());
                nurse.setFirstName(fName.getText().toString());
                nurse.setLastName(lName.getText().toString());
                nurse.setDepartment(dept.getText().toString());
                nurse.setPassword(pasw.getText().toString());
                nurseViewModel.insert(nurse);
            }
        });
        nurseViewModel.getInsertResult().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer result) {
                if (result == 1) {
                    Toast.makeText(Registration.this, "Nurse successfully saved", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(Registration.this, "Error saving Nurse", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
