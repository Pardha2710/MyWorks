package com.example.mobileshopping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class Brands extends AppCompatActivity {

    private String brandN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brands);
        ImageView back=findViewById(R.id.back);
        back.bringToFront();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Brands.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        SharedPreferences myPreference =
                getSharedPreferences("MyCustomSharedPreferences1", MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = myPreference.edit();
        switch (item.getItemId())
        {
            case R.id.Iphone:
                Intent intent = new Intent(Brands.this, IphoneModels.class);
                brandN="Iphone";
                prefEditor.putString("value",brandN);
                prefEditor.commit();
                Log.i("brand","1.Brand here..."+brandN);
                startActivity(intent);
                return true;
            case R.id.Samsung:
                Intent intent1 = new Intent(Brands.this, SamsungModels.class);
                brandN="Samsung";
                prefEditor.putString("value",brandN);
                prefEditor.commit();
                Log.i("brand","2.Brand here..."+brandN);
                startActivity(intent1);
                return true;
            case R.id.Google:
                Intent intent3 = new Intent(Brands.this, GoogleModels.class);
                brandN="Google";
                prefEditor.putString("value",brandN);
                prefEditor.commit();
                Log.i("brand","3.Brand here..."+brandN);
                startActivity(intent3);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }


}