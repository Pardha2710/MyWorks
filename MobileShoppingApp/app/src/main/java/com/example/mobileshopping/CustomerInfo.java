package com.example.mobileshopping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;

public class CustomerInfo extends AppCompatActivity {

    private EditText fullName,cityName,postalCode,phoneNumber,cvvNumber,expiryDate;
    private Spinner cards;
    private Button placeAnOrder,goBack;
    private AwesomeValidation awesomeValidation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_info);
        fullName=findViewById(R.id.name);
        cityName=findViewById(R.id.city);
        postalCode=findViewById(R.id.postal);
        phoneNumber=findViewById(R.id.phone);
        cvvNumber=findViewById(R.id.cvv);
        expiryDate=findViewById(R.id.expiry);
        cards=findViewById(R.id.cardsV);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.cardType,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cards.setAdapter(adapter);
        cards.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String text=adapterView.getItemAtPosition(i).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        placeAnOrder=findViewById(R.id.order);
        goBack=findViewById(R.id.back);

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        awesomeValidation.addValidation(this, R.id.name, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.phone, "^[2-9]{2}[0-9]{8}$", R.string.mobileerror);
        awesomeValidation.addValidation(this, R.id.city, "^[a-zA-Z]+(?:[\\s-][a-zA-Z]+)*$", R.string.cityerror);
        awesomeValidation.addValidation(this, R.id.postal, "^(?!.*[DFIOQU])[A-VXY][0-9][A-Z] ?[0-9][A-Z][0-9]$", R.string.postalerror);

        placeAnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(view==placeAnOrder)
                {
                    submitForm();
                }

            }
        });

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private final void submitForm(){
        if (awesomeValidation.validate())
        {
            final String name=fullName.getText().toString();
            final String city=cityName.getText().toString();
            final String post=postalCode.getText().toString();
            final String phone=phoneNumber.getText().toString();
            final String cvvN=cvvNumber.getText().toString();
            final String expire=expiryDate.getText().toString();

            Intent intent=new Intent(CustomerInfo.this,FinalScreen.class);
            intent.putExtra("name",name);
            intent.putExtra("city",city);
            intent.putExtra("post",post);
            intent.putExtra("phone",phone);
            startActivity(intent);
        }
    }
}