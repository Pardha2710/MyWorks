package com.example.mobileshopping;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class DataPlans extends AppCompatActivity implements MyAdapter.SelectedPlan {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;

    private List<ListItem> listItems;
    String[] plans={"5G","Wireless Plans","Home Internet Plans"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_plans);
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        listItems=new ArrayList<>();


       for(String s:plans)
       {
            ListItem listItem=new ListItem(s);
            listItems.add(listItem);
       }
        mAdapter=new MyAdapter(listItems,this);
        recyclerView.setAdapter(mAdapter);

    }

    @Override
    public void selectedPlan(ListItem listItem) {
        SharedPreferences myPreference =
                getSharedPreferences("MyCustomSharedPreferences3", MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = myPreference.edit();
        prefEditor.putString("value",listItem.getPlan());
        prefEditor.commit();
        startActivity(new Intent(DataPlans.this,CustomerInfo.class));
    }


}