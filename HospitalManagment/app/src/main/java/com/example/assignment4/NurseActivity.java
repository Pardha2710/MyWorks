package com.example.assignment4;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class NurseActivity extends AppCompatActivity {
TextView textView;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nurse);
        setTitle("Nurse Activity");
        SharedPreferences myPref = getSharedPreferences("MyCustomSharedPreferences", MODE_PRIVATE);
        String myString = myPref.getString("NurseId","");
        TextView tView = (TextView)findViewById(R.id.txtIdView);
        tView.setText("Welcome: "+myString);

        listView=findViewById(R.id.lstVw);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                {
                    Intent intent=new Intent(getApplicationContext(),PatientActivity.class);
                    startActivity(intent);
                }
                else if(position==1)
                {
                    Intent intent=new Intent(getApplicationContext(),NPTestActivity.class);
                    startActivity(intent);
                }

            }
        });
    }
}
