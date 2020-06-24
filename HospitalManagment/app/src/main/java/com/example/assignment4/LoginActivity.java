package com.example.assignment4;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private NurseViewModel nurseViewModel;
    private Button loginButton,registerButton;
    private EditText userTxt,passTxt;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Nurse Login");
        userTxt = findViewById(R.id.nurseIdtxt);
        passTxt = findViewById(R.id.passwordTxt);
        nurseViewModel = ViewModelProviders.of(this).get(NurseViewModel.class);
        loginButton = findViewById(R.id.btnLogin);
        registerButton = findViewById(R.id.btnReg);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Registration.class);
                startActivity(intent);
            }
        });

    }
    public void clickLogin(View view)
    {
        nurseViewModel.getAllNurses().observe(this, new Observer<List<Nurse>>() {
            @Override
            public void onChanged(@Nullable List<Nurse> result) {
            for(Nurse nurse:result)
            {
                if(nurse.getNurseId().equals(userTxt.getText().toString())
                && nurse.getPassword().equals(passTxt.getText().toString()))
                {
                    SharedPreferences myPreference =
                            getSharedPreferences("MyCustomSharedPreferences", MODE_PRIVATE);
                    SharedPreferences.Editor prefEditor = myPreference.edit();
                    prefEditor.putString("NurseId", userTxt.getText().toString());
                    prefEditor.commit();
                    count=1;
                    Intent intent=new Intent(getApplicationContext(),NurseActivity.class);
                    startActivity(intent);


                    break;
                }
            }
            if(count!=1)
            {
                Toast.makeText(LoginActivity.this,
                "Invalid UserName or Password", Toast.LENGTH_LONG).show();

            }
            }
        });
    }

}
