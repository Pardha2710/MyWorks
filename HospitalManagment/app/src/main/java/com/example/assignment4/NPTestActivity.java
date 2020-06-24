package com.example.assignment4;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NPTestActivity extends AppCompatActivity{
    NPTest npTest;
    NPTestViewModel npTestViewModel;
    EditText testId,testNId,testPId,testBp,testTemp;
    Button testAdd,testView;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nptest);
        setTitle("Test Form");
        npTestViewModel= ViewModelProviders.of(this).get(NPTestViewModel.class);
        npTest=new NPTest();
        testId=findViewById(R.id.txtTId);
        testNId=findViewById(R.id.txtNuId);
        testPId=findViewById(R.id.txtPId);
        testBp=findViewById(R.id.txtBP);
        testTemp=findViewById(R.id.txtTemp);
        testAdd=findViewById(R.id.btnEnter);
        testView=findViewById(R.id.btnView);
        SharedPreferences myPref = getSharedPreferences("MySharedPreferences", MODE_PRIVATE);
        final String myString1 = myPref.getString("PatientId","");
        final String myString2=myPref.getString("IdNurse","");


        testAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                npTest.setNptestId(testId.getText().toString());
                npTest.setNurseId(myString2);
                npTest.setPatientId(myString1);
                npTest.setBpRate(testBp.getText().toString());
                npTest.setTemperature(testTemp.getText().toString());
                npTestViewModel.insert(npTest);
            }
        });
        npTestViewModel.getInsertResult().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer result) {
                if(result==1)
                {
                    Toast.makeText(NPTestActivity.this, "Test successfully saved", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(getApplicationContext(),NurseActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(NPTestActivity.this, "Error saving test", Toast.LENGTH_SHORT).show();
                }
            }
        });
testView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(getApplicationContext(),ViewTestData.class);
        startActivity(intent);
    }
});
    }
    public void getList(View view)
    {
        npTestViewModel.getAllNPTests();
    }
}