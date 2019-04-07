package com.example.mahmoudalzoghby.graduationproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import java.io.FileDescriptor;
import java.io.PrintWriter;

public class ClientSelection extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_selection);

        Spinner spinner = (Spinner)findViewById(R.id.Government);

        /*ArrayAdapter<String> governments = new ArrayAdapter<String>(this ,
                android.R.layout.simple_list_item_1 ,
                getResources().getStringArray(R.array.government));
        governments.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(governments);*/


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ClientSelection.this, "you are from " + adapterView.getSelectedItem().toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}
