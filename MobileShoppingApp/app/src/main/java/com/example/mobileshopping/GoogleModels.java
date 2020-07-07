package com.example.mobileshopping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;

public class GoogleModels extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_models);
        ImageView back=findViewById(R.id.back);
        Button gphone=findViewById(R.id.gbutton);

        back.bringToFront();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(GoogleModels.this,Brands.class);
                startActivity(intent);
            }
        });

        gphone.setOnClickListener(new View.OnClickListener() {
            RadioButton radio1 = findViewById(R.id.pixel4);
            RadioButton radio2 = findViewById(R.id.pixel3);
            RadioButton radio3 = findViewById(R.id.nexus5);
            SharedPreferences myPreference =
                    getSharedPreferences("MyCustomSharedPreferences2", MODE_PRIVATE);
            SharedPreferences.Editor prefEditor = myPreference.edit();

            @Override
            public void onClick(View view) {
                if (radio1.isSelected()) {
                    prefEditor.putString("value", "Pixel-4");

                    Intent intent = new Intent(GoogleModels.this, DataPlans.class);
                    startActivity(intent);
                } else if (radio2.isSelected()) {
                    prefEditor.putString("value", "Pixel-3");

                    Intent intent = new Intent(GoogleModels.this, DataPlans.class);
                    startActivity(intent);
                } else {
                    prefEditor.putString("value", "Nexus-5");

                    Intent intent = new Intent(GoogleModels.this, DataPlans.class);
                    startActivity(intent);
                }

                prefEditor.commit();
            }

        });
    }
}