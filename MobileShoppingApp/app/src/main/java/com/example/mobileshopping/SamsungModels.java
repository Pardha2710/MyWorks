package com.example.mobileshopping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;

public class SamsungModels extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_samsung_models);
        ImageView back = findViewById(R.id.back);
        Button sphone = findViewById(R.id.sbutton);
        back.bringToFront();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SamsungModels.this, Brands.class);
                startActivity(intent);
            }
        });
        sphone.setOnClickListener(new View.OnClickListener() {
            RadioButton radio1 = findViewById(R.id.s20);
            RadioButton radio2 = findViewById(R.id.s10e);
            RadioButton radio3 = findViewById(R.id.s9);
            SharedPreferences myPreference =
                    getSharedPreferences("MyCustomSharedPreferences2", MODE_PRIVATE);
            SharedPreferences.Editor prefEditor = myPreference.edit();

            @Override
            public void onClick(View view) {
                if (radio1.isSelected()) {
                    prefEditor.putString("value", "GalaxyS20+");
                    Intent intent = new Intent(SamsungModels.this, DataPlans.class);
                    startActivity(intent);
                } else if (radio2.isSelected()) {
                    prefEditor.putString("value", "Galaxy S10e");
                    Intent intent = new Intent(SamsungModels.this, DataPlans.class);
                    startActivity(intent);
                } else {
                    prefEditor.putString("value", "Galaxy S9");
                    Intent intent = new Intent(SamsungModels.this, DataPlans.class);
                    startActivity(intent);
                }
                prefEditor.commit();
            }

        });
    }
}