package com.example.mahmoudalzoghby.graduationproject;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class WorkerProfile extends AppCompatActivity {

    private Integer[] image ;
    private ImageView []imageView ;


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker_profile);

        ListView list = (ListView)findViewById(R.id.list_of_picture);

        list.setAdapter(
                new ArrayAdapter<ImageView>(
                        getApplicationContext(),
                        android.R.layout.simple_list_item_1,
                        imageView
                )
        );

    }
}
