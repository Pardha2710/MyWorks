package com.example.assignment4;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class ViewTestData extends AppCompatActivity {

private NPTestViewModel npTestViewModel;
private TextView textView;
private EditText editText;
private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_test_data);
        setTitle("Test Details");
npTestViewModel= ViewModelProviders.of(this).get(NPTestViewModel.class);
textView=findViewById(R.id.textView);
editText=findViewById(R.id.editText);
button=findViewById(R.id.button);

    }
    public void find(View view)
    {
        final String testId=editText.getText().toString();
    npTestViewModel.getAllNPTests().observe(this, new Observer<List<NPTest>>() {
    @Override
    public void onChanged(@Nullable List<NPTest> test) {
    String display="No Matching Record Found";
    for(NPTest t:test)
    {
        display="No Matching Record Found";
        if(t.getNptestId().equals(testId))
        {
            display="\n"+"Test ID: "+t.getNptestId()+"\n\n"+
                    "Nurse ID: "+t.getNurseId()+"\n\n"+
                    "Patient ID: "+t.getPatientId()+"\n\n"+
                    "BP Status: "+t.getBpRate()+"\n\n"+
                    "Temperature: "+t.getTemperature()+"\n\n";
            break;
        }

    }
    textView.setText(display);
    }
});
    }
}
