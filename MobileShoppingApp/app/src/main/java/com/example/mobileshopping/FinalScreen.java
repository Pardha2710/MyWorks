package com.example.mobileshopping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class FinalScreen extends AppCompatActivity {

    TextView fullname,cityName,postalName,phone,brandName,modelName,planName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_screen);

        fullname=findViewById(R.id.nameV);
        cityName=findViewById(R.id.cityV);
        postalName=findViewById(R.id.postalV);
        phone=findViewById(R.id.phoneV);
        brandName=findViewById(R.id.brandV);
        modelName=findViewById(R.id.modelV);
        planName=findViewById(R.id.planV);

        SharedPreferences myPref1 = getSharedPreferences("MyCustomSharedPreferences1", MODE_PRIVATE);
        SharedPreferences myPref2 = getSharedPreferences("MyCustomSharedPreferences2", MODE_PRIVATE);
        SharedPreferences myPref3 = getSharedPreferences("MyCustomSharedPreferences3", MODE_PRIVATE);

        String brands=myPref1.getString("value","");
        String models=myPref2.getString("value","");
        String plans=myPref3.getString("value","");
        brandName.setText(brands);
        modelName.setText(models);
        planName.setText(plans);
        Intent intent=getIntent();
        Bundle b=intent.getExtras();

        if(b!=null)
        {
            fullname.setText(b.get("name").toString());
            cityName.setText(b.get("city").toString());
            postalName.setText(b.get("post").toString());
            phone.setText(b.get("phone").toString());
        }


    }
}