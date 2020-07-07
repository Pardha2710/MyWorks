package com.example.mobileshopping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

public class IphoneModels extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iphone_models);
        Button iphone = findViewById(R.id.ibutton);

        ImageView back = findViewById(R.id.back);

        back.bringToFront();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IphoneModels.this, Brands.class);
                startActivity(intent);
            }
        });
        iphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences myPreference =
                        getSharedPreferences("MyCustomSharedPreferences2", MODE_PRIVATE);
                SharedPreferences.Editor prefEditor = myPreference.edit();
                RadioButton radio1 = findViewById(R.id.iphoneX);
                RadioButton radio2 = findViewById(R.id.iphone8);
                RadioButton radio3 = findViewById(R.id.iphone7);
                if (radio1.isChecked()) {
                    prefEditor.putString("value", "IphoneX");
                    Intent intent = new Intent(IphoneModels.this, DataPlans.class);
                            startActivity(intent);
                }
                else if (radio2.isChecked()) {
                    prefEditor.putString("value", "Iphone8");
                            Intent intent = new Intent(IphoneModels.this, DataPlans.class);
                            startActivity(intent);
                        }
                else if (radio3.isChecked()) {
                    prefEditor.putString("value", "Iphone7");

                            Intent intent = new Intent(IphoneModels.this, DataPlans.class);
                            startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Select Model", Toast.LENGTH_SHORT).show();
                }
                prefEditor.commit();

            }
        });
    }
}