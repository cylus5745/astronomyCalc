package com.example.root.astronomycalc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class choose extends AppCompatActivity implements OnItemSelectedListener{
    Spinner tele_type;
    //flag is for the inversion of the image in reflector needs to be either 1 or -1
    int flag = 0;
    Button submit_type;
    String item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        tele_type = (Spinner) findViewById(R.id.spinner);
        tele_type.setOnItemSelectedListener(this);
        //Populate the spinner
        List<String> types = new ArrayList<>();
        types.add("Reflector");
        types.add("Refractor");
        //Create Adapter
        ArrayAdapter<String> typeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, types);
        //Drop-down Layout Style
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Attach adapter to spinner
        tele_type.setAdapter(typeAdapter);

    }
    //----Necessary override
    //To get the type of telescope
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        item = parent.getItemAtPosition(position).toString();
    }
    //----Necessary override
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public void onClick(View view) {
        if (item.equals("Reflector")) {
            Intent ref = new Intent(choose.this, reflector.class);
            startActivity(ref);
            flag = -1;
        }

        if (item.equals("Refractor")) {
            Intent ref = new Intent(choose.this, reflector.class);
            startActivity(ref);
            flag = 1;
        }
    }
}
